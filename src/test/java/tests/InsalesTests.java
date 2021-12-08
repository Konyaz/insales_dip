package tests;


import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;


public class InsalesTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        step("Open website", () -> {
            open("https://www.insales.ru/");
        });

        step("Check Web store", () -> {
            $(byXpath("//span[contains(.,'Каналы продаж')]")).click();
            $(byLinkText("Сайт интернет-магазина")).shouldBe(visible).click();
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

            $(byName("q")).shouldBe(visible).click();
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
            $(byXpath("//a[contains(text(),'Переезд на InSales')]")).shouldBe(visible).click();
            $(".row > .m-b-50").shouldHave(text("Перенесем сайт вашего магазина на InSales бесплатно"));
        });

        step("Check support", () -> {
            $(".first-level:nth-child(6) > .hover-opacity").shouldBe(visible).click();
            $(byLinkText("Наши контакты")).click();
            $(byLinkText("+7 495 649 83 14")).shouldHave(text("+7 495 649 83 14"));
        });

        }

    }
