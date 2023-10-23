package tests;

import helpers.RetryAnalyzer;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        navPage.enterHomeUrl();
        loginPage.verifyUrlForLoginPage();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        navPage.enterProfileUrl();
        loginPage.verifyUrlForLoginPage();
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        navPage.enterAdminCitiesUrl();
        loginPage.verifyUrlForLoginPage();
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        navPage.enterAdminUsersUrl();
        loginPage.verifyUrlForLoginPage();
    }
}
