package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getHomeLink(){
        return driver.findElement(By.cssSelector("a.v-btn:nth-child(1)"));
    }
    public void clickOnHomeLink(){
        getHomeLink().click();
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.cssSelector("a.v-btn:nth-child(2)"));
    }
    public void clickOnAboutLink(){
        getAboutLink().click();
    }
    public WebElement getLoginPageLink(){
        return driver.findElement(By.cssSelector("a.v-btn:nth-child(3)"));
    }
    public void clickOnLoginPage(){
        getLoginPageLink().click();
    }

    public WebElement getSignUpLink(){
        return driver.findElement(By.cssSelector("a.v-btn:nth-child(4)"));
    }
    public void clickOnSignUpPage(){
        getSignUpLink().click();
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.cssSelector("button.btnLocaleActivation"));
    }

    public void clickOnLanguageButton(){
        getLanguageButton().click();
    }

    public List<WebElement> getListOfLanguages(){
        return driver.findElements(By.cssSelector("div[role='menu'] div div[role='menuitem']"));
    }
    public void clickLanguageFromList(int index){
        for (int i = 0; i < getListOfLanguages().size() ; i++) {
            if (i == index) {
                getListOfLanguages().get(index).click();
            }
        }
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.cssSelector("button.btnLogout"));
    }


    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }

    public void waitUntilPresenceOfLogoutButton(){
        wait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.btnLogout")));
    }

    public WebElement adminButton(){
        return driver.findElement(By.cssSelector("button:nth-child(6)"));
    }
    public void clickOnAdminButton(){
        adminButton().click();
    }








}
