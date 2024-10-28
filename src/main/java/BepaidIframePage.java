import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BepaidIframePage {
    public WebDriver driver;

    public BepaidIframePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//section//div/div[2]/span")
    private WebElement number;

    @FindBy(xpath = "//section/div/div/div[1]/span[1]")
    private WebElement summa;

    @FindBy(xpath = "//app-card-page//div[1]/button")
    private WebElement btnPay;

    @FindBy(xpath = "//app-input//div[1]/label")
    private WebElement numCard;

    @FindBy(xpath = "//div[2]/div[1]/app-input//div[1]/label")
    private WebElement validityPeriod;

    @FindBy(xpath = "//div[1]//div[1]/div[2]/div[3]//div[1]/label")
    private WebElement cvc;

    @FindBy(xpath = "//div[1]//div[1]/div[3]/app-input//div[1]/label")
    private WebElement holderName;

    @FindBy(xpath = "//div[2]/div/div/img[1]")
    private WebElement visaLogo;

    @FindBy(xpath = "//div[2]/div/div/img[2]")
    private WebElement masterCardLogo;

    @FindBy(xpath = "//div[2]/div/div/img[3]")
    private WebElement belcartLogo;

    @FindBy(xpath = "//app-input//div[2]/div/div/div")
    private WebElement logo;

    public boolean getVisaLogo() {
        return visaLogo.isDisplayed();
    }

    public boolean getMasterCardLogo() {
        return masterCardLogo.isDisplayed();
    }

    public boolean getBelcartLogo() {
        return belcartLogo.isDisplayed();
    }

    public boolean getLogo() {
        return logo.isDisplayed();
    }

    public String getHolderName() {
        return holderName.getText();
    }

    public String getCvc() {
        return cvc.getText();
    }

    public String getValidityPeriod() {
        return validityPeriod.getText();
    }

    public String getNumCard() {
        return numCard.getText();
    }

    public String getBtnPay() {
        return btnPay.getText();
    }

    public String getSumma() {
        return summa.getText();
    }

    public String getNumber() {
        return number.getText();
    }
}
