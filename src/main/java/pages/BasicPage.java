package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasicPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    public BasicPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public boolean elementExists(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public boolean elementExists(By by, int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        boolean elementExists = !driver.findElements(by).isEmpty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return elementExists;
    }




}
