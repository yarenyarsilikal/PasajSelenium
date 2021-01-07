package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage extends BaseModel {

    private final By devicesTab = By.xpath("//a[@title='Cihazlar']");
    private final By firstDevice = By.xpath("//*[@id='tabDevices']/div[1]/a/div/span");

    public SearchResultPage(WebDriver driver) {
        super(driver, SearchResultPage.class.getName());
    }

    public void clickDevicesTab() {
        actions.clickElement(driver, 10, devicesTab);
    }

    public String getDeviceName() {
        return actions.getText(driver,firstDevice);
    }

    public void verifyDeviceName(String expectedDeviceName, String actualDeviceName ) {
        validation.verifyTextEqualsToData(actualDeviceName, expectedDeviceName);
    }
}
