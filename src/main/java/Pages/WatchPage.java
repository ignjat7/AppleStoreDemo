package Pages;

import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WatchPage extends Page {
    //click on apple watch nike icon by xpath:".//*[@id="chapternav"]/div/ul/li[2]/a/figure"
    private void AppleWatcIcon() {
        clickOnElement(By.xpath(".//*[@id=\"chapternav\"]/div/ul/li[2]/a/figure"));
        System.out.println("WatchIcon");
    }

    //click on kaufen btn by xpath:".//*[@id="ac-localnav"]/div/div[2]/div/div/div/a"
    private void KaufenBtn() throws InterruptedException {
        clickOnElement(By.xpath(".//*[@id=\"ac-localnav\"]/div/div[2]/div/div/div/a"));
        System.out.println("Kaufen");
        Thread.sleep(3000);
    }

    //choose gps + celular, first check if element is displayed and then click by xpath:".//*[@ data-part-number="MQM72ZD/A"]/button[@ data-autom="productTitle-3"]"
    private void Model() throws InterruptedException {
        WebElement chooseCelModel = driver.findElement(By.xpath(".//*[@ data-part-number=\"MQM72ZD/A\"]/button[@ data-autom=\"productTitle-3\"]"));
        chooseCelModel.isDisplayed();
        System.out.println("is displayed: " + chooseCelModel.isDisplayed());

        if (chooseCelModel.isDisplayed()) {
            chooseCelModel.click();
            System.out.println("model is chosen");
        }else {
            Actions actions = new Actions(driver);
            actions.moveToElement(chooseCelModel).click().perform();
            System.out.println("The model is chosen now");

            Thread.sleep(3000);
        }
    }

    //click on 32mm by xpath".//*[@id="Item1-dimensionCaseSize-38mm"]"
    private void Size() throws InterruptedException {
        WebElement chooseSize = driver.findElement(By.xpath(".//*[@id=\"Item1-dimensionCaseSize-38mm\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseSize).click().perform();
        System.out.println("Size");
        Thread.sleep(3000);
    }

    //click on proceed btn, first check if displayed, and then click by xpath".//*[@id="primary"]/summary-builder/div[3]/div[1]/div/div/div[1]/div/form/div/span/button"
    //or xpath:.//*[@data-part-number="MQM72ZD/A"]/div/span/button[@data-autom="add-to-cart"]
    private void Proceed() {
        WebElement proceedBtn = driver.findElement(By.xpath(".//*[@data-part-number=\"MQM72ZD/A\"]//div/span/button[@data-autom=\"add-to-cart\"]"));
        proceedBtn.isDisplayed();
        System.out.println("is displayed: " + proceedBtn.isDisplayed());

        if (proceedBtn.isDisplayed()) {
            proceedBtn.click();
            System.out.println("proceed btn is chosen");
        }else {
            Actions actions = new Actions(driver);
            actions.moveToElement(proceedBtn).click().perform();
            System.out.println("The proceed btn is chosen now");
        }
    }
    //click on bezahlen btn by xpath:".//*[@id="summaryheader-form"]/div/span/button"
    private void Bezahlen() {
        WebElement bezahlenBtn = waitForElementVisibility(By.xpath(".//*[@id=\"summaryheader-form\"]/div/span/button"));
        bezahlenBtn.click();
        System.out.println("bezahlen");
    }

    //click on cancel btn by xpath:".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"
    private void CancelOrder() {
        WebElement cancelOrder = waitForElementVisibility(By.xpath(".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"));
        cancelOrder.click();
        System.out.println("cancel order");
    }

    public void chooseAppleWatch() throws InterruptedException {
        AppleWatcIcon();
        KaufenBtn();
        Model();
        Size();
        Proceed();
        Bezahlen();
        CancelOrder();
    }
}