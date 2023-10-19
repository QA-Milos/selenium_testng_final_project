package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public WebElement getEmailInputField(){
        return driver.findElement(By.id("email"));
    }
    public void clearAndTypeEmail(String email){
        getEmailInputField().clear();
        getEmailInputField().sendKeys(email);
    }
    public WebElement getPasswordInputField(){
        return driver.findElement(By.id("password"));
    }
    public void clearAndTypePassword(String password){
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(password);
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }
    public void verifyUrlForLoginPage(){

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "The URL should contain '/login'");

    }
    public void waitToVerifyUrlHomePage(){

        wait.until(ExpectedConditions.urlContains("/home"));


    }

    public void verifyEmailInputField(){
        wait.withMessage("The email input field attribute 'type' should be 'email' ")
                .until(ExpectedConditions.attributeToBe(getEmailInputField(), "type", "email"));

    }

    public void verifyPasswordInputField(){
        wait.withMessage("The password input field attribute 'type' should be 'password' ")
                .until(ExpectedConditions.attributeToBe(getPasswordInputField(), "type", "password"));

    }
}
