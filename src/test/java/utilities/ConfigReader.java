package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
        In order to access the .properties file, we need to create an object from the Properties class

        With this object we created, we can return the file path we received with the load
        (fis) method and the key value in the properties file
     */

    static Properties properties;

    static {
        String filePath = "configurations.properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("properties file could not be read");
        }


    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
