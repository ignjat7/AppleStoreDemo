package iPhonePage;

import Pages.IphonePage;
import Pages.MainPage;
import framework.Configuration;
import framework.Page;
import org.junit.*;

import java.io.IOException;

public class TestIphonePage extends Page {
    private static MainPage mainPage;
    private static IphonePage iphonePage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        mainPage = new MainPage();
        iphonePage = mainPage.goToIphoneUrl();
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
    public void chooseIphone() throws InterruptedException {
        System.out.println("\u001B[32m" + "***** Mac Test Started *****" + "\u001B[0m");
        System.out.println();
        iphonePage.chooseIphone();
        System.out.println("\u001B[32m" + "***** Mac Test Ended *****" + "\u001B[0m");
        //System.exit(1);
    }
}