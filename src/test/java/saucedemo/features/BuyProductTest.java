package saucedemo.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import saucedemo.screenplay.task.AddItemCart;
import saucedemo.screenplay.task.CheckOut;
import saucedemo.screenplay.task.FillForm;
import saucedemo.screenplay.task.Login;
import saucedemo.screenplay.task.ViewCart;

@ExtendWith(SerenityJUnit5Extension.class)
class BuyProductTest {
    @CastMember(name = "lea")
    Actor lea;

    @Test
    @DisplayName("Buy some products")
    void buySomeProducts() {
        lea.attemptsTo(Login.asStandarUser("standard_user", "secret_sauce"),
                AddItemCart.addItemToCart(2),
                ViewCart.viewCart(),
                CheckOut.doCheckOut(),
                FillForm.doCheckOut());

        String confirmationMessage = lea.asksFor(Text.of(".complete-header"));
        Assertions.assertThat(confirmationMessage).contains("Thank you for your order!");
    }
}
