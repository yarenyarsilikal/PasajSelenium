package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class MainPage extends BaseModel {

    private final By search = By.xpath("//a[@title='Arama']");
    private final By searchInput = By.name("qx");
    private final By pasaj = By.xpath("//a[@title='Pasaj']");


    public MainPage(WebDriver driver) {
        super(driver, MainPage.class.getName());
    }

    /**
     * Clicks search element
     */
    public MainPage clickSearch() {
        actions.clickElement(search);
        return this;
    }

    /**
     * Sets search input
     *
     * @param deviceName expected device name
     */
    public MainPage setSearchInput(String deviceName) {
        actions.setText(searchInput, deviceName);
        return this;
    }

    /**
     * Click enter for search input
     *
     * @return SearchResultPage object
     */
    public SearchResultPage enterSearchIntput() {
        actions.setText(searchInput, Keys.ENTER);
        return new SearchResultPage(driver);
    }

    /**
     * Click pasaj element
     *
     * @return PasajPage object
     */
    public PasajPage clickPasaj() {
        actions.clickElement(pasaj);
        return new PasajPage(driver);
    }

}
