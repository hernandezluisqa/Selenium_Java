package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.ProfilePage;

public class LogoutSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver);
    ProfilePage profilePage = new ProfilePage(Hooks.driver);

    @Given("el usuario ha iniciado sesion exitosamente")
    public void successLogin() {
        loginPage.goToLoginPage();
        loginPage.fillForm("demo", "demo123");
        loginPage.clickLoginButton();
    }

    @And("el usuario se encuentra en la pagina de Dashboard")
    public void verifyOnDashboard() {
        profilePage.verifyOnProfilePage();
    }

    @When("el usuario hace click en boton salir")
    public void clickLogoutButton(){
        profilePage.clickLogoutButton();
    }
    @And("da click en el boton confirmar del modal de confirmacion")
    public void clickConfirmLogout() {
        profilePage.clickConfirmLogout();
    }

    @Then("el usuario es redirigido a la pagina de login")
    public void verifyRedirectionToLoginPage() {
        loginPage.verifyOnLoginPage();
    }

}
