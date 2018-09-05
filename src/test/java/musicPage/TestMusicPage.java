package musicPage;


import Pages.MainPage;
import Pages.MusicPage;
import framework.Configuration;
import org.junit.*;

import java.io.IOException;

public class TestMusicPage {
    private static MainPage mainPage;
    private static MusicPage musicPage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        mainPage = new MainPage();
        musicPage = mainPage.goToMusicUrl();
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
    public void chooseMusic() throws InterruptedException {
        System.out.println("\u001B[32m" + "***** Music Test Started *****" + "\u001B[0m");
        System.out.println();
        musicPage.chooseMusicPage();
        System.out.println("\u001B[32m" + "***** Music Test Ended *****" + "\u001B[0m");
    }
}
