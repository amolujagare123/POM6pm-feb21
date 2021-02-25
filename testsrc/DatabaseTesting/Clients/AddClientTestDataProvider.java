package DatabaseTesting.Clients;

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
import java.sql.*;
import java.util.ArrayList;

import static util.ForDataProvider.myData;
import static utilities.ConfigReader.getPassword;
import static utilities.ConfigReader.getUserName;
import static utilities.Conversion.convertCountry;

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
                              String web,String vat,String tax ) throws ClassNotFoundException, SQLException
    // to test the functionality of save button for all valid inputs
    {

        ArrayList<String> expected = new ArrayList<>();
        expected.add( name);
        expected.add( surname );
        expected.add( add1  );
        expected.add( add2 );
        expected.add( language.toLowerCase() );
        expected.add( city );
        expected.add( state );
        expected.add( zip );
        expected.add( country);
        expected.add( gender);
        expected.add( birthdate);
        expected.add( phone);
        expected.add( fax );
        expected.add( mobile);
        expected.add( email);
        expected.add( web );
        expected.add( vat );
        expected.add( tax );




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






        // 1. Loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. creating a connection
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(url,username,password);

        // 3. creating statement
        Statement st = con.createStatement();

        // 4. executing query
        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            /*String shortCountry =  rs.getString("client_country");

            String longCountry = convertCountry(shortCountry);

            actual.add(longCountry);
*/
           actual.add( rs.getString("client_country")); // IN


            actual.add(rs.getString("client_gender"));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));

        }

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected);

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return myData("Data/myData.xlsx","dbTesting");
    }
}
