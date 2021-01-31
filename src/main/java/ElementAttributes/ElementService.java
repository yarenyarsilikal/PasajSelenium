package ElementAttributes;

import Models.BaseModel;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementService {
    private final WebDriverWait wait = new WebDriverWait(BaseModel.driver, Constants.DEFAULT_WAIT_THIRTY);


    protected WebElement getElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement getClickableElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
