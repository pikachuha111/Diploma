package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesUI {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadPropertiesUI.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("urlUI");
    }

    public static String browserName() {
        return properties.getProperty("browserUI");
    }

    public static String userName() {
        return properties.getProperty("userNameUI");
    }
    public static String firstName() {
        return properties.getProperty("firstNameUI");
    }
    public static String lastName() {
        return properties.getProperty("lastNameUI");
    }

    public static String password() {
        return properties.getProperty("passwordUI");
    }

}
