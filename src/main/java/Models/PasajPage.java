package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasajPage extends BaseModel {

    private final By basket = By.xpath("//a[contains(@class,'basket')]");
    private final By emptyBasket = By.xpath("//div[contains(@class, 'info-card')]/h3");
    private final By macbook = By.xpath("//a[@title='Apple Macbook']");

    public PasajPage(WebDriver driver) {
        super(driver, PasajPage.class.getName());
    }

    /**
     * Click cart element
     */
    public PasajPage clickCart() {
        actions.clickElement(basket);
        return this;
    }

    /**
     * Get cart label
     *
     * @return cart label
     */
    public String getEmptyLabel() {
        return actions.getText(emptyBasket);
    }

    /**
     * Compare to expected and actual label
     *
     * @param expectedLabel label
     * @param actualLabel label
     */
    public PasajPage verifyEmptyLabel(String expectedLabel, String actualLabel) {
        validation.verifyTextEqualsToData(actualLabel, expectedLabel);
        return this;
    }

    /**
     * Scroll to end of page
     */
    public PasajPage scrollToBottom() {
        actions.scrollToEndOfPage(driver);
        return this;
    }

    /**
     * Click popular macbook label
     *
     * @return FilteredList object
     */
    public FilteredList clickMacbook() {
        actions.clickElement(macbook);
        return new FilteredList(driver);
    }

}
