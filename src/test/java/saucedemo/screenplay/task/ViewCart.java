package saucedemo.screenplay.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ViewCart {
    
    public static Performable viewCart(){
        return Task.where(actor -> actor.asksFor(getCartButton()).click());
    }
    private static Question<WebElementFacade> getCartButton(){
        return actor -> BrowseTheWeb.as(actor).findAll("//a[contains(@class, 'shopping_cart_link')]")
                .stream()
                .limit(1)
                .findAny()
                .orElseThrow(() -> new RuntimeException("cart button not found"));
    }
}
