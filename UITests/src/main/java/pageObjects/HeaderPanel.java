package pageObjects;

import commonCommands.ElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPanel {
    WebDriver driver;
    ElementExtensions elementExtensions;

    public HeaderPanel(WebDriver driver){
        elementExtensions = new ElementExtensions();
        this.driver = driver;
    }

    public void navigateToInHeaderPanel(String menu){
        //Locate element inside top menu bar as a reference
        WebElement element = driver.findElement(By.xpath(String.format("//*[@id='nav-main']//*[contains(text(),'%s')]", menu)));
        elementExtensions.highlightElement(element, driver).click();
    }
}
