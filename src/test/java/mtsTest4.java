import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class mtsTest4 {

    @Test
    @DisplayName("Проверка работоспособности кнопки 'Продолжить'")
    public void testBtnContinue() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement btnCookie = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        btnCookie.click();
        WebElement phone = driver.findElement(By.xpath("//*[@placeholder=\"Номер телефона\"]"));
        WebElement btnContinue = driver.findElement(By.xpath("(//*[@type=\"submit\"])[3]"));
        WebElement sum = driver.findElement(By.xpath("(//*[@placeholder=\"Сумма\"])[1]"));
        phone.sendKeys("297777777");
        sum.sendKeys("29");
        btnContinue.click();
        WebElement x = driver.findElement(By.xpath("//*[@allowpaymentrequest=\"\"]"));

        Assertions.assertFalse(x.isDisplayed(), "Кнопка продолжить не открыла модальное окно оплаты");

        driver.manage().deleteAllCookies();
        driver.close();
    }
}
