package step;

import Configs.ConfigLoader;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InputData {
    private static final ConfigLoader configLoader = new ConfigLoader();
    private final SelenideElement loginSU = $("#user-name");
    private final SelenideElement passwordSU = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement  cartLink =  $(".shopping_cart_link");
    private final SelenideElement  errorLoginMsg =  $x("//h3");


    @When("I enter the login from standard_user")
    public void iEnterTheLoginFromStandard_user() {
        loginSU.sendKeys(configLoader.getStandardUserLogin());
    }

    @And("I enter the password for standard_user")
    public void iEnterThePasswordForStandard_user() {
        passwordSU.sendKeys(configLoader.getPassword());
    }

    @And("I press the login button")
    public void iPressTheLoginButton() {
        loginButton.click();
    }

    @Then("I get to the product page where the shopping cart is displayed")
    public void iGetToTheProductPageWhereTheShoppingCartIsDisplayed() {
        cartLink.shouldHave(Condition.visible);
    }

    @When("I enter the login from locked_out_user")
    public void iEnterTheLoginFromLocked_out_user() {
        loginSU.sendKeys(configLoader.getLockedOutUserLogin());
    }

    @And("I enter the password for locked_out_user")
    public void iEnterThePasswordForLocked_out_user() {
        passwordSU.sendKeys(configLoader.getPassword());

    }

    @Then("I get a warning - login error because the user is blocked")
    public void iGetAWarningLoginErrorBecauseTheUserIsBlocked() {
        errorLoginMsg.shouldHave(Condition.visible);
    }
}
