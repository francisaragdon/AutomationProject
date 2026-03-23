package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import web.factory.DriverManager;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    protected WebDriverWait wait;


    protected BasePage(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeOut()));

    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void input(By locator, String insert){
        WebElement element = wait.until((ExpectedConditions.elementToBeClickable(locator)));
        element.click();
        element.sendKeys(insert);
    }

    protected void navigateToUrl(String url){
        driver.get(url);
    }

    protected boolean isVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();

    }
}
