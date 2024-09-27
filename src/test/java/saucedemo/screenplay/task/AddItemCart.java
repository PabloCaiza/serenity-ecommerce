package saucedemo.screenplay.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;

public class AddItemCart {
    
    public static Performable addItemToCart(Integer items){
        return Task.where("{0} want to add %d products to cart".formatted(items),actor -> {
                actor.asksFor(getProducts(items))
                        .forEach(WebElementFacade::click);
        });
        
    }
    private static Question<List<WebElementFacade>> getProducts(Integer numberOfProducts){
        return actor -> BrowseTheWeb.as(actor).findAll("//button[text()=\"Add to cart\"]")
                .stream()
                .limit(numberOfProducts)
                .toList();
    }
    
}
