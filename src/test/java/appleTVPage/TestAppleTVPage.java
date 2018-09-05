package appleTVPage;

import Pages.AppleTVPage;
import Pages.MainPage;
import framework.Configuration;
import framework.Page;
import org.junit.*;

import java.io.IOException;

public class TestAppleTVPage extends Page {
    private static MainPage mainPage;
    private static AppleTVPage appleTVPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        mainPage = new MainPage();
        appleTVPage = mainPage.goToAppleTVUrl();
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
    public void chooseAppleTv() throws InterruptedException {
        System.out.println("\u001B[32m" + "***** AppleTv Test Started *****" + "\u001B[0m");
        System.out.println();
        appleTVPage.chooseAppleTv();
        System.out.println("\u001B[32m" + "***** AppleTv Test Ended *****" + "\u001B[0m");
        //System.exit(1);
    }
}
