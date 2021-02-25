package pages.Clients;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath = "//input[@id='client_name']")
    WebElement cName;

    @FindBy (xpath = "//input[@id='client_surname']")
    WebElement cSurname;

    @FindBy (xpath = "//input[@id='client_address_1']")
    WebElement cAdd1;

    @FindBy (xpath = "//input[@id='client_address_2']")
    WebElement cAdd2;

    @FindBy (xpath = "//input[@id='client_city']")
    WebElement cCity;

    @FindBy (xpath = "//input[@id='client_state']")
    WebElement cState;

    @FindBy (xpath = "//input[@id='client_zip']")
    WebElement cZip;

    @FindBy (xpath = "//input[@id='client_phone']")
    WebElement cPhone;

    @FindBy (xpath = "//input[@id='client_fax']")
    WebElement cFax;

    @FindBy (xpath = "//input[@id='client_mobile']")
    WebElement cMobile;

    @FindBy (xpath = "//input[@id='client_email']")
    WebElement cEmail;

    @FindBy (xpath = "//input[@id='client_web']")
    WebElement cWeb;

    @FindBy (xpath = "//input[@id='client_vat_id']")
    WebElement cVat;

    @FindBy (xpath = "//input[@id='client_tax_code']")
    WebElement cTax;

    @FindBy (xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;



    public AddClient(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setcName(String name)
    {
        cName.sendKeys(name);
    }

    public void clickSave()
    {
        btnSave.click();
    }

    @FindBy (id="select2-client_language-container")
    WebElement containerLanguage;

    @FindBy (xpath = "//input[@type='search']")
    WebElement searchBox;

    WebDriver driver;

    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language);

        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();

    }


    @FindBy (id="select2-client_country-container")
    WebElement containerCountry;

    public String setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);

        String countryXpath = "//li[normalize-space()='"+country+"']";

        String countryID = driver.findElement(By.xpath(countryXpath)).getAttribute("id");

        //select2-client_country-result-y5am-HU
        int l = countryID.length();

        String shortCountry = countryID.substring(l-2);


        driver.findElement(By.xpath(countryXpath)).click();


        return shortCountry;

    }

  /*  public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);

        String countryXpath = "//li[normalize-space()='"+country+"']";

        driver.findElement(By.xpath(countryXpath)).click();

        return shortCountry;

    }*/

    @FindBy (id= "select2-client_gender-container")
    WebElement containerGender;

    public void setGender(String gender)
    {
        containerGender.click();

        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }


    public void setcSurname(String surname)
    {
        cSurname.sendKeys(surname);
    }

    @FindBy (xpath = "//input[@name='client_birthdate']")
    WebElement cBirthdate;

    public void setcBirthdate(String dateStr)
    {
       // cBirthdate.sendKeys(dateStr);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value','"+dateStr+"')",cBirthdate);
    }


    public void setcAdd1(String add1)
    {
        cAdd1.sendKeys(add1);
    }

    public void setcAdd2(String add2)
    {
        cAdd2.sendKeys(add2);
    }

    public void setcCity(String city)
    {
        cCity.sendKeys(city);
    }

    public void setcState(String state)
    {
        cState.sendKeys(state);
    }

    public void setcZip(String zip)
    {
        cZip.sendKeys(zip);
    }

    public void setcPhone(String phone)
    {
        cPhone.sendKeys(phone);
    }

    public void setcFax(String fax)
    {
        cFax.sendKeys(fax);
    }

    public void setcMobile(String mobile)
    {
        cMobile.sendKeys(mobile);
    }

    public void setcEmail(String email)
    {
        cEmail.sendKeys(email);
    }

    public void setcWeb(String web)
    {
        cWeb.sendKeys(web);
    }

    public void setcVat(String vat)
    {
        cVat.sendKeys(vat);
    }

    public void setcTax(String tax)
    {
        cTax.sendKeys(tax);
    }



}
