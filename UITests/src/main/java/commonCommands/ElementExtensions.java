package commonCommands;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ElementExtensions {
    public WebElement highlightElement(WebElement element, WebDriver driver){
        Assert.assertTrue(element.isDisplayed() && element.isEnabled());
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
        return element;
    }
}
