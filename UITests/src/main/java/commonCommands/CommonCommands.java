package commonCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CommonCommands {
    WebDriver driver;
    ElementExtensions elementExtensions;

    public CommonCommands(WebDriver driver){
        elementExtensions = new ElementExtensions();
        this.driver = driver;
    }

    public void clickElementByText(String text){
        //Locate element inside top menu bar as a reference
        WebElement element = driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
        elementExtensions.highlightElement(element, driver).click();
    }

    public void scrollDownToElementWithText(String text){
        WebElement element = driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchToTab(int position){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(position));
    }




}

