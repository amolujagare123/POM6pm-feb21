package regression.clients;

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
    public void addClientTest()
    // to test the functionality of save button for all valid inputs
    {
        Menu menu = new Menu(driver);
        menu.clickAddclient();

        AddClient addClient = new AddClient(driver);

        addClient.setcName("amol");
        addClient.setcSurname("ujagare");
        addClient.setcAdd1("abcd");
        addClient.setLanguage("Thai");
        addClient.setcAdd2("xyz");
        addClient.setcCity("Pune");
        addClient.setcState("MH");
        addClient.setcZip("9090");
        addClient.setCountry("Mexico");
        addClient.setGender("Female");
        addClient.setcBirthdate("05/21/1983");
        addClient.setcPhone("989898");
        addClient.setcFax("7878878");
        addClient.setcMobile("898989");
        addClient.setcEmail("a@b.com");
        addClient.setcWeb("www.abc.com");
        addClient.setcVat("88989");
        addClient.setcTax("98989");

        addClient.clickSave();

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return myData("","");
    }
}
