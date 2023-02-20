import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    void positiveTest() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='city']").setValue("Омск");
        $x("//input[@placeholder='Дата встречи']").setValue("25.02.2023");
        $("[data-test-id='name']").setValue("Маруся Кошкина");
        $("[data-test-id='phone']").setValue("+79991112233");
        $x("//label").click();
        $x("//span[text()='Забронировать']").click();
        $x("//*[@class='notification__title']").shouldHave(Condition.text("Успешно!"));


    }
}
