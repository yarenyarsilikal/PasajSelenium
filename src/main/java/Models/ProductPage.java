package Models;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage extends Actions {

    protected static WebDriver driver;

    private final By productDetail = By.className("product-detail-top");

    private final String className = this.getClass().getName();

    public ProductPage(WebDriver driver) {
        ProductPage.driver = driver;
    }

    public Boolean verifyProductDetailPageLoaded() {
        return verifyElementDisplayed(driver, productDetail, className);
    }

    public Boolean comparePayment(String actualPrice, String expectedPrice) {
        return (Utils.toInt(actualPrice) > Utils.toInt(expectedPrice));
    }

}
