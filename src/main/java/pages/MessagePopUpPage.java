package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public WebElement importantMessage(){
        return driver.findElement(By.cssSelector("div[role='document']:nth-child(4) div.v-card__title"));
    }
    public void verifyImportantMessageIsPresent (){
        Assert.assertEquals(importantMessage().getText(),
                "IMPORTANT: Verify your account");
    }


    public WebElement errorMessageWindow(){
        return driver.findElement(By.cssSelector("div.v-snack__wrapper"));
    }
    public void waitUntilErrorMessageWindowShows(){
        wait.withMessage("Error pop-up doesn't show.")
                .until(ExpectedConditions.visibilityOf(errorMessageWindow()));
    }

    public WebElement emailErrorMessage(){
        return driver.findElement(By.cssSelector("div.v-snack__wrapper ul li"));
    }
    public void emailAlreadyExistsMessage(){
        Assert.assertEquals(emailErrorMessage().getText(),
                "E-mail already exists",
                "Error message should be: 'E-mail already exists'.");
    }

    public WebElement importantMessageCloseButton(){
        return driver.findElement(By.cssSelector("div[role='document']:nth-child(4) button"));
    }
    public void closeImportantMessageDialog(){
        importantMessageCloseButton().click();
    }


    public WebElement userDoesNotExist(){
        return driver.findElement(By.cssSelector("div.v-snack__wrapper ul li"));
    }
    public void userDoesNotExistMessage(){
        Assert.assertEquals(userDoesNotExist().getText(),
                "User does not exists",
                "Error message should be: 'User does not exists'.");
    }

    public WebElement passwordIsWrong(){
        return driver.findElement(By.cssSelector("div.v-snack__wrapper ul li"));
    }
    public void passwordIsWrongMessage(){
        Assert.assertEquals(passwordIsWrong().getText(),
                "Wrong password",
                "Error message should be: 'Wrong password'.");
    }
}
