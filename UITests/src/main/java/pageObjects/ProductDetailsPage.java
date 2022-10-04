package pageObjects;

import commonCommands.ElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    WebDriver driver;
    ElementExtensions elementExtensions;

    public ProductDetailsPage(WebDriver driver){
        elementExtensions = new ElementExtensions();
        this.driver = driver;
    }

    public boolean isElementPresentInPageByText(String text) {
        WebElement element = driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
        elementExtensions.highlightElement(element, driver);
        return element.isDisplayed();
    }
}
