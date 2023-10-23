package tests;

import helpers.RetryAnalyzer;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES(){
        navPage.clickOnLanguageButton();
        navPage.clickLanguageFromList(1);
        navPage.verifyHeaderTextBySpanish();
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN(){
        navPage.clickOnLanguageButton();
        navPage.clickLanguageFromList(0);
        navPage.verifyHeaderTextByEnglish();
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCN(){
        navPage.clickOnLanguageButton();
        navPage.clickLanguageFromList(3);
        navPage.verifyHeaderTextByChinese();
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFR(){
        navPage.clickOnLanguageButton();
        navPage.clickLanguageFromList(2);
        navPage.verifyHeaderTextByFrench();
    }
}
