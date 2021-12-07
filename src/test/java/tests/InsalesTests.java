package tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class InsalesTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        step("Open website", () -> {
            open("https://www.insales.ru/");
        });

        step("Check Web store", () -> {
            $(".first-level:nth-child(1) > .hover-opacity").shouldBe(visible).click();
            $(byLinkText("Сайт интернет-магазина")).click();
            $(".fw-500").click();
            $(".fw-700").shouldHave(text("онструктор интернет-магазина\n" +
                    "и профессиональная платформа\n" +
                    "для сайта интернет-магазина"));
        });

        step("Check Templates", () -> {
            $(".first-level:nth-child(2) > .hover-opacity").click();
            $(byLinkText("Шаблоны и дизайн")).click();
        });

        step("Check search", () -> {

            $(byName("q")).click();
            $(byName("q")).val("Fine").pressEnter();
            $(byLinkText("Fine | Бесплатно")).shouldBe(visible).shouldHave(text("Fine | Бесплатно"));
            $(".filter-point:nth-child(1) .cell-10 span").click();
            $(byLinkText("Markom | Бесплатно")).shouldHave(text("Markom | Бесплатно"));
        });

        step("Check rates", () -> {
            $(byLinkText("Тарифы")).click();
            $(byLinkText("Создать")).click();
            $(".h1-like").shouldHave(text("Регистрация"));
        });

            step("Check transfer", () -> {
                $(byLinkText("Переезд на InSales")).click();
                $(".m-b-50").shouldHave(text("Перенесем сайт вашего магазина на InSales бесплатно"));



        });
    }
}