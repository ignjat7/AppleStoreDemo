package Pages;

import framework.Helper;
import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IpadPage extends Page {

    private void clickOnIpadIcon() {
        clickOnElement(By.xpath("//*[@id=\"chapternav\"]/div/ul/li[1]"));
    }

    private void clickOnKaufen() {
        System.out.println("Click on buy button");
        WebElement goToKaufen = waitForElementVisibility(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div/div[2]/div[2]/a"));
        goToKaufen.click();
    }

    private void chooseModel() throws InterruptedException {

        //select display size
        //find displaySizeRadioButton via xpath because id is dynamic
        System.out.println("FindProcessorRadioButton");
        WebElement displaySizeRadioButton = driver.findElement(By.xpath(".//*[@data-autom=\"dimensionScreensize-12_9inch\"]"));

        //is it selected already?
        System.out.println("Selected: " + displaySizeRadioButton.isSelected());

        //move to displaySizeRadioButton and click over with javascript
        System.out.println("Move and click on displaySizeRadioButton");
        Actions actions = new Actions(driver);
        actions.moveToElement(displaySizeRadioButton).click().perform();

        //is selected now ?!
        System.out.println("Selected: " + displaySizeRadioButton.isSelected());

        //sleep random time to prevent antibot problems
        int sleepSeconds = Helper.getRandomNumberInRange(3, 7);
        System.out.println("Sleeping: " + sleepSeconds);
        Thread.sleep(sleepSeconds * 1000);
        System.out.println("Continue...");

        //select gold color
        //find colorRadioButton via id
        System.out.println("FindColorRadioButton");
        WebElement colorRadioButton = driver.findElement(By.id("dimensionColor-gold"));

        //is it selected already?
        System.out.println("Selected: " + colorRadioButton.isSelected());

        //move to colorRadioButton and click over with javascript
        System.out.println("Move and click on colorRadioButton");
        actions.moveToElement(colorRadioButton).click().perform();

        //is selected now ?!
        System.out.println("Selected: " + colorRadioButton.isSelected());

        // if not selected stop test and display error
        if (!colorRadioButton.isSelected()) {
            System.out.println("\u001B[31m" + "Something went wrong!" + "\u001B[0m");
            System.exit(1);
        }

        //select capacity
        //find capacityRadioButton via id
        System.out.println("FindCapacityRadioButton");
        WebElement capacityRadioButton = driver.findElement(By.id("Item3-dimensionCapacity-256gb"));

        //is it selected already?
        System.out.println("Selected: " + capacityRadioButton.isSelected());

        //sometimes clicks are to fast to be registered try wile it selects
        int counter = 0;
        while (!capacityRadioButton.isSelected() & counter < 10) {
            counter++;
            if (counter > 1) {
                System.out.println("\u001B[31m" + "Click number: " + counter + "\u001B[0m");
            }
            //move to capacityRadioButton and click over with javascript
            System.out.println("Move and click on capacityRadioButton");
            actions.moveToElement(capacityRadioButton).click().perform();
        }

        // if not selected after 10 clicks stop test and display error
        if (counter >= 10) {
            System.out.println("\u001B[31m" + "Something went wrong!" + "\u001B[0m");
            System.exit(1);
        }

        //is selected now ?!
        System.out.println("Selected: " + capacityRadioButton.isSelected());

        //select dimensionConnection
        //find dimensionConnectionRadioButton via id
        System.out.println("FindDimensionConnectionRadioButton");
        WebElement dimensionConnectionRadioButton = driver.findElement(By.id("Item4-dimensionConnection-wifi"));

        //is it selected already?
        System.out.println("Selected: " + dimensionConnectionRadioButton.isSelected());

        //sleep random time to prevent antibot problems
        Helper.getRandomNumberInRange(2, 5);
        System.out.println("Sleeping: " + sleepSeconds);
        Thread.sleep(sleepSeconds * 1000);
        System.out.println("Continue...");

        // select wifi options
        //move to dimensionConnectionRadioButton and click over with javascript
        System.out.println("Move and click on dimensionConnectionRadioButton");
        actions.moveToElement(dimensionConnectionRadioButton).click().perform();

        //is selected now ?!
        System.out.println("Selected: " + dimensionConnectionRadioButton.isSelected());

    }

    private void proceedToPayment() {

        //click on button proceed/forsetzen
        clickOnElement(By.xpath("//*[@id=\"primary\"]/summary-builder/div[4]/div[1]/div/div/div[1]/div/form/div/span/button"));
        System.out.println("Forstezen button is clicked");

        //click on submit/hinzufungen button
        WebElement submitButton = driver.findElement(By.xpath(".//*[@data-autom =\"add-to-cart\"]"));

        //move over submit button with javaScript and click
        System.out.println("Move and click on submitButton");
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();

        //click on proceed/bezahlen button
        WebElement proceedButton = driver.findElement(By.xpath(".//*[@data-autom =\"proceed\"]"));

        //move over proceed/bezahlen button with javaScript and click
        System.out.println("Move and click on proceedButton");
        actions.moveToElement(proceedButton).click().perform();

    }

    private void cancelOrder() {
        //remove item from cart (wait element because there is redirection)
        WebElement cancelOrder = waitForElementVisibility(By.xpath(".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"));
        clickOnElement(cancelOrder);
        System.out.println("order canceled");
    }

    public void chooseIpad() throws InterruptedException {
        clickOnIpadIcon();
        clickOnKaufen();
        chooseModel();
        proceedToPayment();
        cancelOrder();
    }

}