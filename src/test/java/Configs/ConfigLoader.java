package Configs;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    public ConfigLoader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Не удалось найти config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getStandardUserLogin() {
        return properties.getProperty("StandardUserLogin");
    }
    public String getLockedOutUserLogin() { return properties.getProperty("LockedOutUserLogin");}
    public String getPassword() {
        return properties.getProperty("Password");
    }

}


