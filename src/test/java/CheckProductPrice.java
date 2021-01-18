import Models.FilteredList;
import Models.MainPage;
import Models.PasajPage;
import Models.ProductPage;
import Utils.Constants;
import org.testng.annotations.Test;
import Test.BaseTest;


public class CheckProductPrice extends BaseTest {

    @Test
    public void checkPrice() {
        MainPage mainPage = new MainPage(driver);

        PasajPage pasajPage = mainPage.clickPasaj();
        pasajPage.scrollToBottom();
        pasajPage.clickMacbook();

        FilteredList filteredList = pasajPage.clickMacbook();
        ProductPage productPage = filteredList.chooseMacbookPro();

        String actualPrice = productPage.getPayment();
        productPage.comparePayment(actualPrice, Constants.EXPECTED_PRICE);

        String sixMonths = productPage.getPaymentAmount(ProductPage.PaymentCount.SIX.setLocator());
        String nineMonths = productPage.getPaymentAmount(ProductPage.PaymentCount.NINE.setLocator());
        productPage.comparePayment(sixMonths, nineMonths);
    }
}