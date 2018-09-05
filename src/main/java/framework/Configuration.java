package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Configuration {

    public static String chromeDriverPath;

    public static String mainSiteUrl;
    public static String adminPanelLogin;
    public static String adminUsername;
    public static String adminPassword;
    public static String macUrl;
    public static String iPadUrl;
    public static String macProUrl;
    public static String iPhoneUrl;
    public static String watchUrl;
    public static String appleTVUrl;
    public static String musicUrl;

    //public static String dbUrl;
    //public static String dbUrlDriver;
    //public static String dbHost;
    //public static String dbPort;
    //public static String dbUsername;
    //public static String dbPassword;

    public static void init() throws FileNotFoundException, IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("configuration.properties");
        properties.load(fis);

        mainSiteUrl = properties.getProperty("mainSiteUrl");
        adminPanelLogin = properties.getProperty("adminPanelLogin");
        adminUsername = properties.getProperty("adminUsername");
        adminPassword = properties.getProperty("adminPassword");
        adminPanelLogin = properties.getProperty("adminPanelLogin");
        chromeDriverPath = properties.getProperty("chromeDriverPath");
        macUrl = properties.getProperty("macUrl");
        iPadUrl = properties.getProperty("iPadUrl");
        macProUrl = properties.getProperty("macProUrl");
        iPhoneUrl = properties.getProperty("iPhoneUrl");
        watchUrl = properties.getProperty("watchUrl");
        appleTVUrl = properties.getProperty("appleTVUrl");
        musicUrl = properties.getProperty("musicUrl");


        //dbUrl = properties.getProperty("dbUrl");
        //dbUrlDriver = properties.getProperty("dbUrlDriver");
        //dbHost = properties.getProperty("dbHost");
        //dbPort = properties.getProperty("dbPort");
        //dbUsername = properties.getProperty("dbUsername");
        //dbPassword = properties.getProperty("dbPassword");
    }
}