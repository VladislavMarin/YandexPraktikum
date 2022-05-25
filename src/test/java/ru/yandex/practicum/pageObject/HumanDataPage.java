package ru.yandex.practicum.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HumanDataPage {

                             // Локаторы полей ввода данных
    private static By name = byAttribute("placeholder", "* Имя"); // Локатор поля "Имя"
    private static By firstName = byAttribute("placeholder", "* Фамилия"); // Локатор поля "Фамилия"
    private static By address = byAttribute("placeholder", "* Адрес: куда привезти заказ"); // Локатор поля "Адрес"
    private static By telephone = byAttribute("placeholder", "* Телефон: на него позвонит курьер"); // Локатор поля "Телефон"
    private static By metro = byAttribute("placeholder", "* Станция метро"); // Локатор поля "Станция метро"
    private static By metroBdd = byAttribute("value", "176"); // Локатор определенного метро, используется для выбора метро "Бульвар Дмитрия Донского"
    private static SelenideElement next = $(byText("Далее"));// Элемент: кнопка "Далее"

    /**
     * Сеттеры для метода "enterData"
     */
    public static void setName(String name) {
        $(HumanDataPage.name).setValue(name);
    }

    public static void setFirstName(String firstName) {
        $(HumanDataPage.firstName).setValue(firstName);
    }

    public static void setAddress(String address) {
        $(HumanDataPage.address).setValue(address);
    }

    public static void setTelephone(String telephone) {
        $(HumanDataPage.telephone).setValue(telephone);
    }

    public static void setMetro() {
        $(metro).setValue("Бульвар Дмитрия Донского");
        $(metroBdd).click();
    }

    /**
     * Метод, вводит личные данные, метро кликает "Далее"
     *
     * @param name      - Имя
     * @param firstName - Фамилия
     * @param address   - Адрес доставки
     * @param telephone - номер телефона
     */
    public static void enterData(String name, String firstName, String address, String telephone) {
        setName(name);
        setFirstName(firstName);
        setAddress(address);
        setMetro();
        setTelephone(telephone);
    }

    /**
     * Метод клика на кнопку "Далее"
     */
    public static void clickNextButton() {
        next.click();
        new HumanDataPage();
    }

}
