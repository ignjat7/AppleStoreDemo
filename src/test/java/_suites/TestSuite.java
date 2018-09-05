package _suites;

import appleTVPage.TestAppleTVPage;
import macPage.TestMacPage;
import ipadPage.TestIpadPage;
import iPhonePage.TestIphonePage;
import watchPage.TestWatchPage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestMacPage.class,
        TestIpadPage.class,
        TestIphonePage.class,
        TestWatchPage.class,
        TestAppleTVPage.class
})

public class TestSuite {

    public TestSuite() {
    }
}


