import Models.MainPage;
import Models.SearchResultPage;
import Utils.Constants;
import org.testng.annotations.Test;
import Test.BaseTest;

public class SearchDevice extends BaseTest {

    @Test
    public void searchDevice() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearch();
        mainPage.setSearchInput(Constants.DEVICE_NAME);

        SearchResultPage searchResultPage = mainPage.enterSearchIntput();
        searchResultPage.clickDevicesTab();

        String actualDeviceName = searchResultPage.getDeviceName();
        searchResultPage.verifyDeviceName(Constants.DEVICE_NAME, actualDeviceName);
    }

}
