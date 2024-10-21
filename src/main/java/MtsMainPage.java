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

    public String getBlockName() {
        return blockName.getText();
    }

    public void abServise() {
        btnAbServise.click();
    }
}
