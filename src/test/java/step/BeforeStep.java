package step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Opening the site {string}")
    public void openingTheSite(String arg0) {
        Selenide.open(arg0);
    }

}
