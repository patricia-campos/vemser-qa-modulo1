package util;

import org.openqa.selenium.By;

public class BaseTest extends Elements{

    public static void click(By by) {
        waitElement(by);
        element(by).click();
    }

    public static String getText(By by) {
        waitElement(by);
        return  element(by).getText();
    }

    public static void sendKeys(By by, String texto) {
        waitElement(by);
        element(by).sendKeys(texto);
    }

    public static void clear(By by){waitElement(by);
        element(by).clear();
    }

}
