package ru.yandex.practicum.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.pageObject.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class TestFaqInternalTextCheck {

    @Before

    public void checkCookie(){
        Configuration.browserSize = "1366x768";
        open("https://qa-scooter.praktikum-services.ru/");
        MainPage.cookieClick();

    }

    @Test
    public void checkTextFaqCorrespondsOne(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(0,0,0);
    }

    @Test
    public void checkTextFaqCorrespondsTwo(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(1,1,1);
    }
    @Test
    public void checkTextFaqCorrespondsThree(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(2,2,2);
    }
    @Test
    public void checkTextFaqCorrespondsFour(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(3,3,3);
    }
    @Test
    public void checkTextFaqCorrespondsFive(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(4,4,4);
    }
    @Test
    public void checkTextFaqCorrespondsSix(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(5,5,5);
    }
    @Test
    public void checkTextFaqCorrespondsSeven(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(6,6,6);
    }
    @Test
    public void checkTextFaqCorrespondsEight(){
        MainPage objMainPage = new MainPage();
        objMainPage.questionsAboutImportantComparingTextToExpected(7,7,7);
    }
}
