package Pages;

import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MacPage extends Page {

    private void clickOnMacIcon() {
        clickOnElement(By.xpath(".//*[@id=\"chapternav\"]/div/ul/li[2]/a/span"));
    }

    private void goToBuy() {
        clickOnElement(By.xpath(".//*[@id=\"ac-localnav\"]/div/div[2]/div[2]/div[2]/div[2]/a"));
    }

    private void chooseConfiguration() {
        //select model
        System.out.println("ModelClick");
        clickOnElement(By.xpath(".//*[@data-part-number=\"MQD32D/A\"]/div/span/button"));

        //find processorRadioButton via xpath because id is dynamic
        System.out.println("FindProcessorRadioButton");
        WebElement processorRadioButton = driver.findElement(By.xpath(".//*[@value=\"065-C63M\"]"));

        //is it selected already?
        System.out.println("Selected: " + processorRadioButton.isSelected());

        //scroll to processorRadioButton (probably not visible)
        System.out.println("ScrollToProcessorRadioButton");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", processorRadioButton);

        //move to processorRadioButton and click over with javascript
        System.out.println("Move and click on processorRadioButton");
        Actions actions = new Actions(driver);
        actions.moveToElement(processorRadioButton).click().perform();

        //is selected now ?!
        System.out.println("Selected: " + processorRadioButton.isSelected());

        //select hdd
        WebElement hddRadioButton = driver.findElement(By.xpath(".//*[@value=\"065-C63X\"]"));
        jse.executeScript("arguments[0].scrollIntoView()", hddRadioButton);
        actions.moveToElement(hddRadioButton).click().perform();

        //select english keyboard (again dynamic dropdown id)
        Select keyboardDropDown = new Select(driver.findElement(By.xpath(".//*[@data-autom=\"configOption-select\"]")));
        keyboardDropDown.selectByValue("LB065-C64L");
    }

    private void addToCart() {
        clickOnElement(By.xpath(".//*[@id=\"actiontray\"]/div/div[2]/div/div/div[2]/button"));
    }

    private void goToPayment() {
        // go to bezalen
        System.out.println( "Go to bezahlen");
        clickOnElement(By.xpath(".//*[@id=\"summaryheader-form\"]/div/span/button/span"));

        //go to chart
        System.out.println( "Go to chart");
        clickOnElement(By.id("cart-actions-checkout"));

        //click cancel because we do not have account
        System.out.println( "Click on Abrechen");
        clickOnElement(By.xpath(".//*[@id=\"cancel-button\"]/span[1]"));

        //remove item from cart (wait element because there is redirection)
        System.out.println( "Click on Entfernen");
        WebElement cancelOrder = waitForElementVisibility(By.xpath(".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"));
        clickOnElement(cancelOrder);
    }

    public void chooseMacProduct() {
        clickOnMacIcon();
        goToBuy();
        chooseConfiguration();
        addToCart();
        goToPayment();
    }
}