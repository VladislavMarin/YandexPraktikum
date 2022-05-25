package ru.yandex.practicum.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ScooterDataPage {

    // Переменные используемые для ввода данных аренды

    private static By chooseDataButton = byAttribute("placeholder", "* Когда привезти самокат");
    private static By chooseData = byText("15");
    private static By rentalPeriodButton = byText("* Срок аренды");
    private static By rentalPeriod = byText("двое суток");
    private static By colorScooterButton = byClassName("Order_Checkboxes__3lWSI");
    private static By colorScooterBlack = byAttribute("for", "black");
    private static By commentForCourier = byAttribute("placeholder", "Комментарий для курьера");

    //Элемент : Кнопка "Заказать"
    static SelenideElement toOrder = $(byXpath("//button[@class ='Button_Button__ra12g Button_Middle__1CSJM']"));

    // Сеттера для метода "EnterDataRent"
    public static void setChooseDataButton() {
        $(ScooterDataPage.chooseDataButton).click();
        $(ScooterDataPage.chooseData).click();
    }


    public static void setRentalPeriodButton() {
        $(ScooterDataPage.rentalPeriodButton).click();
        $(ScooterDataPage.rentalPeriod).click();
    }

    public static void setColorScooterButton() {
        $(ScooterDataPage.colorScooterButton).click();
        $(ScooterDataPage.colorScooterBlack).click();
    }


    public static void setCommentForCourier(String commentForCourier) {
        $(ScooterDataPage.commentForCourier).setValue(commentForCourier);
    }

    //Метод ввода данных аренды
    public static void enterDataRent(String commentForCourier){
        setChooseDataButton();
        setRentalPeriodButton();
        setColorScooterButton();
        setCommentForCourier(commentForCourier);
    }

    /**
     * Метод клика на кнопку "Заказать"
     */
    public static void clickOrderButton(){
        toOrder.click();
    }

    // Элемент диалога "Хотите оформить заказ"
   public static SelenideElement acceptWindow = $(byClassName("Order_Modal__YZ-d3"));

    /**
     * Метод для оформления заказа (клик на всыплывающее окно)
     */
    public static void checkout(){
        acceptWindow.shouldBe(visible).$(byText("Да")).click();
    }
}
