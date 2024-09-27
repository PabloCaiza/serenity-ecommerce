package saucedemo.screenplay.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class Login {
    public static Task asStandarUser(String username,String password){
        return Task.where(
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue(username).into("#user-name"),
                Enter.theValue(password).into("#password"),
                Click.on("#login-button")
        );
    }
}
