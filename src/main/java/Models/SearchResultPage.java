package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage extends BaseModel {

    private final By devicesTab = By.xpath("//a[@title='Cihazlar']");
    private final By firstDevice = By.xpath("//*[@id='tabDevices']/div[1]/a/div/span");

    public SearchResultPage(WebDriver driver) {
        super(driver, SearchResultPage.class.getName());
    }

    /**
     * Click devices tab
     */
    public SearchResultPage clickDevicesTab() {
        actions.clickElement(driver, devicesTab);
        return this;
    }

    /**
     * Get text of searched device
     *
     * @return device name
     */
    public String getDeviceName() {
        return actions.getText(driver, firstDevice);
    }

    /**
     * Verify searched device text equals to expected
     */
    public SearchResultPage verifyDeviceName(String expectedDeviceName, String actualDeviceName) {
        validation.verifyTextEqualsToData(actualDeviceName, expectedDeviceName);
        return this;
    }
}
