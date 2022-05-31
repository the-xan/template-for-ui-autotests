package kz.sber.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;


@ExtendWith(TextReportExtension.class)
@ExtendWith(FinishTestResult.class)
public class TestBase {

    public final static String
            RUN_START = System.getProperty("RunStart", "selenide"), // selenide | selenoid
            BROWSER_NAME = System.getProperty("BName", "chrome"), // chrome
            BROWSER_VERSION = System.getProperty("BVersion", "50.0"), // 50.0 | 87.0
            BROWSER_SIZE = System.getProperty("BSize", "375x812"), // 1366x768 | 1600x900 | 1920x1080 | 375x812
            SITE_STAND = System.getProperty("SiteStand", "site-test"); // site-dev | site-test

    public final static String
            TEST_NAME = "TestTemplate",
            REMOTE_URL = "http://172.16.177.203";


    @BeforeAll
    public static void setupBrowser() {

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true).
                        savePageSource(true));

        String testName = "TestTemplate";
        System.out.println("\nAutotest will run in \"" + RUN_START + "\"\n");
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "none";

        if (RUN_START.equals("selenide")) {
            System.setProperty("webdriver.chrome.driver", "webDriver/chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver" + BROWSER_VERSION + ".exe");
            Configuration.browserSize = BROWSER_SIZE;
        }

        if (RUN_START.equals("selenoid")) {
            Configuration.remote = REMOTE_URL + ":4444/wd/hub";
            Configuration.browserSize = BROWSER_SIZE;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(BROWSER_NAME);
            capabilities.setVersion(BROWSER_VERSION);
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("videoName", TEST_NAME + ".mp4");
            //capabilities.setCapability("enableLog", true);
            //capabilities.setCapability("logName", testName + ".log");
            capabilities.setCapability("name", testName);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @AfterEach
    public void pageSourceAndScreenshot() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            AllureAttachments.addScreenshot();
            AllureAttachments.addPageSource();
            AllureAttachments.addBrowserConsoleLogs();
        }
        AllureAttachments.addFailVideo();
    }

    // Delete all cookies & close WebDriver
    @AfterAll
    public static void quitWebDriver() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }
}
