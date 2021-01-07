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
    public void clickCart() {
        actions.clickElement(driver, basket);
    }

    /**
     * Get cart label
     *
     * @return cart label
     */
    public String getEmptyLabel() {
        return actions.getText(driver, emptyBasket);
    }

    /**
     * Compare to expected and actual label
     *
     * @param expectedLabel
     * @param actualLabel
     */
    public void verifyEmptyLabel(String expectedLabel, String actualLabel) {
        validation.verifyTextEqualsToData(actualLabel, expectedLabel);
    }

    /**
     * Scroll to end of page
     */
    public void scrollToBottom() {
        actions.scrollToEndOfPage(driver);
    }

    /**
     * Click popular macbook label
     *
     * @return FilteredList object
     */
    public FilteredList clickMacbook() {
        actions.clickElement(driver, macbook);
        return new FilteredList(driver);
    }

}
