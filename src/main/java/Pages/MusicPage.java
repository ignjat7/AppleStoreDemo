package Pages;

import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MusicPage extends Page {

    private void iPodTouchIcon() {
        clickOnElement(By.xpath("//*[@id=\"chapternav\"]/div/ul/li[4]/a/figure"));
        System.out.println("iPodIcon");
    }

    //click on Kaufen btn by xPath: .//*[@id="ac-localnav"]/div/div[2]/div/div[2]/div[2]/a
    private void kaufenBtn() throws InterruptedException {
        clickOnElement(By.xpath(".//*[@id=\"ac-localnav\"]/div/div[2]/div/div[2]/div[2]/a"));
        System.out.println("Kaufen");
        Thread.sleep(3000);
    }

    //click on GoldColor by Xpath: .//*[@ data-autom="dimensionColor-gold"]
    private void color() throws InterruptedException {
        WebElement colorGold = driver.findElement(By.xpath(".//*[@ data-autom=\"dimensionColor-gold\"]"));
        colorGold.isDisplayed();
        System.out.println("color: " + colorGold.isDisplayed());
        colorGold.click();
        Thread.sleep(3000);
    }

    //click on 128GB capacity by xPath: .//*[@data-autom="dimensionCapacity-128gb"] or
    // xpath: .//*[@id="Item2"]/div/div/fieldset/div/div[2]/label[@data-autom="dimensionCapacity-128gb"]
    private void capacity() throws InterruptedException {
        WebElement capacityGB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@data-autom=\"dimensionCapacity-128gb\"]")));
        capacityGB.isDisplayed();
        System.out.println("capacity: " + capacityGB.isDisplayed());
        capacityGB.click();
        Thread.sleep(3000);
    }

    //click on Wahlen btn by xPath: .//button[@data-autom="proceed"]
    private void proceedBtn() {
        WebElement proceedBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@data-autom=\"proceed\"]")));
        proceedBtn.isDisplayed();
        System.out.println("Proceed: " + proceedBtn.isDisplayed());
        proceedBtn.click();
    }

    //click on skip Gravur btn by xPath: .//button[@title="Gravur überspringen"]
    private void skipGravurBtn() {
        WebElement skipGravurBtn = driver.findElement(By.xpath(".//button[@title=\"Gravur überspringen\"]"));
        skipGravurBtn.isDisplayed();
        System.out.println("Skip: " + skipGravurBtn.isDisplayed());
        skipGravurBtn.click();
    }

    //click on add to cart btn by xPath: .//button[@data-autom="add-to-cart"]
    private void addToCartBtn() throws InterruptedException {
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@data-autom=\"add-to-cart\"]")));
        addToCartBtn.isDisplayed();
        System.out.println("Add to cart: " + addToCartBtn.isDisplayed());
        addToCartBtn.click();
        Thread.sleep(3000);
    }

    //cancel order by xPath: .//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]
    private void cancelOrder() {
        WebElement cancelOrderBtn = driver.findElement(By.xpath(".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"));
        cancelOrderBtn.isDisplayed();
        System.out.println("Add to cart: " + cancelOrderBtn.isDisplayed());
        cancelOrderBtn.click();
    }

    public void chooseMusicPage() throws InterruptedException {
        iPodTouchIcon();
        kaufenBtn();
        color();
        capacity();
        proceedBtn();
        skipGravurBtn();
        addToCartBtn();
        cancelOrder();
    }

}