import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import config.TestConfig;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class BPTests {
    SelenideElement firstCard = $x("//*[@id='card-1']");
    SelenideElement cardButton = $x("//*[@id='open-cart-btn']");

    @BeforeEach
    void setup(){
        TestConfig.printConfig();              // ← вывод конфигов в консоль
        open(TestConfig.getUrl());             // ← URL берём из конфиг
    }

    @Test
    void simpleDND() {
        sleep(1000);
        firstCard.dragAndDrop(DragAndDropOptions.to(cardButton));
        sleep(2000);
    }

    @Test
    void hiddenTest(){
        SelenideElement addToCartButton = $x("//*[@data-action='add-to-cart']");
        addToCartButton.click();
        addToCartButton.click();
        addToCartButton.click();
        SelenideElement notificationContainer = $$x("//*[@datatest='notification-container']").get(0);
        notificationContainer.shouldNot(visible);
        notificationContainer.should(exist);
        notificationContainer.$x("./..").should(visible);
    }

    @Test
    void removeItemFromCart() {
        // Добавляем товар в корзину (через кнопку "В корзину" в карточке)
        SelenideElement addButton = $x("//*[@id='card-1']/button");
        addButton.click();

        // Открываем корзину
        $x("//*[@id='open-cart-btn']").click();

        // Проверяем, что товар появился (например, "Помидорка")
        SelenideElement cartItem = $x("//*[@id='container']//*[contains(text(),'Помидорка')]");
        cartItem.shouldBe(visible);

        // Нажимаем кнопку удаления
        $x("//*[@id='cart-item-2']/button").click();

        // Проверяем, что товар исчез из корзины
        cartItem.shouldBe(disappear);
    }
}
