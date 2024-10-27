import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

class MtsTest {
    public static MtsMainPage mtsMainPage;
    public static BepaidIframePage bepaidIframePage;
    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        mtsMainPage = new MtsMainPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mtsMainPage.btnCookie();
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
        mtsMainPage.abServise();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl(), "Ссылка 'Подробнее о сервисе' не открывает ожидаемую старницу");
    }

    @Test
    @DisplayName("Проверка работоспособности кнопки 'Продолжить'")
    public void testBtnContinue() {
        mtsMainPage.sK("297777777", "29");
        wait.until(driver1 -> driver.switchTo().frame(2));
        Assertions.assertTrue(mtsMainPage.disPaymentWindow(), "Кнопка продолжить не открыла окно оплаты");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Услуги связи'")
    public void testCommunicationServices() {
        Assertions.assertEquals("Номер телефона", mtsMainPage.placeNumber(),
                "Плэйсхолдер поля 'номер телефона' не соответсвует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSum(),
                "Плэйсхолдер поля 'сумма' не соответсвует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmail(),
                "Плэйсхолдер поля 'E-mail' не соответсвует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Домашний интернет'")
    public void testHomeInternet() {
        mtsMainPage.getHomeInternet();
        Assertions.assertEquals("Номер абонента", mtsMainPage.placeNumHomeInter(),
                "Плэйсхолдер поля 'номер абонента' не соответсвует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSumHomeInter(),
                "Плэйсхолдер поля 'сумма' не соответсвует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmailHomeInter(),
                "Плэйсхолдер поля 'E-mail' не соответсвует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Рассрочка'")
    public void testInstallmentPlan() {
        mtsMainPage.getInstallmentPlan();
        Assertions.assertEquals("Номер счета на 44", mtsMainPage.placeNumInstalPlan(),
                "Плэйсхолдер поля 'номер абонента' не соответсвует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSumInstalPlan(),
                "Плэйсхолдер поля 'сумма' не соответсвует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmailInstalPlan(),
                "Плэйсхолдер поля 'E-mail' не соответсвует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Рассрочка'")
    public void testDebt() {
        mtsMainPage.getDebt();
        Assertions.assertEquals("Номер счета на 2073", mtsMainPage.placeNumDebt(),
                "Плэйсхолдер поля 'номер абонента' не соответсвует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSumDebt(),
                "Плэйсхолдер поля 'сумма' не соответсвует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmailDebt(),
                "Плэйсхолдер поля 'E-mail' не соответсвует ожидаемому.");
    }

    @ParameterizedTest
    @DisplayName("Окно оплаты")
    @ValueSource(strings = "297777777")
    public void testPaymentWindow(String num) {
        mtsMainPage.sK(num, "29");
        wait.until(driver1 -> driver.switchTo().frame(2));
        bepaidIframePage = new BepaidIframePage(driver);
        Assertions.assertTrue(bepaidIframePage.getNumber().contains(num), "Введенный номер телефона не отображается");
        Assertions.assertTrue(bepaidIframePage.getSumma().contains("29"), "Введенная сумма не отображается");
        Assertions.assertTrue(bepaidIframePage.getBtnPay().contains("29"), "Введенная сумма не отображается на кнопке оплаты");
        Assertions.assertEquals("Номер карты", bepaidIframePage.getNumCard(),
                "Текст поля 'Номер карты' не соответсвует ожидаемому.");
        Assertions.assertEquals("Срок действия", bepaidIframePage.getValidityPeriod(),
                "Текст поля 'Срок действия' не соответсвует ожидаемому.");
        Assertions.assertEquals("CVC", bepaidIframePage.getCvc(),
                "Текст поля 'CVC' не соответсвует ожидаемому.");
        Assertions.assertEquals("Имя держателя (как на карте)", bepaidIframePage.getHolderName(),
                "Текст поля 'Имя держателя' не соответсвует ожидаемому.");
        Assertions.assertTrue(bepaidIframePage.getVisaLogo(), "Логотип Visa не отображается");
        Assertions.assertTrue(bepaidIframePage.getMasterCardLogo(), "Логотип MasterCard не отображается");
        Assertions.assertTrue(bepaidIframePage.getBelcartLogo(), "Логотип Белкаре не отображается");
        Assertions.assertTrue(bepaidIframePage.getLogo(), "Логотип не отображается");
    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
