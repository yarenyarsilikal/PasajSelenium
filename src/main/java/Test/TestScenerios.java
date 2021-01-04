package Test;

import Models.MainPage;
import Models.SearchResult;
import Utils.Constants;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestScenerios {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setupDriver() {
        PropertyConfigurator.configure(Constants.LOG4J_PATH);
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);
    }


    @Test(priority = 1)
    public void searchDevice() {
        mainPage = new MainPage(driver);
        mainPage.clickSearch();

        SearchResult searchResult = mainPage.search(Constants.DEVICE_NAME);
        searchResult.clickDevicesTab();

        String actualDeviceName = searchResult.getDeviceName();
        searchResult.verifyDeviceName(Constants.DEVICE_NAME, actualDeviceName);
    }



}
