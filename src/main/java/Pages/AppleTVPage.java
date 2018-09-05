package Pages;

import framework.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AppleTVPage extends Page {

    //click on AppleTV Icon by xpath:.//*[@id="chapternav"]/div/ul/li[2]/a/figure
    private void appleTvIcon() {
        clickOnElement(By.xpath(".//*[@id=\"chapternav\"]/div/ul/li[2]/a/figure"));
        System.out.println("AppleTv");
    }

    //click on proceed btn, check if element is displayed, by xpath:.//*[@data-part-number="MR912FD/A"]//div/span/button[@data-autom="add-to-cart"]
    private void proceed() {
        WebElement proceedBtn = driver.findElement(By.xpath(".//*[@data-part-number=\"MR912FD/A\"]//div/span/button[@data-autom=\"add-to-cart\"]"));
        proceedBtn.isDisplayed();
        System.out.println("is displayed: " + proceedBtn.isDisplayed());
        if (proceedBtn.isDisplayed()) {
            proceedBtn.click();
            System.out.println("proceed btn clicked");
        }else {
            Actions actions = new Actions(driver);
            actions.moveToElement(proceedBtn).click().perform();
            System.out.println("The proceed btn is chosen now");
        }
    }

    //click on bezahlen btn by xpath:.//*[@id="summaryheader-form"]/div/span/button
    private void bezahlen() {
        WebElement bezahlenBtn = waitForElementVisibility(By.xpath(".//*[@id=\"summaryheader-form\"]/div/span/button"));
        bezahlenBtn.click();
        System.out.println("bezahlen");
    }

    //cancel order by xpath:..//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]
    private void cancelOrder() {
        WebElement cancelOrder = waitForElementVisibility(By.xpath(".//button[starts-with(@data-autom, 'bagitemremovebutton-cart-items-item-')]"));
        cancelOrder.click();
        System.out.println("cancel order");
    }

    public void chooseAppleTv() {
        appleTvIcon();
        proceed();
        bezahlen();
        cancelOrder();
    }

}