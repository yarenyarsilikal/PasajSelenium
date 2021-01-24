import Models.MainPage;
import Models.PasajPage;
import Utils.Constants;
import org.testng.annotations.Test;
import Test.BaseTest;

public class CheckEmptyBasket extends BaseTest {

    @Test
    public void checkEmptyBasket() {
        MainPage mainPage = new MainPage(driver);

        PasajPage pasajPage = mainPage.clickPasaj().clickCart();

        String actualLabel = pasajPage.getEmptyLabel();
        pasajPage.verifyEmptyLabel(Constants.EMPTY_BASKET_LABEL, actualLabel);
    }
}
