package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasajPage extends Actions {

    protected static WebDriver driver;

    private final By basket = By.xpath("//a[contains(@class,'basket')]");
    private final By emptyBasket = By.xpath("//div[contains(@class, 'info-card')]/h3");
    private final By macbook = By.xpath("//a[@title='Apple Macbook']");


    private final String className = this.getClass().getName();


    public PasajPage(WebDriver driver) {
        PasajPage.driver = driver;
    }

    public void clickCart() {
        clickElement(driver, 10, basket, className);
    }

    public String getEmptyLabel() {
        return getText(driver, emptyBasket, className);
    }

    public void verifyEmptyLabel(String expectedLabel, String actualLabel) {
        verifyTextEqualsToData(actualLabel, expectedLabel, className);
    }

    public void scrollToBottom() {
        scrollToEndOfPage(driver, className);
    }

    public FilteredList clickMacbook(){
        clickElement(driver, 10, macbook, className);
        return new FilteredList(driver);
    }


}
