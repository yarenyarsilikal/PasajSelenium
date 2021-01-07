package Models;

import ElementAttributes.Actions;
import ElementAttributes.Validation;
import org.openqa.selenium.WebDriver;

public abstract class BaseModel {

    public static WebDriver driver;
    public String className;

    public static Actions actions;
    public static Validation validation;

    public BaseModel(WebDriver driver, String className) {
        BaseModel.driver = driver;
        this.className = className;
        actions = new Actions(className);
        validation = new Validation(className);
    }

}
