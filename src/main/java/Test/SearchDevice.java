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

public class SearchDevice extends BaseTest{

    private MainPage mainPage;

    @Test
    public void searchDevice() {
        mainPage = new MainPage(driver);
        mainPage.clickSearch();

        SearchResultPage searchResultPage = mainPage.search(Constants.DEVICE_NAME);
        searchResultPage.clickDevicesTab();

        String actualDeviceName = searchResultPage.getDeviceName();
        searchResultPage.verifyDeviceName(Constants.DEVICE_NAME, actualDeviceName);
    }

}
