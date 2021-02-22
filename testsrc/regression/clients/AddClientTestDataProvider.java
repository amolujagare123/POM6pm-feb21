package regression.clients;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;
import util.OpenUrl;

import java.io.IOException;

import static util.ForDataProvider.myData;
import static utilities.ConfigReader.getPassword;
import static utilities.ConfigReader.getUserName;

public class AddClientTestDataProvider extends OpenUrl {

    @BeforeClass
    public void doLogin() throws IOException {
        Login login = new Login(driver);
        login.setTxtUser(getUserName());
        login.setTxtPass(getPassword());
        login.clickLogin();
    }


    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,String add1,
                              String add2,String language,String city,
                              String state,String zip,String country,
                              String gender,String birthdate,String phone,
                              String fax,String mobile,String email,
                              String web,String vat,String tax,
                              String expected,String xpathActual)
    // to test the functionality of save button for all valid inputs
    {
        Menu menu = new Menu(driver);
        menu.clickAddclient();
        AddClient addClient = new AddClient(driver);
        addClient.setcName(name);
        addClient.setcSurname(surname);
        addClient.setcAdd1(add1);
        addClient.setcAdd2(add2);
        addClient.setLanguage(language);
        addClient.setcCity(city);
        addClient.setcState(state);
        addClient.setcZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setcBirthdate(birthdate);
        addClient.setcPhone(phone);
        addClient.setcFax(fax);
        addClient.setcMobile(mobile);
        addClient.setcEmail(email);
        addClient.setcWeb(web);
        addClient.setcVat(vat);
        addClient.setcTax(tax);

        addClient.clickSave();

        String actual = "";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"incorrect message");

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return myData("Data/myData.xlsx","addClient");
    }
}
