package saucedemo.screenplay.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CheckOut {

    public static Performable doCheckOut() {
        return Task.where(actor -> actor.asksFor(getCheckOutButton()).click());
    }

    private static Question<WebElementFacade> getCheckOutButton() {
        return actor -> BrowseTheWeb.as(actor).findAll("//button[text()='Checkout']")
                .stream()
                .limit(1)
                .findAny()
                .orElseThrow(() -> new RuntimeException("no checkout button found"));
    }
}
