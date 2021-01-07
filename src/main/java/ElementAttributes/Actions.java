package ElementAttributes;

import Utils.Constants;
import Utils.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Actions {

    private static String className;

    public Actions(String className){
        setClassName(className);
    }

    private static String getClassName() {
        return className;
    }

    private static void setClassName(String className) {
        Actions.className = className;
    }

    public void clickElement(WebDriver driver, long seconds, By by) {
        try {
            LogUtil.log(Constants.CLICK_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
            WebElement element = new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(by));
            element.click();
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_CLICK_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
        }

    }

    public void setText(WebDriver driver, By by, CharSequence data) {
        try {
            LogUtil.log(Constants.SEND_KEY_TO_ELEMENT + data, LogUtil.LogType.INFO, getClassName());
            driver.findElement(by).sendKeys(data);
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_SEND_KEY_TO_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
        }

    }

    public String getText(WebDriver driver, By by) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
            String text = driver.findElement(by).getText();
            LogUtil.log(Constants.TEXT_OF_ELEMENT + text, LogUtil.LogType.INFO, getClassName());
            return text;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
            return "";
        }
    }
    public String getAttributeValue(WebDriver driver, By by, String string) {
        try {
            LogUtil.log(Constants.GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.INFO, getClassName());
            String text = driver.findElement(by).getAttribute(string);
            LogUtil.log(Constants.TEXT_OF_ELEMENT + text, LogUtil.LogType.INFO, getClassName());
            return text;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_GET_TEXT_OF_ELEMENT + by, LogUtil.LogType.ERROR, getClassName(), e);
            return "";
        }
    }

    public void scrollToEndOfPage(WebDriver driver) {
        LogUtil.log(Constants.SCROLL_TO_END, LogUtil.LogType.INFO, getClassName());
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
