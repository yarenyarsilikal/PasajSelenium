package Test;

import Models.MainPage;
import Models.PasajPage;
import Utils.Constants;
import org.testng.annotations.Test;

public class CheckEmptyBasket extends BaseTest {

    private MainPage mainPage;

    @Test
    public void checkEmptyBasket() {
        mainPage = new MainPage(driver);

        PasajPage pasajPage = mainPage.clickPasaj();
        pasajPage.clickCart();

        String actualLabel = pasajPage.getEmptyLabel();
        pasajPage.verifyEmptyLabel(Constants.EMPTY_BASKET_LABEL, actualLabel);
    }
}
