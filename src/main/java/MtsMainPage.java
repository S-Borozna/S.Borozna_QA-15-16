import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MtsMainPage {
    public WebDriver driver;

    public MtsMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//*[@id=\"pay-section\"]//h2)[1]")
    private WebElement blockName;

    @FindBy(xpath = "//*[@alt=\"Verified By Visa\"]")
    public WebElement logoVerByVisa;

    @FindBy(xpath = "(//*[@alt=\"MasterCard\"])[1]")
    public WebElement logoMasterCard;

    @FindBy(xpath = "//*[@alt=\"MasterCard Secure Code\"]")
    public WebElement logoMasterSecCode;

    @FindBy(xpath = "(//*[@alt=\"Белкарт\"])[1]")
    public WebElement logoBelcard;

    @FindBy(xpath = "//*[@alt=\"Visa\"]")
    public WebElement logoVisa;

    @FindBy(xpath = "(//*[@id=\"pay-section\"]//a)[1]")
    public WebElement btnAbServise;

    @FindBy(xpath = "//*[@placeholder=\"Номер телефона\"]")
    private WebElement phoneNumber;

    @FindBy(xpath = "(//*[@type=\"submit\"])[3]")
    private WebElement btnContinue;

    @FindBy(xpath = "(//*[@placeholder=\"Сумма\"])[1]")
    private WebElement sum;

    @FindBy(xpath = "(//*[@placeholder=\"E-mail для отправки чека\"])[1]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"cookie-agree\"]")
    private WebElement btnCookie;

    @FindBy(xpath = "//app-root/div/div/div")
    private WebElement paymentWindow;

    @FindBy(xpath = "(//*[@id=\"pay-section\"]//button)[1]")
    private WebElement communicationServices;

    @FindBy(xpath = "(//*[@id=\"pay-section\"]//p)[2]")
    private WebElement homeInternet;

    @FindBy(xpath = "//*[@placeholder=\"Номер абонента\"]")
    private WebElement numHomeInter;

    @FindBy(xpath = "(//*[@placeholder=\"Сумма\"])[2]")
    private WebElement sumHomeInter;

    @FindBy(xpath = "(//*[@placeholder=\"E-mail для отправки чека\"])[2]")
    private WebElement emailHomeInter;

    @FindBy(xpath = "(//*[@id=\"pay-section\"]//p)[3]")
    private WebElement installmentPlan;

    @FindBy(xpath = "//*[@placeholder=\"Номер счета на 44\"]")
    private WebElement accountNumber;

    @FindBy(xpath = "(//*[@placeholder=\"Сумма\"])[3]")
    private WebElement sumInstalPlan;

    @FindBy(xpath = "(//*[@placeholder=\"E-mail для отправки чека\"])[3]")
    private WebElement emailInstalPlan;

    @FindBy(xpath = "(//*[@id=\"pay-section\"]//p)[4]")
    private WebElement debt;

    @FindBy(xpath = "//*[@placeholder=\"Номер счета на 2073\"]")
    private WebElement accountNumberDebt;

    @FindBy(xpath = "(//*[@placeholder=\"Сумма\"])[4]")
    private WebElement sumDebt;

    @FindBy(xpath = "(//*[@placeholder=\"E-mail для отправки чека\"])[4]")
    private WebElement emailDebt;

    public String placeEmailDebt() {
        return emailDebt.getAttribute("placeholder");
    }

    public String placeSumDebt() {
        return sumDebt.getAttribute("placeholder");
    }

    public String placeNumDebt() {
        return accountNumberDebt.getAttribute("placeholder");
    }

    public void getDebt() {
        communicationServices.click();
        debt.click();
    }

    public String placeEmailInstalPlan() {
        return emailInstalPlan.getAttribute("placeholder");
    }

    public String placeSumInstalPlan() {
        return sumInstalPlan.getAttribute("placeholder");
    }

    public String placeNumInstalPlan() {
        return accountNumber.getAttribute("placeholder");
    }

    public void getInstallmentPlan() {
        communicationServices.click();
        installmentPlan.click();
    }

    public String placeEmailHomeInter() {
        return emailHomeInter.getAttribute("placeholder");
    }

    public String placeSumHomeInter() {
        return sumHomeInter.getAttribute("placeholder");
    }

    public String placeNumHomeInter() {
        return numHomeInter.getAttribute("placeholder");
    }

    public void getHomeInternet() {
        communicationServices.click();
        homeInternet.click();
    }

    public String placeEmail() {
        return email.getAttribute("placeholder");
    }

    public String placeSum() {
        return sum.getAttribute("placeholder");
    }

    public String placeNumber() {
        return phoneNumber.getAttribute("placeholder");
    }

    public boolean disPaymentWindow() {
        return paymentWindow.isDisplayed();
    }

    public void btnCookie() {
        btnCookie.click();
    }

    public String getBlockName() {
        return blockName.getText();
    }

    public void abServise() {
        btnAbServise.click();
    }

    public void sK(String number, String summa) {
        phoneNumber.sendKeys(number);
        sum.sendKeys(summa);
        btnContinue.click();
    }
}
