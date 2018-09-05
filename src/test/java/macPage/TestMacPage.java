package macPage;

import Pages.MacPage;
import Pages.MainPage;
import framework.Configuration;
import framework.Page;
import org.junit.*;

import java.io.IOException;

public class TestMacPage extends Page {


    private static MainPage mainPage;
    private static MacPage macPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        mainPage = new MainPage();
        macPage = mainPage.goToMacUrl();
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
    public void chooseMacProduct() throws InterruptedException {
        System.out.println("\u001B[32m" + "***** Mac Test Started *****" + "\u001B[0m");
        System.out.println();
        macPage.chooseMacProduct();
        System.out.println("\u001B[32m" + "***** Mac Test Ended *****" + "\u001B[0m");
        //System.exit(1);
    }
}
