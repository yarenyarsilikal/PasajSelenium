package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage extends Actions {
    protected static WebDriver driver;

    private final By devicesTab = By.xpath("//a[@title='Cihazlar']");
    private final By firstDevice = By.xpath("//*[@id='tabDevices']/div[1]/a/div/span");

    private final String className = this.getClass().getName();


    public SearchResultPage(WebDriver driver) {
        SearchResultPage.driver = driver;
    }


    public void clickDevicesTab() {
        clickElement(driver, 10, devicesTab, className);
    }

    public String getDeviceName() {
        return getText(driver,firstDevice,className);
    }

    public void verifyDeviceName(String expectedDeviceName, String actualDeviceName ) {
        verifyTextEqualsToData(actualDeviceName, expectedDeviceName, className);
    }
}
