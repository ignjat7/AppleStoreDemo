package Pages;

import framework.Page;
import org.openqa.selenium.support.PageFactory;

import static framework.Configuration.*;


public class MainPage extends Page {

    public MacPage goToMacUrl() {
        getDriver().get(macUrl);
        return PageFactory.initElements(getDriver(), MacPage.class);
    }

    public IpadPage goToIpadUrl() {
        getDriver().get(iPadUrl);
        return PageFactory.initElements(getDriver(), IpadPage.class);
    }

    public IphonePage goToIphoneUrl() {
        getDriver().get(iPhoneUrl);
        return PageFactory.initElements(getDriver(), IphonePage.class);
    }

    public WatchPage goToWatchUrl() {
        getDriver().get(watchUrl);
        return PageFactory.initElements(getDriver(), WatchPage.class);
    }

    public AppleTVPage goToAppleTVUrl() {
        getDriver().get(appleTVUrl);
        return PageFactory.initElements(getDriver(), AppleTVPage.class);
    }

    public MusicPage goToMusicUrl() {
        getDriver().get(musicUrl);
        return PageFactory.initElements(getDriver(), MusicPage.class);
    }

}