package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.PanelPrincipalPage;

import java.awt.*;
import java.security.Principal;

public class PanelPrincipalSteps{

    PanelPrincipalPage panelPrincipalPage = new PanelPrincipalPage(Hooks.driver);
    LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("^El usuario ha iniciado sesión en su cuenta bancaria satisfactoriamente$")
    public void loginSuccess(){
        loginPage.goToLoginPage();
        loginPage.fillForm("demo", "demo123");
        loginPage.clickLoginButton();
    }

    @And("^El usuario se encuentra en la pagina de Panel Principal$")
    public void verifyOnPanelPrincipal() {
        panelPrincipalPage.verifyOnProfilePage();
    }

    @When("El usuario selecciona el icono Ocultar Saldos de la cuenta {string}")
    public void clickHideBalanceIcon(String accountName) {
        panelPrincipalPage.clickOnToggleBalanceButton(accountName);
    }

    @Then("El saldo de la {string} del usuario se oculta en la interfaz")
    public void verifyBalancesHidden(String accountName) {
        Assert.assertTrue(panelPrincipalPage.isBalanceHidden(accountName));
    }

}
