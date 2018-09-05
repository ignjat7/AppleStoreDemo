package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page extends AbstractPage {

    private static void hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void HoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    public WebElement waitForElementVisibility(By locator) {
        return getWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisibility(WebElement element) {
        return getWait(getDriver()).until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForElementClickability(By locator) {
        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitForElementClickability(WebElement element) {
        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(By locator) {
        WebElement target = waitForElementClickability(locator);
        target.click();
    }

    public void clickOnElement(WebElement element) {
        WebElement target = waitForElementClickability(element);
        target.click();
    }

    public String sendTextOnField(By locator) {
        WebElement inputField = waitForElementVisibility(locator);
        inputField.clear();
        String text = Helper.getRandomText();
        inputField.sendKeys(text);
        return text;
    }

    public String sendTextOnField(WebElement inputField) {
        inputField.clear();
        String text = Helper.getRandomText();
        inputField.sendKeys(text);
        return text;
    }

    public void sendTextOnField(By locator, String text) {
        WebElement inputField = waitForElementVisibility(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void sendTextOnField(WebElement field, String text) {
        WebElement inputField = waitForElementVisibility(field);
        inputField.clear();
        inputField.sendKeys(text);
    }
    public WebElement getVisibility(By locator, int timeout, WebDriver driver) {
        WebElement element = null;
        wait = new WebDriverWait(AbstractPage.driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
    public void clickElementWhenClickable(By locator, int timeout, WebDriver driver) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(AbstractPage.driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

}