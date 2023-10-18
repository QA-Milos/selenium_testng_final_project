package tests;

import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 0, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheSignupPage(){
        navPage.clickOnSignUpPage();
        signupPage.verifySignUpPageUrl();
    }
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes(){
        navPage.clickOnSignUpPage();
        signupPage.verifyEmailInputField();
        signupPage.verifyPasswordInputField();
        signupPage.verifyConfirmPasswordInputField();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void displayErrorWhenUserAlreadyExists(){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";
        navPage.clickOnSignUpPage();
        signupPage.verifySignUpPageUrl();
        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(email);
        signupPage.clearAndTypePassword(password);
        signupPage.clearAndTypeConfirmPassword(confirmPassword);
        signupPage.clickOnSignMeUpButton();
        signupPage.waitUntilErrorMessageWindowShows();
        signupPage.emailAlreadyExistsMessage();
        signupPage.verifySignUpPageUrl();
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void successfulSignup(){
        String name = "Milos Josifovic";
        String email = signupPage.generateRandomEmail(); //generates a random email using Random and StringBuilder. It's a workaround so
        //The test always works, cuse the user won't ever already exist that way.
        String password = "12345";
        String confirmPassword = "12345";
        navPage.clickOnSignUpPage();
        signupPage.verifySignUpPageUrl();
        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(email);
        signupPage.clearAndTypePassword(password);
        signupPage.clearAndTypeConfirmPassword(confirmPassword);
        signupPage.clickOnSignMeUpButton();
        signupPage.waitToVerifyUrlHomePage();
        signupPage.verifyImportantMessageIsPresent();
        signupPage.closeImportantMessageDialog();
        navPage.clickOnLogoutButton();
    }
}
