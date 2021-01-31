package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilteredList extends BaseModel {


    private final By macbookPro = By.xpath("(//*[contains(text(),'Apple MacBook Pro Touch Bar 13 inç')])[1]");

    public FilteredList(WebDriver driver) {
        super(driver, FilteredList.class.getName());
    }

    /**
     * Choose Macbook from populer filtered list
     */
    public ProductPage chooseMacbookPro() {
        actions.clickElement(macbookPro);
        return new ProductPage(driver);
    }

}
