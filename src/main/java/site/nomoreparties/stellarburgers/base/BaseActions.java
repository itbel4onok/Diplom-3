package site.nomoreparties.stellarburgers.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {
    protected void click(WebDriver driver, By element){
        driver.findElement(element).click();
    }

    protected void waitForLoadPage(WebDriver webDriver, By element) {
        new WebDriverWait(webDriver, 3).until(driver -> (webDriver.findElement(element).getText() != null
                && !webDriver.findElement(element).getText().isEmpty()
        ));
    }

    protected boolean isElementPresent(WebDriver driver, By element) {
        return driver.findElement(element).getText() != null
                && !driver.findElement(element).getText().isEmpty();
    }

    protected void fillField(WebDriver driver, By element, String value){
        driver.findElement(element).sendKeys(value);
    }

    protected void waitForScrollSectionProcess(WebDriver webDriver){
        new WebDriverWait(webDriver, 1);
    }

    protected boolean checkAttributeContainsText(WebDriver webDriver, By element,
                                                        String attribute, String expectedText) {
        String classText = String.valueOf(webDriver.findElement(element).getAttribute(attribute));
        return classText.contains(expectedText);
    }
}
