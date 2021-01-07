package Test;

import Models.MainPage;
import Models.SearchResultPage;
import Utils.Constants;
import org.testng.annotations.Test;


public class SearchDevice extends BaseTest{

    @Test
    public void searchDevice() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearch();

        SearchResultPage searchResultPage = mainPage.search(Constants.DEVICE_NAME);
        searchResultPage.clickDevicesTab();

        String actualDeviceName = searchResultPage.getDeviceName();
        searchResultPage.verifyDeviceName(Constants.DEVICE_NAME, actualDeviceName);
    }

}
