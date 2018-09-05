package Pages;

import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IphonePage extends Page {

    //click on iPhoneX icon by xpath:".//*[@id="chapternav"]/div/ul/li[1]/a/figure"
    private void iPhoneXIcon() throws InterruptedException {
        clickOnElement(By.xpath(".//*[@id=\"chapternav\"]/div/ul/li[1]/a/figure"));
        Thread.sleep(3000);
    }

    //click on Kaufen btn by xpath:".//*[@id="ac-localnav"]/div/div[2]/div[2]/div[2]/div[2]/a"
    private void kaufenBtn() {
        clickOnElement(By.xpath(".//*[@id=\"ac-localnav\"]/div/div[2]/div[2]/div[2]/div[2]/a"));
        System.out.println("kaufen");
    }

    //click on Wahlen btn by xpath:".//*[@id="dimensionScreensize-5_8inch-select"]"
    private void wahlenBtn() {
        clickOnElement(By.xpath(".//*[@id=\"dimensionScreensize-5_8inch-select\"]"));
        System.out.println("wahlen");
    }

    //choose color, click on space gray by xpath:".//*[@id="dimensionColor-space_gray"]"
    private void iphoneColor() {
        WebElement chooseColor = driver.findElement(By.xpath(".//*[@id=\"dimensionColor-space_gray\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseColor).click().perform();
        System.out.println("color");
    }

    //choose capacity 64gb by xpath:".//*[@id="Item364gb_label"]"
    private void iphoneCapacity() throws InterruptedException {
        clickOnElement(By.xpath(".//*[@id=\"Item364gb_label\"]"));
        System.out.println("capacity");
        Thread.sleep(3000);
    }

    //click on go to proceed btn /scrol/ by xpath:".//*[@id="main"]/store-provider/step1-modular/materializer/div[2]/div/summary-builder/div/div[3]/div[1]/div/div[1]/form/div/span/button"
    private void proceedBtn() throws InterruptedException {
        //WebElement proceedBtn = driver.findElement(By.xpath(".//*[@id=\"main\"]/store-provider/step1-modular/materializer/div[2]/div/summary-builder/div/div[3]/div[1]/div/div[1]/form/div/span/button"));
        WebElement proceedBtn = driver.findElement(By.xpath(".//button[@data-autom=\"add-to-cart\"]"));
        proceedBtn.isDisplayed();
        System.out.println("is displeyed: " + proceedBtn.isDisplayed());
        proceedBtn.click();
        System.out.println("proceed");

        Thread.sleep(3000);

    }

    //click on bezahlen btn by xpath:".//*[@id="summaryheader-form"]/div/span/button"
    private void bezahlenBtn() {
        WebElement bezahlenBtn = waitForElementVisibility(By.xpath(".//button[@data-autom=\"proceed\"]"));
        // WebElement bezahlenBtn = waitForElementVisibility(By.xpath(".//*[@class=\"as-summaryheader-button\"]"));
        bezahlenBtn.click();
        System.out.println("bezahlen");
    }

    //cancel order by xpath:".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"
    private void cancelOrder() {
        clickOnElement(By.xpath(".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"));
        System.out.println("canceled");
    }

    public void chooseIphone() throws InterruptedException {
        iPhoneXIcon();
        kaufenBtn();
        wahlenBtn();
        iphoneColor();
        iphoneColor();
        iphoneCapacity();
        proceedBtn();
        bezahlenBtn();
        cancelOrder();
    }

}