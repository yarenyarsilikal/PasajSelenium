package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasajPage extends BaseModel {

    private final By basket = By.xpath("//a[contains(@class,'basket')]");
    private final By emptyBasket = By.xpath("//div[contains(@class, 'info-card')]/h3");
    private final By macbook = By.xpath("//a[@title='Apple Macbook']");

    private final String className = this.getClass().getName();

    public PasajPage(WebDriver driver) {
        super(driver, PasajPage.class.getName());
    }

    public void clickCart() {
        actions.clickElement(driver, 10, basket);
    }

    public String getEmptyLabel() {
        return actions.getText(driver, emptyBasket);
    }

    public void verifyEmptyLabel(String expectedLabel, String actualLabel) {
        validation.verifyTextEqualsToData(actualLabel, expectedLabel);
    }

    public void scrollToBottom() {
        actions.scrollToEndOfPage(driver);
    }

    public FilteredList clickMacbook(){
        actions.clickElement(driver, 10, macbook);
        return new FilteredList(driver);
    }

}
