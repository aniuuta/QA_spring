import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ThirdTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPaginationNavigation() {
        System.out.printf("Тест 3: Переход по страницам результата поиска с помощью пагинации\n");
        // Локаторы
        By gameCardSelector = By.cssSelector("li.ant-list-item");
        By page2ButtonLocator = By.linkText("2");
        By nextFivePagesLocator = By.xpath("//span[@class='ant-pagination-item-ellipsis' and text()='•••']");
        By page7ButtonLocator = By.cssSelector("li.ant-pagination-item-7 a");
        By prevPageButtonLocator = By.cssSelector("li.ant-pagination-prev button");
        By nextPageButtonLocator = By.cssSelector("li.ant-pagination-next button");
        By activePageLocator = By.cssSelector("li.ant-pagination-item-active");

        // Открываем сайт
        driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");
        System.out.println("Открыт сайт");

        // Убеждаемся, что первая страница загружена
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(gameCardSelector, 6));
        var firstPageCards = driver.findElements(gameCardSelector);
        System.out.println("Первая страница загружена, карточек: " + firstPageCards.size());

        // Переход на страницу 2
        WebElement page2Button = wait.until(ExpectedConditions.elementToBeClickable(page2ButtonLocator));
        page2Button.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activePageLocator, "2"));
        System.out.println("Перешли на страницу 2");

        // Нажимаем "..." для перехода на следующие страницы
        WebElement nextFivePages = wait.until(ExpectedConditions.elementToBeClickable(nextFivePagesLocator));
        nextFivePages.click();
        System.out.println("Нажали кнопку '...' для перехода на 5 страниц вперед");

        // Переход на страницу 7
        WebElement page7Button = wait.until(ExpectedConditions.elementToBeClickable(page7ButtonLocator));
        page7Button.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activePageLocator, "7"));
        System.out.println("Перешли на страницу 7");

        // Назад → страница 6
        WebElement prevButton = wait.until(ExpectedConditions.elementToBeClickable(prevPageButtonLocator));
        prevButton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activePageLocator, "6"));
        System.out.println("Перешли на страницу 6 через кнопку 'Назад'");

        // Вперёд 2 раза → страница 8
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextPageButtonLocator));
        nextButton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activePageLocator, "7"));
        System.out.println("Перешли на страницу 7 через кнопку 'Вперёд'");

        nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextPageButtonLocator));
        nextButton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activePageLocator, "8"));
        System.out.println("Перешли на страницу 8 через кнопку 'Вперёд'");

        // Проверка финального состояния
        WebElement activePage = driver.findElement(activePageLocator);
        String currentPage = activePage.findElement(By.tagName("a")).getText();
        Assert.assertEquals("Должна быть активна страница 8", "8", currentPage);
    }
}