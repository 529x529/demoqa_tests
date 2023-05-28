package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successTest() {

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Rezchikov");
        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(byText("1997")).click();
        $("#dateOfBirth-wrapper").$(byText("July")).click();
        $("#dateOfBirth-wrapper").$(byText("31")).click();
        $("#subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("file.pdf");
        $("#currentAddress").setValue("Test address");
        $("#stateCity-wrapper").$(byText("Select State")).scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-body").$(byText("Mikhail Rezchikov")).shouldBe(visible);
        $(".modal-body").$(byText("test@test.com")).shouldBe(visible);
        $(".modal-body").$(byText("Male")).shouldBe(visible);
        $(".modal-body").$(byText("0123456789")).shouldBe(visible);
        $(".modal-body").$(byText("31 July,1997")).shouldBe(visible);
        $(".modal-body").$(byText("Maths")).shouldBe(visible);
        $(".modal-body").$(byText("Sports")).shouldBe(visible);
        $(".modal-body").$(byText("file.pdf")).shouldBe(visible);
        $(".modal-body").$(byText("Test address")).shouldBe(visible);
        $(".modal-body").$(byText("NCR Delhi")).shouldBe(visible);
        $("#closeLargeModal").click();
    }
}
