package framework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.Configuration.chromeDriverPath;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;


public abstract class AbstractPage {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            //DesiredCapabilities dcap = new DesiredCapabilities();
            //dcap.setCapability("PageLoadStrategy", "EAGER");
            //ChromeOptions opt = new ChromeOptions();
            //opt.merge(dcap);
            driver = new ChromeDriver();

            //driver.manage().window().maximize();
            driver.manage().window().setSize(new Dimension(1440, 900)); //iphone 6 resolution
            return driver;
        }

        return driver;
    }

    protected WebDriverWait getWait(WebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), 5000000);
        }
        return wait;
    }

    public void quitDriver() {
        getDriver().quit();
    }

}
