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
    public String getHeaderText(){
        return driver.findElement(By.cssSelector("h1.display-2.font-weight-bold")).getText();
    }

    public void verifyHeaderTextByEnglish(){
        Assert.assertEquals(getHeaderText(), "Landing",
                "The expected header text should be 'Landing'");
    }

    public void verifyHeaderTextBySpanish(){
        Assert.assertEquals(getHeaderText(), "Página de aterrizaje",
                "The expected header text should be 'Página de aterrizaje'");
    }

    public void verifyHeaderTextByChinese(){
        Assert.assertEquals(getHeaderText(), "首页",
                "The expected header text should be '首页'");
    }

    public void verifyHeaderTextByFrench(){
        Assert.assertEquals(getHeaderText(), "Page d'atterrissage",
                "The expected header text should be 'Page d'atterrissage'");
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

    public WebElement getCitiesLink(){
        return driver.findElement(By.cssSelector("a[href='/admin/cities']"));
    }

    public void clickOnCitiesLink(){
        getCitiesLink().click();
    }

    public WebElement getUsersLink(){
        return driver.findElement(By.cssSelector("a[href='/admin/cities']"));
    }

    public void clickOnUsersLink(){
        getUsersLink().click();
    }

    public void enterHomeUrl(){
        driver.navigate().to(baseUrl + "/home");
    }
    public void enterProfileUrl(){
        driver.navigate().to(baseUrl + "/profile");
    }
    public void enterAdminCitiesUrl(){
        driver.navigate().to(baseUrl + "/admin/cities");
    }
    public void enterAdminUsersUrl(){
        driver.navigate().to(baseUrl + "/admin/users");
    }







}
