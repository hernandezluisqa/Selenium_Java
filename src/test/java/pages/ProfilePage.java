package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{

    String title = "//h2[text()='Panel Principal']";
    String username = "//span[@id='user-name']";
    String logoutButton = "//button[@id='logout-btn']";
    String modalLogoutConfirmButton = "//button[contains(@id, 'modal-confirm')]";
    String ModalLogoutCancelButton ="//button[contains(@id, 'modal-cancel')]";
    String titleModalLogout = "//div[contains(@class, 'modal-header')]/h3";
    String bodyModalLogout = "//div[contains(@class, 'modal-body')]/p";
    String toastMessage = "//div[@id='toast-container']";


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getDisplayedUsername() {
        return Find(username).getText();
    }

    public void verifyOnProfilePage() {
        Find(title).isDisplayed();
        Find(username).isDisplayed();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.invisibilityOf(Find(toastMessage)));
        clickElement(logoutButton);
    }

    public void clickConfirmLogout() {
        clickElement(modalLogoutConfirmButton);
    }
}
