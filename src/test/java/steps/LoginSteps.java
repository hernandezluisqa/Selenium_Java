package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class LoginSteps {
    MainPage mainPage = new MainPage(Hooks.driver);
    LoginPage loginPage = new LoginPage(Hooks.driver);
    ProfilePage profilePage = new ProfilePage(Hooks.driver);

    @Given("el usuario está en la página principal {string}")
    public void goToMainPage(String url) {
        mainPage.navigateToMainPage(url);
    }

    @And("hace clic en el botón de login")
    public void clickLoginButton() {
        mainPage.clickLoginButton();
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void enterLoginCredentials(String username, String password) {
        loginPage.verifyOnLoginPage();
        loginPage.fillForm(username, password);
    }

    @And("hace clic en el botón de login del formulario")
    public void clickLoginButtonOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @Then("debería ser redirigido al perfil del usuario")
    public void verifyUserIsOnProfilePage() {
        profilePage.verifyOnProfilePage();
    }
}
