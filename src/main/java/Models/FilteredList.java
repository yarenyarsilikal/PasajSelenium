package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilteredList extends BaseModel {


    private final By macbookPro = By.xpath("(//*[contains(text(),'Apple MacBook Pro Touch Bar 13 inç')])[1]");

    public FilteredList(WebDriver driver) {
        super(driver, FilteredList.class.getName());
    }


    public ProductPage chooseMacbookPro() {
        actions.clickElement(driver, 10, macbookPro);
        return new ProductPage(driver);
    }

}
