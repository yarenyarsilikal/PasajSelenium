package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResult extends Actions {
    protected static WebDriver driver;

    private By devicesTab = By.xpath("//a[@title='Cihazlar']");
    private By firstDevice = By.xpath("//*[@id='tabDevices']/div[1]/a/div/span");
    private String className = this.getClass().getName();


    public SearchResult(WebDriver driver) {
        this.driver = driver;
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
