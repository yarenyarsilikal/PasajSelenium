package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage extends BaseModel {


    private final By price = By.className("a-price-val");
    private static final By sixMonths = By.xpath("//a[@title='6 AY']");
    private static final By nineMonths = By.xpath("//a[@title='9 AY']");
    private static final By twelveMonths = By.xpath("//a[@title='12 AY']");

    public static final String DATA_PRICE = "data-price";

    public ProductPage(WebDriver driver) {
        super(driver, ProductPage.class.getName());
    }

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

    public String getPayment() {
        return actions.getText(driver, price);
    }

    public String getPaymentAmount(By by) {
        return actions.getAttributeValue(driver, by, DATA_PRICE);
    }

    public void comparePayment(String actualPrice, String expectedPrice) {
        validation.verifyTrue(actualPrice, expectedPrice);
    }

}
