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


abstract class Actions {

    protected void clickElement(WebDriver driver, long seconds, By by, String className) {
        try {
            LogUtil.log(Constants.CLICK_ELEMENT + by, LogUtil.LogType.INFO, className);
            WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            element.click();
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_CLICK_ELEMENT + by, LogUtil.LogType.ERROR, className, e);
        }

    }

    protected void setText(WebDriver driver, By by, CharSequence data, String className) {
        try {
            LogUtil.log(Constants.SEND_KEY_TO_ELEMENT + data, LogUtil.LogType.INFO, className);
            driver.findElement(by).sendKeys(data);
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_SEND_KEY_TO_ELEMENT + by, LogUtil.LogType.ERROR, className, e);
        }

    }

    protected String getText(WebDriver driver, By by, String className) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, className);
            String text = driver.findElement(by).getText();
            LogUtil.log(Constants.TEXT_OF_ELEMENT + text, LogUtil.LogType.INFO, className);
            return text;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.ERROR, className, e);
            return "";
        }
    }
    protected String getAttributeValue(WebDriver driver, By by, String string, String className) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, className);
            String text = driver.findElement(by).getAttribute(string);
            LogUtil.log(Constants.TEXT_OF_ELEMENT + text, LogUtil.LogType.INFO, className);
            return text;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.ERROR, className, e);
            return "";
        }
    }

    protected void verifyTextEqualsToData(String actual, String expected, String className) {
        LogUtil.log(Constants.VERIFY_TEXT_EQUALS + actual + " || " + expected, LogUtil.LogType.INFO, className);
        Assert.assertEquals(Utils.toUpperCase(actual), Utils.toUpperCase(expected));
    }

    protected void verifyTrue(Boolean a, String className) {
        try {
            LogUtil.log(Constants.VERIFY_TRUE + a, LogUtil.LogType.INFO, className);
            Assert.assertTrue(a);
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_VERIFY_TRUE + a, LogUtil.LogType.ERROR, className);
        }
    }

    protected void scrollToEndOfPage(WebDriver driver,String className) {
        LogUtil.log(Constants.SCROLL_TO_END, LogUtil.LogType.INFO, className);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected Boolean verifyElementDisplayed(WebDriver driver, By by, String className) {
        try {
            LogUtil.log(Constants.VERIFY_ELEMENT_DISPLAYED + by, LogUtil.LogType.INFO, className);
            driver.findElement(by).isDisplayed();
            return true;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_VERIFY_ELEMENT_DISPLAYED + by, LogUtil.LogType.ERROR, className, e);
            return false;
        }
    }


}
