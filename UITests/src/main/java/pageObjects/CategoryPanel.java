package pageObjects;

import commonCommands.ElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPanel {
    WebDriver driver;
    ElementExtensions elementExtensions;

    public CategoryPanel(WebDriver driver){
        elementExtensions = new ElementExtensions();
        this.driver = driver;
    }

    public void navigateToInCategoryPanel(String text){
        //Locate element inside category panel in left menu.
        WebElement element = driver.findElement(By.xpath(String.format("//span[text()='%s']", text)));
        elementExtensions.highlightElement(element, driver).click();
    }
}
