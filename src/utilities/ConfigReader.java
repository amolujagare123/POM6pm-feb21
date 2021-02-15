package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void main(String[] args) throws IOException {

        // 1. create object of properties file
        Properties prop = new Properties();

        // 2 . read the file
        FileInputStream fis = new FileInputStream("config.properties");

        // 3. load the properties object with file object:
        prop.load(fis);

        // 4. read the value of the key
        System.out.println(prop.getProperty("url"));


        System.out.println(prop.getProperty("username"));

    }




}
