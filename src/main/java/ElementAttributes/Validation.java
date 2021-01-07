package ElementAttributes;

import Utils.Constants;
import Utils.LogUtil;
import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validation {

    private static String className;

    public Validation(String className) {
        setClassName(className);
    }

    private String getClassName() {
        return className;
    }

    private void setClassName(String className) {
        Validation.className = className;
    }

    /**
     * Verify given data are equals
     *
     * @param actual
     * @param expected
     */
    public void verifyTextEqualsToData(String actual, String expected) {
        LogUtil.log(Constants.VERIFY_TEXT_EQUALS + actual + " || " + expected, LogUtil.LogType.INFO, getClassName());
        Assert.assertEquals(Utils.toUpperCase(actual), Utils.toUpperCase(expected));
    }

    /**
     * Verify @param a is true
     *
     * @param a
     */
    public void verifyConditionIsTrue(boolean a) {
        try {
            LogUtil.log(Constants.VERIFY_TRUE + a , LogUtil.LogType.INFO, getClassName());
            Assert.assertTrue(a);
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_VERIFY_TRUE + a, LogUtil.LogType.ERROR, getClassName());
        }
    }

    /**
     * Verify element is displayed
     *
     * @param driver
     * @param by
     * @return is displayed
     */
    public Boolean verifyElementDisplayed(WebDriver driver, By by) {
        try {
            LogUtil.log(Constants.VERIFY_ELEMENT_DISPLAYED + by, LogUtil.LogType.INFO, getClassName());
            driver.findElement(by).isDisplayed();
            return true;
        } catch (Exception e) {
            LogUtil.log(Constants.COULD_NOT_VERIFY_ELEMENT_DISPLAYED + by, LogUtil.LogType.ERROR, getClassName(), e);
            return false;
        }
    }
}
