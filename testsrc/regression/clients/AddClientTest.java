package regression.clients;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import util.OpenUrl;

import java.io.IOException;

import static utilities.ConfigReader.getPassword;
import static utilities.ConfigReader.getUserName;

public class AddClientTest extends OpenUrl {

    @BeforeClass
    public void doLogin() throws IOException {
        Login login = new Login(driver);
        login.setTxtUser(getUserName());
        login.setTxtPass(getPassword());
        login.clickLogin();
    }


    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddclient();
    }
}
