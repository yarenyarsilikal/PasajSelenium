package ElementAttributes;

import Utils.Constants;
import Utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Actions {

    private static String className;

    public Actions(String className) {
        setClassName(className);
    }

    private static String getClassName() {
        return className;
    }

    private static void setClassName(String className) {
        Actions.className = className;
    }

    /**
     * Clicks element
     *  @param driver
     * @param by
     */
    public void clickElement(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_THIRTY);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
            LogUtil.log(Constants.CLICK_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_CLICK_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
        }
    }

    /**
     * Set a text to element
     *
     * @param driver
     * @param by
     * @param data
     */
    public void setText(WebDriver driver, By by, CharSequence data) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_THIRTY);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(data);
            LogUtil.log(Constants.SEND_KEY_TO_ELEMENT + data, LogUtil.LogType.INFO, getClassName());
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_SEND_KEY_TO_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
        }
    }

    /**
     * Get text from element
     *
     * @param driver
     * @param by
     * @return text of element
     */
    public String getText(WebDriver driver, By by) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_THIRTY);
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
            LogUtil.log(Constants.TEXT_OF_ELEMENT + text, LogUtil.LogType.INFO, getClassName());
            return text;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
            return null;
        }
    }

    /**
     * Get a value of an element attribute
     *
     * @param driver
     * @param by
     * @param attribute
     * @return given attribute value of element
     */
    public String getAttributeValue(WebDriver driver, By by, String attribute) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_THIRTY);
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getAttribute(attribute);
            LogUtil.log(Constants.TEXT_OF_ELEMENT + text, LogUtil.LogType.INFO, getClassName());
            return text;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
            return null;
        }
    }

    /**
     * Scroll to end of page
     *
     * @param driver
     */
    public void scrollToEndOfPage(WebDriver driver) {
        LogUtil.log(Constants.SCROLL_TO_END, LogUtil.LogType.INFO, getClassName());
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
