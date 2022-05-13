package kz.sber.logic;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PageObjectsPath {
    //region Логирование
    //Инпут логина
    static final String loginInput = "//input[@id='wtUserNameInput']";
    //Инпут пароля
    static final String passInput = "//input[@id='wtPasswordInput']";
    //Кнопка входа
    static final String loginBtn = "//span[@class='Login_Button']";
    //endregion


    //region Сброс пароля
    // Старый пароль
    static final String oldPass = "//label[contains(text(),'Старый пароль')]/../input[1]";
    // Новый пароль
    static final String newPass = "//label[contains(text(),'Новый пароль')]/../input[1]";
    // Подтверждение нового пароля
    static final String confirmNewPass = "//label[contains(text(),'Подтверждение нового пароля')]/../input[1]";
    // Поменять пароль
    static final String btnChangePass = "//label[contains(text(),'Подтверждение нового пароля')]/../..//input[@value='Поменять пароль']";
    //endregion

}
