package kz.sber.logic;

import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class PageObjectsActions {

    static void CompleteField(String FieldName, String value) {
        String locator = String.format("//*[normalize-space()='%s']/following-sibling::input", FieldName);
        $(byXpath(locator)).shouldBe(visible, Duration.ofSeconds(3)).click();
        $(byXpath(locator)).setValue(value);
    }

    static void ClickButton(String ButtonName) {
        String locator = String.format("//button[normalize-space()='%s']", ButtonName);
        $(byXpath(locator)).shouldBe(visible, Duration.ofSeconds(3)).click();
    }

    static void DropDownList(String CityName) {
        String locator = String.format("//li[normalize-space()='%s' and contains(@class, 'vs__dropdown-option')]", CityName);
        $(byXpath("//div[@class='vs__actions']")).shouldBe(visible, Duration.ofSeconds(3)).click();
        $(byXpath(locator)).click();
    }
}

