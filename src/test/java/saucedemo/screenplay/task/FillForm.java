package saucedemo.screenplay.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.InputField;

public class FillForm {
    public static Performable doCheckOut() {
        return Task.where(
                Enter.theValue("lea").into("#first-name"),
                Enter.theValue("rolfes").into("#last-name"),
                Enter.theValue("123").into("#postal-code"),
                Click.on(InputField.withNameOrId("continue")),
                Click.on("#finish"));
    }
}
