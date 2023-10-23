package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitToVerifyAdminCitiesUrl() {
        wait
                .withMessage("URL should contain '/admin/cities'")
                .until(ExpectedConditions.urlContains("/admin/cities"));
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.cssSelector("button.btnNewItem"));
    }

    public void clickOnNewItemButton() {
        getNewItemButton().click();
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public void clearAndTypeSearch(String input) {
        getSearchInput().sendKeys(input);
    }

    public WebElement createEditDialog() {
        return driver.findElement(By.cssSelector("div.dlgNewEditItem"));
    }

    public void waitUntilCreateEditDialogShows() {
        wait.withMessage("The edit/create dialog should show")
                .until(ExpectedConditions.visibilityOf(createEditDialog()));
    }

    public WebElement getNewItemNameInput(){
        return driver.findElement(By.id("name"));
    }

    public void clearAndSendKeysToNewItemInput(String input){
        getNewItemNameInput().clear();
        getNewItemNameInput().clear();
        getNewItemNameInput().sendKeys(input);
    }

    public void verifyCityNameInputType(){
        Assert.assertEquals(getNewItemNameInput().getAttribute("type"), "text");
    }
    public WebElement cancelEditCreateDialogButton() {
        return driver.findElement(By.cssSelector("button.btnCancel"));
    }


    public void clickOnCancelButton() {
        cancelEditCreateDialogButton().click();
    }

    public WebElement saveEditCreateDialogButton() {
        return driver.findElement(By.cssSelector("button.btnSave"));
    }

    public void clickOnSaveButton() {
        saveEditCreateDialogButton().click();
    }

    public WebElement deleteDialog() {
        return driver.findElement(By.cssSelector("div.v-dialog.v-dialog--active"));
    }

    public void waitUntilDeleteDialogShows() {
        wait.withMessage("The delete dialog should show")
                .until(ExpectedConditions.visibilityOf(deleteDialog()));
    }

    public WebElement getDeleteDialogCancelButton() {
        return driver.findElement(By.cssSelector("div.v-dialog.v-dialog--active button"));
    }

    public void clickOnDeleteDialogCancelButton() {
        getDeleteDialogCancelButton().click();
    }

    public WebElement getDeleteDialogDeleteButton() {
        return driver.findElement(By.cssSelector("div.v-dialog.v-dialog--active button:nth-child(3)"));
    }

    public void clickOnDeleteDialogDeleteButton(){
        getDeleteDialogDeleteButton().click();
    }

    public List<WebElement> geteditDeleteItemTable(){
        return driver.findElements(By.cssSelector("tbody tr"));
    }

    public void waitForNumberOfRowsToBe(int n){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr"), n));
    }

    public WebElement getEditDeleteTableCell(int row, int column){
        return driver.findElement(By.cssSelector("tbody tr:nth-child(" + row + ")" + " td:nth-child(" + column + ")"));
    }

    public WebElement getEditButton(){
        return driver.findElement(By.id("edit"));
    }
    public void clickOnEditButton(){
        getEditButton().click();
    }

    public WebElement getDeleteButton(){
        return driver.findElement(By.id("delete"));
    }

    public void clickOnDeleteButton(){
        getDeleteButton().click();
    }
    



    public WebElement getSavedSuccessfullyDialog(){
        return driver.findElement(By.cssSelector("div.v-snack__wrapper.v-sheet.theme--dark.success div"));
    }
    public void waitUntilSavedDialogShows(){
        wait.until(ExpectedConditions.visibilityOf(getSavedSuccessfullyDialog()));
    }

    public void verifySavedSuccessfullyMessage(){
        String messageText = getSavedSuccessfullyDialog().getText();
        Assert.assertTrue(messageText.contains("Saved successfully"), "Did not find 'Saved Successfully' message");
    }

    public void verifyDeletedSuccessfullyMessage(){
        String messageText = getSavedSuccessfullyDialog().getText();
        Assert.assertTrue(messageText.contains("Deleted successfully"), "Did not find 'Deleted Successfully' message");
    }

    public String generateRandomCityName() {
        Random random = new Random();
        String cityNumber = generateRandomString(4); // Generate a 4-character cityNumber;
        String cityName = "Milos Josifovic's city";
        return cityName + " " + cityNumber;
    }

    private String generateRandomString(int length) {
        String characters = "0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));


        }

        return stringBuilder.toString();
    }
}
