package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {

  //  WebElement txtUser = driver.findElement(By.xpath(""));

    @FindBy (xpath = "//input[@type='email']")
    WebElement txtUser;

    @FindBy (xpath = "//input[@type='password']")
    WebElement txtPass;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy (xpath = "//a[@class='btn btn-default']")
    WebElement lnkForgotPass;


    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void setTxtUser(String user)
    {
        txtUser.sendKeys(user);
    }

    public void setTxtPass(String pass)
    {
        txtPass.sendKeys(pass);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

}
