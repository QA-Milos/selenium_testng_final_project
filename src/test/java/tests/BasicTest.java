package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.NavPage;
import pages.SignupPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BasicTest{
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, wait);
        navPage = new NavPage(driver,wait);
        signupPage = new SignupPage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    private void takesScreenshot(ITestResult result) throws IOException {
        if (driver instanceof TakesScreenshot) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String testName = result.getName();
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormat.format(now);

            Files.copy(file.toPath(), new File(
                    "C:\\Users\\josif\\OneDrive\\Desktop\\projektins\\selenium_testng_final_project\\screenshots\\" + testName + "_" + timestamp + ".jpg")
                    .toPath());
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.localStorage.clear();");
//        driver.manage().deleteAllCookies();

        if (result.getStatus() == ITestResult.FAILURE) {
            takesScreenshot(result);
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}