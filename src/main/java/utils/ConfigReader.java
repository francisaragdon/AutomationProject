package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getApiBaseUri() {
        return properties.getProperty("api.base.uri");
    }

    public static String getApiBaseUriUserService() {
        return properties.getProperty("api.base.uri.userservice");
    }

    public static String getBrowser() {
        return properties.getProperty("web.browser");
    }

    public static long getTimeOut() {
        return Long.parseLong(properties.getProperty("web.timeout"));
    }

    public static String getTestApp() {
        return properties.getProperty("web.app.url");
    }

    public static String getUsernameAdmin() {
        return properties.getProperty("web.admin");
    }

    public static String getPasswordAdmin() {
        return properties.getProperty("web.password");
    }

}