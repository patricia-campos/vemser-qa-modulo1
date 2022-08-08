package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elements extends Browser {

    protected static WebElement element (By by) {
        return driver.findElement(by);
    }

    protected static void waitElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
