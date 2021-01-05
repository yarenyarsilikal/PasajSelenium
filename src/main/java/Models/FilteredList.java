package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilteredList extends Actions {

    protected static WebDriver driver;

    private final By macbookPro = By.xpath("(//*[contains(text(),'Apple MacBook Pro Touch Bar 13')])[1]");


    private final String className = this.getClass().getName();


    public FilteredList(WebDriver driver) {
        FilteredList.driver = driver;
    }

    public ProductPage clickMacbook() {
        clickElement(driver, 10, macbookPro, className);
        return new ProductPage(driver);
    }

}
