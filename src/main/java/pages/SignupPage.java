package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void verifySignUpPageUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "The URL should contain '/signup'");
    }
    public WebElement getEmailInputField(){
        return driver.findElement(By.id("email"));
    }
    public void clearAndTypeEmail(String email){
        getEmailInputField().clear();
        getEmailInputField().sendKeys(email);
    }
    public void verifyEmailInputField(){
        wait.withMessage("The email input field attribute 'type' should be 'email' ")
                .until(ExpectedConditions.attributeToBe(getEmailInputField(), "type", "email"));

    }

    public WebElement getPasswordInputField(){
        return driver.findElement(By.id("password"));
    }
    public void clearAndTypePassword(String password){
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(password);
    }

    public void verifyPasswordInputField(){
        wait.withMessage("The password input field attribute 'type' should be 'password' ")
                .until(ExpectedConditions.attributeToBe(getPasswordInputField(), "type", "password"));

    }

    public WebElement getConfirmPasswordInputField(){
        return driver.findElement(By.id("confirmPassword"));
    }

    public void clearAndTypeConfirmPassword(String confirmPassword){
        getConfirmPasswordInputField().clear();
        getConfirmPasswordInputField().sendKeys(confirmPassword);
    }

    public void verifyConfirmPasswordInputField(){
        wait.withMessage("The password input field attribute 'type' should be 'password' ")
                .until(ExpectedConditions.attributeToBe(getConfirmPasswordInputField(), "type", "password"));

    }

    public WebElement getNameInputField(){
        return driver.findElement(By.id("name"));
    }

    public void clearAndTypeName(String name){
        getNameInputField().clear();
        getNameInputField().sendKeys(name);
    }

    public WebElement signMeUpButton(){
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
    public void clickOnSignMeUpButton(){
        signMeUpButton().click();
    }

    public void waitUntilErrorMessageWindowShows(){
        wait.withMessage("Error pop-up doesn't show.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-snack__wrapper")));
    }

    public void emailAlreadyExistsMessage(){
        Assert.assertEquals(driver.findElement(By.cssSelector("div.v-snack__wrapper ul li")).getText(),
                "E-mail already exists",
                "Error message should be: 'E-mail already exists'.");
    }


    public void AssertUrlForHomePage(){

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home", "The URL should contain '/home' ," +
                "but contains " + driver.getCurrentUrl());

    }

    public void verifyImportantMessageIsPresent (){
        Assert.assertEquals(driver.findElement(By.cssSelector("div[role='document']:nth-child(4) div.v-card__title")).getText(),
                "IMPORTANT: Verify your account");
    }

    public void closeImportantMessageDialog(){
        driver.findElement(By.cssSelector("div[role='document']:nth-child(4) button")).click();
    }

    public void waitToVerifyUrlHomePage(){
        wait.until(ExpectedConditions.urlContains("/home"));
    }


    public String generateRandomEmail() {
        Random random = new Random();
        String username = generateRandomString(8); // Generate an 8-character username;
        String domain = "itbootcamp.rs";

        return username + "@" + domain;
    }

    private String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }


}
