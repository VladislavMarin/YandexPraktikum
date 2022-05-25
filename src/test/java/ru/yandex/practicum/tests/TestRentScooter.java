package ru.yandex.practicum.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.pageObject.HumanDataPage;
import ru.yandex.practicum.pageObject.MainPage;
import ru.yandex.practicum.pageObject.ScooterDataPage;


import static com.codeborne.selenide.Selenide.*;
import static ru.yandex.practicum.pageObject.MainPage.*;

public class TestRentScooter {

    @Before
    public void checkCookie(){
        Configuration.browserSize = "1366x768";
        open("https://qa-scooter.praktikum-services.ru/");
        cookieClick();
    }

    @Test
    public void testOrderScooterViaHeaderButton(){
       testOrderScooter(MainPage.orderButtonHeader.scrollTo());
    }

    @Test
    public void testOrderScooterViaMainButton(){
        testOrderScooter(MainPage.orderButtonMain.scrollTo());
    }

    private void testOrderScooter(SelenideElement orderButton){
        orderButton.click();
        HumanDataPage.enterData(
                "Владислав",
                "Марьин",
                "Улица Бассейная",
                "+79851534574"
        );
        HumanDataPage.clickNextButton();
        ScooterDataPage.enterDataRent(
                "Комментарий для курьера");
        ScooterDataPage.clickOrderButton();
        ScooterDataPage.checkout();
    }
}

