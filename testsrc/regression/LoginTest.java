package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;

import static utilities.ConfigReader.getPassword;
import static utilities.ConfigReader.getUserName;

public class LoginTest extends OpenUrl {


    @Test
    public void loginTest() throws IOException {
       /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:83/ip");*/

        Login login = new Login(driver);

        login.setTxtUser(getUserName());
        login.setTxtPass(getPassword());
        login.clickLogin();
    }
}
