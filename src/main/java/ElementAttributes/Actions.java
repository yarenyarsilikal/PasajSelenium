package ElementAttributes;

import Utils.Constants;
import Utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class Actions extends ElementService {

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
     *
     * @param by target element locator
     */
    public void clickElement(By by) {
        try {
            getElement(by);
            getClickableElement(by).click();
            LogUtil.log(Constants.CLICK_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_CLICK_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
        }
    }

    /**
     * Set a text to element
     *
     * @param by   target element locator
     * @param data given text
     */
    public void setText(By by, CharSequence data) {
        try {
            getElement(by).sendKeys(data);
            LogUtil.log(Constants.SEND_KEY_TO_ELEMENT + data, LogUtil.LogType.INFO, getClassName());
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_SEND_KEY_TO_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
        }
    }

    /**
     * Get text from element
     *
     * @param by target element locator
     * @return text of element
     */
    public String getText(By by) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
            String text = getElement(by).getText();
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
     * @param by        target element locator
     * @param attribute given attribute of element
     * @return given attribute value of element
     */
    public String getAttributeValue(By by, String attribute) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
            String text = getElement(by).getAttribute(attribute);
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
     * @param driver web driver
     */
    public void scrollToEndOfPage(WebDriver driver) {
        LogUtil.log(Constants.SCROLL_TO_END, LogUtil.LogType.INFO, getClassName());
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
