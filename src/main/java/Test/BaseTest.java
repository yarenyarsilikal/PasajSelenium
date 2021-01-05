package Test;

import Models.MainPage;
import Utils.Constants;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        PropertyConfigurator.configure(Constants.LOG4J_PATH);
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(Constants.URL);
    }

    @AfterTest
    public void killDriver(){
        driver.quit();
    }
}
