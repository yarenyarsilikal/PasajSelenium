package Models;

import Utils.Constants;
import Utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class MainPage {
    protected static WebDriver driver;

    private By search = By.xpath("//a[@title='Arama']");
    private By searchInput = By.name("qx");
    private By pasaj = By.xpath("//a[@title='Pasaj']");

    private String className = this.getClass().getName();


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSearch() {
        LogUtil.log(Constants.CLICK_ELEMENT + search, LogUtil.LogType.INFO, className);
        driver.findElement(search).click();
    }

    public SearchResult search(String deviceName) {
        LogUtil.log(Constants.SEND_KEY_TO_ELEMENT + deviceName, LogUtil.LogType.INFO, className);
        driver.findElement(searchInput).sendKeys(deviceName);
        LogUtil.log(Constants.SEND_KEY_TO_ELEMENT + Keys.ENTER, LogUtil.LogType.INFO, className);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        return new SearchResult(driver);
    }

    public void clickPasaj(String userName) {
        driver.findElement(pasaj).click();
    }
}
