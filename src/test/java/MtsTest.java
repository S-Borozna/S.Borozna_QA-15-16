import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Feature("Тесты связанные с блоком 'Онлайн пополнение без комиссии'")
class MtsTest {
    public static MtsMainPage mtsMainPage;
    public static BepaidIframePage bepaidIframePage;
    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        mtsMainPage = new MtsMainPage(driver);
        bepaidIframePage = new BepaidIframePage(driver);
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
        ArrayList<Boolean> logos = new ArrayList<>(Arrays.asList(mtsMainPage.getLogoVisa(), mtsMainPage.getLogoBelcard(),
                mtsMainPage.getLogoMasterCard(), mtsMainPage.getLogoMasterSecCode(), mtsMainPage.getLogoVerByVisa()));
        for (Boolean logo : logos) {
            Assertions.assertTrue(logo, "Логотип платёжной системы отсутствует");
        }
    }

    @Test
    @DisplayName("Проверка работоспособности ссылки 'Подробнее о сервисе'")
    public void testAboutService() {
        mtsMainPage.getAboutServise();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl(), "Ссылка 'Подробнее о сервисе' не открывает ожидаемую страницу");
    }

    @Test
    @DisplayName("Проверка работоспособности кнопки 'Продолжить'")
    public void testBtnContinue() {
        mtsMainPage.sK("297777777", "29");
        wait.until(driver1 -> driver.switchTo().frame(2));
        wait.until(ExpectedConditions.visibilityOfAllElements(mtsMainPage.getPaymentWindow()));
        Assertions.assertTrue(mtsMainPage.disPaymentWindow(), "Кнопка продолжить не открыла окно оплаты");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Услуги связи'")
    public void testCommunicationServices() {
        Assertions.assertEquals("Номер телефона", mtsMainPage.placeNumber(),
                "Плэйсхолдер поля 'номер телефона' не соответствует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSum(),
                "Плэйсхолдер поля 'сумма' не соответствует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmail(),
                "Плэйсхолдер поля 'E-mail' не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Домашний интернет'")
    public void testHomeInternet() {
        mtsMainPage.getHomeInternet();
        Assertions.assertEquals("Номер абонента", mtsMainPage.placeNumHomeInter(),
                "Плэйсхолдер поля 'номер абонента' не соответствует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSumHomeInter(),
                "Плэйсхолдер поля 'сумма' не соответствует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmailHomeInter(),
                "Плэйсхолдер поля 'E-mail' не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Рассрочка'")
    public void testInstallmentPlan() {
        mtsMainPage.getInstallmentPlan();
        Assertions.assertEquals("Номер счета на 44", mtsMainPage.placeNumInstalPlan(),
                "Плэйсхолдер поля 'номер абонента' не соответствует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSumInstalPlan(),
                "Плэйсхолдер поля 'сумма' не соответствует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmailInstalPlan(),
                "Плэйсхолдер поля 'E-mail' не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка наличия плэйсхолдера в полях для оплаты 'Рассрочка'")
    public void testDebt() {
        mtsMainPage.getDebt();
        Assertions.assertEquals("Номер счета на 2073", mtsMainPage.placeNumDebt(),
                "Плэйсхолдер поля 'номер абонента' не соответствует ожидаемому.");
        Assertions.assertEquals("Сумма", mtsMainPage.placeSumDebt(),
                "Плэйсхолдер поля 'сумма' не соответствует ожидаемому.");
        Assertions.assertEquals("E-mail для отправки чека", mtsMainPage.placeEmailDebt(),
                "Плэйсхолдер поля 'E-mail' не соответствует ожидаемому.");
    }

    @ParameterizedTest
    @DisplayName("Проверка корректного отображения окна оплаты")
    @ValueSource(strings = "297777777")
    public void testPaymentWindow(String num) {
        mtsMainPage.sK(num, "29");
        wait.until(driver1 -> driver.switchTo().frame(2));
        wait.until(ExpectedConditions.visibilityOfAllElements(mtsMainPage.getPaymentWindow()));
        Allure.step("Проверка отображения введенного номера телефона");
        Assertions.assertTrue(bepaidIframePage.getNumber().contains(num), "Введенный номер телефона не отображается");
        Allure.step("Проверка отображения введенной суммы");
        Assertions.assertTrue(bepaidIframePage.getSumma().contains("29"), "Введенная сумма не отображается");
        Allure.step("Проверка отображения введенной суммы на кнопке оплаты");
        Assertions.assertTrue(bepaidIframePage.getBtnPay().contains("29"), "Введенная сумма не отображается на кнопке оплаты");
        Allure.step("Проверка отображения текста в поле 'Номер карты'");
        Assertions.assertEquals("Номер карты", bepaidIframePage.getNumCard(),
                "Текст поля 'Номер карты' не соответствует ожидаемому.");
        Allure.step("Проверка отображения текста в поле 'Срок действия'");
        Assertions.assertEquals("Срок действия", bepaidIframePage.getValidityPeriod(),
                "Текст поля 'Срок действия' не соответствует ожидаемому.");
        Allure.step("Проверка отображения текста в поле 'CVC'");
        Assertions.assertEquals("CVC", bepaidIframePage.getCvc(),
                "Текст поля 'CVC' не соответствует ожидаемому.");
        Allure.step("Проверка отображения текста в поле 'Имя держателя'");
        Assertions.assertEquals("Имя держателя (как на карте)", bepaidIframePage.getHolderName(),
                "Текст поля 'Имя держателя' не соответствует ожидаемому.");
        Allure.step("Проверка отображения логотипа Visa");
        Assertions.assertTrue(bepaidIframePage.getVisaLogo(), "Логотип Visa не отображается");
        Allure.step("Проверка отображения логотипа MasterCard");
        Assertions.assertTrue(bepaidIframePage.getMasterCardLogo(), "Логотип MasterCard не отображается");
        Allure.step("Проверка отображения логотипа Белкарт");
        Assertions.assertTrue(bepaidIframePage.getBelcartLogo(), "Логотип Белкарт не отображается");
        Allure.step("Проверка отображения логотипов МИР и Maestro");
        Assertions.assertTrue(bepaidIframePage.getLogo(), "Логотип не отображается");
    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
