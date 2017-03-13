import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;


/**
 * Created by Kefir on 12.03.2017.
 */
public class Login {
    WebDriver driver;
    @BeforeMethod
    public void SetUP () {
        driver = new ChromeDriver();
        driver.get("https://webmail.itransition.com");
    }

     @Parameters({"Login","Password"})
     @Test
     public void LoginTest(String Login, String Password){
        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys(Login);
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(Password);
        pass.submit();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.id("_ariaId_54.folder")));
        driver.findElement(By.id("_ariaId_54.folder"));
        }


   @AfterMethod
    public void SetDown() {
        if (driver != null)
            driver.quit();
    }

}
