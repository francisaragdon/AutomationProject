package web.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void initDriver(String browser) {

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions options = getChromeOptions();

                String headless = System.getProperty("headless");
                if ("true".equalsIgnoreCase(headless)) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                }

                driver.set(new ChromeDriver(options));
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.get().manage().window().maximize();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Disable save password popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        return options;
    }

    public WebDriver getDriver() {

        if (driver.get() == null) {
            initDriver(ConfigReader.getBrowser());
        }
        return driver.get();
    }


    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }


}
