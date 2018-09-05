package watchPage;

import Pages.MainPage;
import Pages.WatchPage;
import framework.Configuration;
import framework.Page;
import org.junit.*;

import java.io.IOException;

public class TestWatchPage extends Page {
    private static MainPage mainPage;
    private static WatchPage watchPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        mainPage = new MainPage();
        watchPage = mainPage.goToWatchUrl();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        //quitDriver();
    }

    @Test
    public void chooseAppleWatch() throws InterruptedException {
        System.out.println("\u001B[32m" + "***** Mac Test Started *****" + "\u001B[0m");
        System.out.println();
        watchPage.chooseAppleWatch();
        System.out.println("\u001B[32m" + "***** Mac Test Ended *****" + "\u001B[0m");
    }
}
