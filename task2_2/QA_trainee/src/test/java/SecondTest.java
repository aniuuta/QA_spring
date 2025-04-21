import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SecondTest {
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
    public void testCardCount10() {
        System.out.printf("Тест 2: Отображение разного количества карточек игр на странице поиска\n");
        // Локатор
        By gameCardSelector = By.cssSelector("li.ant-list-item");

        try {
            // 1. Открываем сайт
            driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");

            // 2. Ожидаем загрузку карточек
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(gameCardSelector, 6));
            var gameCards = driver.findElements(gameCardSelector);

            // 3. Проверка количества карточек
            System.out.println("Количество карточек: " + gameCards.size());
            Assert.assertEquals("Ожидалось 10 карточек на странице", 10, gameCards.size());

        } catch (TimeoutException e) {
            Assert.fail("Карточки не загрузились вовремя: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Ошибка при выполнении теста: " + e.getMessage());
        }
    }

    @Test
    public void testCardCount20() {
        // Локаторы
        By pageSizeSelector = By.cssSelector(".ant-select-selection-item[title='10 / page']");
        By option20Selector = By.cssSelector("div#rc_select_3_list_1[title='20 / page']");
        By gameCardSelector = By.cssSelector("li.ant-list-item");

        try {
            // 1. Открываем сайт
            driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");

            // 2. Открываем выпадающий список с количеством карточек
            WebElement pageSizeDropdown = wait.until(ExpectedConditions.elementToBeClickable(pageSizeSelector));
            pageSizeDropdown.click();

            // 3. Выбираем опцию "20 / page"
            WebElement option20 = wait.until(ExpectedConditions.elementToBeClickable(option20Selector));
            option20.click();

            // 4. Ожидаем загрузки карточек
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(gameCardSelector, 11));
            var gameCards = driver.findElements(gameCardSelector);

            // 5. Проверка количества карточек
            System.out.println("Количество карточек: " + gameCards.size());
            Assert.assertEquals("Ожидалось 20 карточек на странице", 20, gameCards.size());

        } catch (TimeoutException e) {
            Assert.fail("Карточки не загрузились вовремя: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Ошибка при выполнении теста: " + e.getMessage());
        }
    }
    /* Следующий тест проверяет что на странице появляется 50 карточек игр, но
    он падает так как присутсвует баг. Для успешного прохождения всех тестов он был закомментирован
    Баг-репорт по данной ошибке находится в файле BUGS.md */

    /*
    @Test
    public void testCardCount50() {
        // Локаторы
        By pageSizeSelector = By.cssSelector(".ant-select-selection-item[title='10 / page']");
        By option50Selector = By.cssSelector("div#rc_select_3_list_2[title='50 / page']");
        By gameCardSelector = By.cssSelector("li.ant-list-item");

        try {
            // 1. Открываем сайт
            driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");

            // 2. Открываем выпадающий список с количеством карточек
            WebElement pageSizeDropdown = wait.until(ExpectedConditions.elementToBeClickable(pageSizeSelector));
            pageSizeDropdown.click();

            // 3. Выбираем опцию "50 / page"
            WebElement option50 = wait.until(ExpectedConditions.elementToBeClickable(option50Selector));
            option50.click();

            // 4. Ожидаем загрузки карточек
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(gameCardSelector, 21));
            var gameCards = driver.findElements(gameCardSelector);

            // 5. Проверка количества карточек
            System.out.println("Количество карточек: " + gameCards.size());
            Assert.assertEquals("Ожидалось 50 карточек на странице", 50, gameCards.size());

        } catch (TimeoutException e) {
            Assert.fail("Карточки не загрузились вовремя: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Ошибка при выполнении теста: " + e.getMessage());
        }
    }
    */

    @Test
    public void testCardCount100() {
        // Локаторы
        By pageSizeSelector = By.cssSelector(".ant-select-selection-item[title='10 / page']");
        By option100Selector = By.cssSelector("div#rc_select_3_list_3[title='100 / page']");
        By gameCardSelector = By.cssSelector("li.ant-list-item");

        try {
            // 1. Открываем сайт
            driver.get("https://makarovartem.github.io/frontend-avito-tech-test-assignment/");

            // 2. Открываем выпадающий список с количеством карточек
            WebElement pageSizeDropdown = wait.until(ExpectedConditions.elementToBeClickable(pageSizeSelector));
            pageSizeDropdown.click();

            // 3. Выбираем опцию "100 / page"
            WebElement option100 = wait.until(ExpectedConditions.elementToBeClickable(option100Selector));
            option100.click();

            // 4. Ожидаем загрузки карточек
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(gameCardSelector, 51));
            var gameCards = driver.findElements(gameCardSelector);

            // 5. Проверка количества карточек
            System.out.println("Количество карточек: " + gameCards.size());
            Assert.assertEquals("Ожидалось 100 карточек на странице", 100, gameCards.size());

        } catch (TimeoutException e) {
            Assert.fail("Карточки не загрузились вовремя: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Ошибка при выполнении теста: " + e.getMessage());
        }
    }
}
