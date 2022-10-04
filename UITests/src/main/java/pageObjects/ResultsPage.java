package pageObjects;

import commonCommands.ElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
    WebDriver driver;
    ElementExtensions elementExtensions;

    public ResultsPage(WebDriver driver){
        elementExtensions = new ElementExtensions();
        this.driver = driver;
    }

    public void sortBy(String option) {
        //Sort search by the given parameter.
        WebElement element = driver.findElement(By.id("a-autoid-0"));
        elementExtensions.highlightElement(element, driver).click();
        element = driver.findElement(By.xpath(String.format("//*[text()='%s']", option)));
        elementExtensions.highlightElement(element, driver).click();
    }

    public void selectItemByPosition(int position){
        //Sort search by the given parameter.
        WebElement element = driver.findElement(By.xpath(String.format("(//img[@class='s-image'] [@data-image-source-density = 1])[%s]",String.valueOf(position))));
        elementExtensions.highlightElement(element, driver).click();
    }
}
