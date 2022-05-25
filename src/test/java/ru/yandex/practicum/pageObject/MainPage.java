package ru.yandex.practicum.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

                        // Элементы в шапке страницы
    // кнопка "Заказать"
    public static SelenideElement orderButtonHeader = $(".Button_Button__ra12g");

    // "Статус заказа"
    public static SelenideElement orderStatus = $(".Header_Link__1TAG7");

    // Кнопка "Яндекс"
    public static SelenideElement yandexButton = $(byAttribute("alt", "Yandex"));

    // "Самокат"
    public static SelenideElement scooterButtonHeader = $(byAttribute("alt", "Scooter"));

    // "Учебный тренажёр"
    public static SelenideElement simulatorTrainingButton = $(".Header_Disclaimer__3VEni");

    // "Самокат на пару дней"
    public static SelenideElement scooterFewDays = $(".Home_Header__iJKdX");

    // Описание доставки самоката "Привезём его прямо к вашей двери, а когда накатаетесь — заберём"
    public static SelenideElement descriptionScooterFewDays = $(".Home_SubHeader__zwi_E");

    // Картинка самоката
    public static SelenideElement imgScooter = $(byAttribute("alt", "Scooter blueprint"));

    //Коллекция элементов таблицы Модели Toxic PRO
    public static ElementsCollection tableToxicPro = $$(byXpath("//div[@class='Home_Column__xlKDK']"));


                        // Элементы в середине страницы

    // Кнопка "Заказать"
    public static SelenideElement orderButtonMain = $(".Home_FinishButton__1_cWm");

    // "Как это работает"
    public static SelenideElement howThisWork = $(byXpath("//div[@class='Home_SubHeader__zwi_E'][text()='Как это работает']"));

    //Колекция элементов пунктов (1,2,3,4) блока "Как это работает"
    private static ElementsCollection pointHowThisWork = $$(byXpath("//div[contains(@class, 'Home_StatusCircle__3_aTp')]"));

    //Коллекция элементов названий пунктов элементов блока "Как это работает"
    private static ElementsCollection namePoint = $$(byXpath("//div[@class='Home_Status__YkfmH']"));

    //Коллекция краткого описания пунктов блока "Как это работает"
    private static ElementsCollection descriptionPoint = $$(byXpath("//div[@class='Home_StatusDescription__3WGl5']"));



                        // Элементы в подвале страницы

    // Коллекция элементов "Вопросы о важном"
    static ElementsCollection  questionsAboutImportant = $$(".accordion__button"); // Коллекция элементов "Вопросы о важном"
    static ElementsCollection questionsAboutImportantInternalText = $$(".accordion__panel"); // Коллецкия внутреннего текста элементов коллекции "questionsAboutImportant"

    // Массив с значением текста с которым необходимо сравнивать текст в выпадайке
    public static String[] checkedText = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."

    };

                        // Cookie элементы

    // Область уведомления в футере об использовании cookie
    public static String footerCookie = "App_CookieConsent__1yUIN";

    // Кнопка "Да все привыкли" в области уведомления о cookie
    public static String clickButtonCookie = "rcc-confirm-button";

                        // Методы взаимодествия с элементами главной страницы

    /**
     * Метод получения элемента из коллецкии questionsAboutImportant
     * @param numberElement - номер элемента
     * @return - возвращает элемент из коллекции "questionsAboutImportant" с указаным номером
     */
    public static SelenideElement getQuestionAboutImportant(int numberElement) {
        return questionsAboutImportant.get(numberElement);
    }

    /**
     * Метод получения внутреннего текста каждого элемента коллекции "questionsAboutImportant"
     * @param numberElementText - номер элемента внутреннего текста clickButtonCookie
     * @return - возвращает внутренный текст элемента из коллекции "questionsAboutImportantInternalText" с указанным номером
     */
    public static String getQuestionAboutImportantInternalText(int numberElementText){
        SelenideElement internalText = questionsAboutImportantInternalText.get(numberElementText);
        return internalText.getText();
    }

    /**
     * Метод клика на кнопку "Да все привыкли" в области уведомления о cookie
     */
    public static void cookieClick() {

        if ($(byClassName(footerCookie)).isDisplayed()) {
            $(byId(clickButtonCookie)).click();
        }
    }

    /**
     * Метод сравниваемого текста в "Вопросы о важном" с ожидаемым (в массиве checkedText)
     * @param numberElement - номер элемента из коллекции questionsAboutImportant
     * @param numberElementText - номер элемента внутреннего текста из колекции clickButtonCookie
     * @param numberCheckedText - номер элемента из массива checkedText
     */
    public void questionsAboutImportantComparingTextToExpected(int numberElement, int numberElementText, int numberCheckedText) {
        MainPage.getQuestionAboutImportant(numberElement).click();
        sleep(100); // необходим тк тест не всегда выполняется, страница не прогружается
        Assert.assertEquals(MainPage.getQuestionAboutImportantInternalText(numberElementText), MainPage.checkedText[numberCheckedText]);
    }

    /**
     * Поиск элемента по номеру пункта блока "Как это работает"
     * @param numberPoint номер пункта элемента (нумерация пунктов начинается с "0")
     * @return возвращает элемент пункта
     */
    public static SelenideElement getPointHowThisWork(int numberPoint) {
        return pointHowThisWork.get(numberPoint);
    }

    /**
     * Поиск элемента по названию пункта "Как это работает"
     * @param namePointHeader наименование пункта (например "Заказываете самокат")
     * @return возвращает элемент
     */
    public static SelenideElement getNamePoint(String namePointHeader) {
        return namePoint.findBy(new Text(namePointHeader));
    }

    /**
     * Поиск элемента по описанию пункта "Как это работает"
     * @param descriptionPointName наименования описания пункта (например "Выбираете, когда и куда привезти")
     * @return возвращает элемент
     */
    public static SelenideElement getDescriptionPoint(String descriptionPointName) {
        return descriptionPoint.findBy(new Text(descriptionPointName));
    }
    /**
     * Поиск элемента по наименованию в таблице Toxic PRO.
     * @param nameElement - наименование элемента, который нужно вернуть (например "Максимальная скорость")
     * @return Возвращает элемент страницы
     */

    public static SelenideElement getTableToxicPro(String nameElement){
        SelenideElement element = $(byXpath("//div[@class='Home_Column__xlKDK']"));
        element.scrollTo();
        return tableToxicPro.find(new Text(nameElement));
    }
}