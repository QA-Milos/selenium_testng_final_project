package tests;

import helpers.RetryAnalyzer;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    protected String city;

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities(){
        String email = "admin@admin.com";
        String password = "12345";
        navPage.clickOnLoginPage();
        loginPage.clearAndTypeEmail(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesLink();
        citiesPage.waitToVerifyAdminCitiesUrl();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateEditNewCity(){
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesLink();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitUntilCreateEditDialogShows();
        citiesPage.verifyCityNameInputType();
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createCity(){
        this.city = citiesPage.generateRandomCityName();
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesLink();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitUntilCreateEditDialogShows();
        citiesPage.clearAndSendKeysToNewItemInput(city);
        citiesPage.clickOnSaveButton();
        citiesPage.waitUntilSavedDialogShows();
        citiesPage.verifySavedSuccessfullyMessage();
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity(){
        String editedCity = this.city + " Edited";
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesLink();
        citiesPage.clearAndTypeSearch(this.city);
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.clickOnEditButton();
        citiesPage.clearAndSendKeysToNewItemInput(editedCity);
        citiesPage.clickOnSaveButton();
        citiesPage.waitUntilSavedDialogShows();
        citiesPage.verifySavedSuccessfullyMessage();
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity(){
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesLink();
        citiesPage.clearAndTypeSearch(this.city);
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.clickOnDeleteButton();
        citiesPage.waitUntilDeleteDialogShows();
        citiesPage.clickOnDeleteDialogDeleteButton();
        citiesPage.waitUntilSavedDialogShows();
        citiesPage.verifyDeletedSuccessfullyMessage();
    }


















}
