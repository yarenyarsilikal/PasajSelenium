package Models;

import Utils.LogUtil;
import Utils.Utils;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SearchResult {
    protected static WebDriver driver;

    private By devicesTab = By.xpath("//a[@title='Cihazlar']");
    private By firstDevice = By.xpath("//*[@id='tabDevices']/div[1]/a/div/span");
    private String className = this.getClass().getName();


    public SearchResult(WebDriver driver) {
        this.driver = driver;
    }


    public void clickDevicesTab() {
        LogUtil.log(Constants.FINDING_ELEMENT + devicesTab, LogUtil.LogType.INFO, className);
        driver.findElement(devicesTab).click();
    }

    public String getDeviceName() {
        LogUtil.log(Constants.FINDING_ELEMENT + firstDevice, LogUtil.LogType.INFO, className);
        return driver.findElement(firstDevice).getText();
    }

    public void verifyDeviceName(String expectedDeviceName, String actualDeviceName ) {
        LogUtil.log(Constants.VERIFY_TEXT_EQUALS + actualDeviceName + " || " + expectedDeviceName, LogUtil.LogType.INFO, className);
        Assert.assertEquals(Utils.toUpperCase(actualDeviceName), Utils.toUpperCase(expectedDeviceName));
    }
}
