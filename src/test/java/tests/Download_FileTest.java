package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class Download_FileTest extends TestBase {


    @Test
    void selenideDownloadReadmeTest() throws IOException {

        Configuration.downloadsFolder = "./downloads";


        step("Open website", () -> {
            open("https://www.insales.ru/page/partnership_faq");
        });

        step(" Check Download", () -> {

            File pdf = $(".c-inherit").download();

            PDF parsedPdf = new PDF(pdf);
            Assertions.assertEquals(14, parsedPdf.numberOfPages);

        });

    }
}
