import Models.MainPage;
import Models.SearchResultPage;
import Utils.Constants;
import org.testng.annotations.Test;
import Test.BaseTest;

public class SearchDevice extends BaseTest {

    @Test
    public void searchDevice() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearch().setSearchInput(Constants.DEVICE_NAME);

        SearchResultPage searchResultPage = mainPage.enterSearchIntput().clickDevicesTab();

        searchResultPage.verifyDeviceName(Constants.DEVICE_NAME, searchResultPage.getDeviceName());
    }
}
