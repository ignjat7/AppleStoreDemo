package ipadPage;

import Pages.IpadPage;
import Pages.MainPage;
import framework.Configuration;
import framework.Page;
import org.junit.*;

import java.io.IOException;

public class TestIpadPage extends Page {


    private static MainPage mainPage;
    private static IpadPage ipadPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        mainPage = new MainPage();
        ipadPage = mainPage.goToIpadUrl();
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
    public void chooseIpad() throws InterruptedException {
        System.out.println("\u001B[32m" + "***** Ipad Test Started *****" + "\u001B[0m");
        System.out.println();
        ipadPage.chooseIpad();
        System.out.println("\u001B[32m" + "***** Ipad Test Ended *****" + "\u001B[0m");
        //System.exit(1);

    }
}
