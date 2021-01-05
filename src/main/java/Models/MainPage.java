package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class MainPage extends Actions {
    protected static WebDriver driver;

    private final By search = By.xpath("//a[@title='Arama']");
    private final By searchInput = By.name("qx");
    private final By pasaj = By.xpath("//a[@title='Pasaj']");


    private final String className = this.getClass().getName();


    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }


    public void clickSearch() {
        clickElement(driver, 10, search, className);
    }

    public SearchResultPage search(String deviceName) {
        setText(driver, searchInput, deviceName, className);
        setText(driver, searchInput, Keys.ENTER, className);
        return new SearchResultPage(driver);
    }

    public PasajPage clickPasaj() {
        clickElement(driver, 10, pasaj, className);
        return new PasajPage(driver);
    }

}
