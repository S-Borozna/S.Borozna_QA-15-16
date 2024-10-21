import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

class mtsTest123 {
    public static MtsMainPage mtsMainPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Svetlana\\Downloads\\chromedriver-win64\\" +
                "chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        mtsMainPage = new MtsMainPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
    }

    @Test
    @DisplayName("Проверка названия блока")
    public void testBlockName() {
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", mtsMainPage.getBlockName(),
                "Название блока не соответсвует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentSystemLogos() {
        List<WebElement> logos = new ArrayList<>(Arrays.asList(mtsMainPage.logoVisa, mtsMainPage.logoBelcard,
                mtsMainPage.logoMasterCard, mtsMainPage.logoMasterSecCode, mtsMainPage.logoVerByVisa));
        Assertions.assertFalse(logos.isEmpty(), "Логотипы платёжных систем отстутсвуют");
    }

    @Test
    @DisplayName("Проверка работоспособности ссылки 'Подробнее о сервисе'")
    public void testAboutService() {
        WebElement btnCookie = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        btnCookie.click();
        mtsMainPage.abServise();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl(), "Ссылка 'Подробнее о сервисе' не открывает ожидаемую старницу");
    }


    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
