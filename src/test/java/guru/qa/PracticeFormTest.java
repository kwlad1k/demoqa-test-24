package guru.qa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void successfulRegistration() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Billy");
        $("#lastName").setValue("Milligan");
        $("#userEmail").setValue("billymilly@gogle.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Com").sendKeys(Keys.ENTER);
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("kek.png");
        $("#currentAddress").setValue("55 W Gore St Orlando 32806");
        $("#react-select-3-input").setValue("Haryana").sendKeys(Keys.ENTER);
        $("#react-select-4-input").setValue("Panipat").sendKeys(Keys.ENTER);
        $("#submit").click();
        $(".modal-dialog ").shouldBe(visible);
        $(".modal-body").shouldHave(text("Billy Milligan"));
        $(".modal-body").shouldHave(text("billymilly@gogle.com"));
        $(".modal-body").shouldHave(text("Other"));
        $(".modal-body").shouldHave(text("9999999999"));
        $(".modal-body").shouldHave(text("15 July,1993"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("kek.png"));
        $(".modal-body").shouldHave(text("55 W Gore St Orlando 32806"));
        $(".modal-body").shouldHave(text("Haryana Panipat"));
    }
}
