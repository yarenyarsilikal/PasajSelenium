package Test;

import Utils.Constants;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        PropertyConfigurator.configure(Constants.LOG4J_PATH);
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH + "chromedriver");
    }


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT_THIRTY, TimeUnit.SECONDS);
        driver.get(Constants.URL);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


}
