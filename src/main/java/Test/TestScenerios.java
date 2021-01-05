package Test;

import Models.MainPage;
import Models.PasajPage;
import Models.SearchResultPage;
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

        SearchResultPage searchResultPage = mainPage.search(Constants.DEVICE_NAME);
        searchResultPage.clickDevicesTab();

        String actualDeviceName = searchResultPage.getDeviceName();
        searchResultPage.verifyDeviceName(Constants.DEVICE_NAME, actualDeviceName);
    }

    @Test(priority = 2)
    public void checkEmptyBasket() {
        mainPage = new MainPage(driver);

        PasajPage pasajPage = mainPage.clickPasaj();
        pasajPage.clickCart();

        String actualLabel = pasajPage.getEmptyLabel();
        pasajPage.verifyEmptyLabel(Constants.EMPTY_BASKET_LABEL, actualLabel);
    }

    @Test(priority = 3)
    public void checkPrice() {
        mainPage = new MainPage(driver);

        PasajPage pasajPage = mainPage.clickPasaj();




        pasajPage.clickCart();

        String actualLabel = pasajPage.getEmptyLabel();
        pasajPage.verifyEmptyLabel(Constants.EMPTY_BASKET_LABEL, actualLabel);
    }

}
