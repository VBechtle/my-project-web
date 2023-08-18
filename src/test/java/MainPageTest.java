import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainPageTest extends BaseTest {

    @Test
    public void userIsOnMainPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLoginTeacher(validUserTeacher);
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
    }

    @Test
    public void signOut () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLoginTeacher(validUserTeacher);
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
        mainPage.clickOnHeaderUserAvatar();
        mainPage.clickOnSignOutButton();
        assertTrue(loginPage.signInButtonOnSignInPageIsVisible());
    }
}
