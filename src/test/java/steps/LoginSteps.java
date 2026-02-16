package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(Hooks.driver);
    ProfilePage profilePage = new ProfilePage(Hooks.driver);

    @Given("el usuario se encuenta en la pagina de Login de Home Banking")
    public void goToMainPage() {
        loginPage.goToLoginPage();
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void enterLoginCredentials(String username, String password) {
        loginPage.verifyOnLoginPage();
        loginPage.fillForm(username, password);
    }

    @And("hace clic en el botón Ingresar")
    public void clickLoginButtonOnLoginPage() {
        loginPage.clickLoginButton();
    }

    @Then("debería ser redirigido al panel principal del usuario {string}")
    public void verifyUserIsOnProfilePage(String username) {
        profilePage.verifyOnProfilePage();
        String displayedUsername = profilePage.getDisplayedUsername();
        Assert.assertEquals(displayedUsername, username, "El nombre de usuario mostrado no coincide con el esperado.");
    }

    @Then("se muestra mensaje de error")
    public void verifyErrorMessage() {
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Usuario o contraseña incorrectos"), "El mensaje de error no es el esperado.");
    }

    @And("permanece en Login")
    public void verifyUserRemainsOnLoginPage() {
        loginPage.verifyOnLoginPage();
    }
}
