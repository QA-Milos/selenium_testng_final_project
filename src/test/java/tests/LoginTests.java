package tests;

import org.testng.annotations.Test;

public class LoginTests extends BasicTest{

    @Test(priority = 0, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage(){
        navPage.clickOnLanguageButton();
        navPage.clickLanguageFromList(0);
        navPage.clickOnLoginPage();
        loginPage.verifyUrlForLoginPage();
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes(){
        navPage.clickOnLoginPage();
        loginPage.verifyEmailInputField();
        loginPage.verifyPasswordInputField();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void displayErrorWhenUserDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.clickOnLoginPage();
        loginPage.clearAndTypeEmail(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        loginPage.waitUntilErrorMessageWindowShows();
        loginPage.userDoesNotExistMessage();
        loginPage.verifyUrlForLoginPage();
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displayErrorWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";
        navPage.clickOnLoginPage();
        loginPage.clearAndTypeEmail(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        loginPage.waitUntilErrorMessageWindowShows();
        loginPage.passwordIsWrongMessage();
        loginPage.verifyUrlForLoginPage();
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void successfulLogin(){
        String email = "admin@admin.com";
        String password = "12345";
        navPage.clickOnLoginPage();
        loginPage.clearAndTypeEmail(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        loginPage.waitToVerifyUrlHomePage();
    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void logout(){
        navPage.waitUntilPresenceOfLogoutButton();
        navPage.clickOnLogoutButton();

    }




}
