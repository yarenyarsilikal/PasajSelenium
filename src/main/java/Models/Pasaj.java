package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pasaj extends Actions {

    protected static WebDriver driver;

    private By basket = By.xpath("//a[contains(@class,'basket')]");
    private By emptyBasket = By.xpath("//div[contains(@class, 'info-card')]/h3");

    private String className = this.getClass().getName();


    public Pasaj(WebDriver driver) {
        this.driver = driver;
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


}
