package Models;

import Utils.Constants;
import Utils.LogUtil;
import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


abstract  class Actions {

    protected void clickElement(WebDriver driver, long seconds, By by, String className) {
        LogUtil.log(Constants.CLICK_ELEMENT + by, LogUtil.LogType.INFO, className);
        WebElement element = new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
    protected void setText(WebDriver driver, By by,CharSequence data, String className) {
        LogUtil.log(Constants.SEND_KEY_TO_ELEMENT + data, LogUtil.LogType.INFO, className);
        driver.findElement(by).sendKeys(data);
    }
    protected String getText(WebDriver driver, By by, String className) {
        LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by , LogUtil.LogType.INFO, className);
        String text = driver.findElement(by).getText();
        LogUtil.log(Constants.TEXT_OF_ELEMENT + text , LogUtil.LogType.INFO, className);
        return text;
    }

    protected void verifyTextEqualsToData(String actual, String expected, String className){
        LogUtil.log(Constants.VERIFY_TEXT_EQUALS + actual + " || " + expected, LogUtil.LogType.INFO, className);
        Assert.assertEquals(Utils.toUpperCase(actual), Utils.toUpperCase(expected));
    }

    protected void scrollToEndOfPage(WebDriver driver, String className){
        LogUtil.log(Constants.SCROLL_TO_END, LogUtil.LogType.INFO, className);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}
