package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{

    String LogoutButton = "//button[text()='Log out']";
    String url = "https://demoqa.com/profile";

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void verifyOnProfilePage() {
        Assert.assertTrue(Find(LogoutButton).isDisplayed());
        waitForUrlContains(url);
    }

}
