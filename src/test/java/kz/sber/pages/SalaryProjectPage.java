package kz.sber.pages;

import io.qameta.allure.Step;
import kz.sber.model.PageObjectsActions;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static kz.sber.config.TestBase.SITE_STAND;
import static kz.sber.model.PageObjectsValues.*;

public class SalaryProjectPage extends PageObjectsActions {
    @Step("Страница Зарплатного проекта - Создание заявки")
    public static void CreateRequestForSalaryProjectPage() {
        step("Открытие страницы \"Зарплатного проекта\" ", () -> {
            if (SITE_STAND.equals("site-test")) {
            open(SITE_TEST);
            } else {
            open(SITE_DEV);
            }
        });

        step("Нажать на кнопку \"Принимаю\" (Акцепт куки)", () -> {
            ClickButton("Принимаю");
        });
    }
}

