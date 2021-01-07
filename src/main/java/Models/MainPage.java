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

    public void clickSearch() {
        actions.clickElement(driver, 10, search);
    }

    public SearchResultPage search(String deviceName) {
        actions.setText(driver, searchInput, deviceName);
        actions.setText(driver, searchInput, Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public PasajPage clickPasaj() {
        actions.clickElement(driver, 10, pasaj);
        return new PasajPage(driver);
    }

}
