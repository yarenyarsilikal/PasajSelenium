package Models;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utils.Constants;


public class ProductPage extends Actions {

    protected static WebDriver driver;

    private final By price = By.className("a-price-val");
    private static final By sixMonths = By.xpath("//a[@title='6 AY']");
    private static final By nineMonths = By.xpath("//a[@title='9 AY']");
    private static final By twelveMonths = By.xpath("//a[@title='12 AY']");

    private final String className = this.getClass().getName();
    public static final String DATA_PRICE = "data-price";


    public enum PaymentCount {
        SIX {
            @Override
            public By setLocator() {
                return sixMonths;
            }
        },
        NINE {
            @Override
            public By setLocator() {
                return nineMonths;
            }
        },
        TWELVE {
            @Override
            public By setLocator() {
                return twelveMonths;
            }
        };

        public abstract By setLocator();
    }

    public ProductPage(WebDriver driver) {
        ProductPage.driver = driver;
    }

    public String getPayment() {
        return getText(driver, price, className);
    }

    public String getPaymentAmount(By by) {
        return getAttributeValue(driver, by, DATA_PRICE , className);
    }



    public void comparePayment(String actualPrice, String expectedPrice) {
        verifyTrue((Utils.toFloat(actualPrice) > Utils.toFloat(expectedPrice)), className);
    }

}
