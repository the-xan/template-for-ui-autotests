package kz.sber.config;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static kz.sber.config.TestBase.TEST_NAME;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class AllureAttachments {

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html", fileExtension = "html")
    public static byte[] addPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addFailVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + "http://172.16.177.203:8080/video/" + TEST_NAME + ".mp4"
                + "' type='video/mp4'></video></body></html>";
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static void addBrowserConsoleLogs() {
        attachAsText("Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }
}
