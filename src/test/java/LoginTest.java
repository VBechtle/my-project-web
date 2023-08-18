import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test @DisplayName("Success login teacher")
    @Description("Login with valid data")
    public void loginWithValidDataTeacher() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnMainSignInButton();
        loginPage.enterValueToEmail(validUserTeacher);
        loginPage.enterValueToPassword(validUserTeacher);
        loginPage.clickOnSignInButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
    }

    @Test @DisplayName("Success login student")
    @Description("Login with valid data")
    public void loginWithValidDataStudent() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnMainSignInButton();
        loginPage.enterValueToEmail(validUserStudent);
        loginPage.enterValueToPassword(validUserStudent);
        loginPage.clickOnSignInButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
    }

    @Test @DisplayName("Login with invalid password")
    @Description("Login with invalid data")
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnMainSignInButton();
        loginPage.enterValueToEmail(invalidUserPassword);
        loginPage.enterValueToPassword(invalidUserPassword);
        loginPage.clickOnSignInButton();
        assertEquals("Invalid email or password", loginPage.errorMessageTextIsCorrect());
    }

    @Test @DisplayName("Login with invalid email")
    @Description("Login with invalid data")
    public void loginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnMainSignInButton();
        loginPage.enterValueToEmail(invalidUserEmail);
        loginPage.enterValueToPassword(invalidUserEmail);
        loginPage.clickOnSignInButton();
        assertEquals("Invalid email or password", loginPage.errorMessageTextIsCorrect());
    }

    @Test @DisplayName("Success login teacher and check password eye icon")
    @Description("Password eye icon test")
    public void loginWithValidDataAndCheckPasswordEyeIcon() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnMainSignInButton();
        loginPage.enterValueToEmail(validUserTeacher);
        loginPage.enterValueToPassword(validUserTeacher);
        loginPage.clickOnPasswordEyeIconHidden();
        assertTrue(loginPage.checkPasswordEyeIconIsVisible());
        loginPage.clickOnSignInButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
    }

    @Test @DisplayName("Check forgot password button")
    @Description("Check that the button redirect to the password recovery page")
    public void forgotPasswordButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnMainSignInButton();
        loginPage.enterValueToEmail(validUserTeacher);
        loginPage.enterValueToPassword(validUserTeacher);
        loginPage.clickOnForgotPasswordLink();
        assertTrue(loginPage.recoveryPasswordButtonIsVisible());
    }

    @Test @DisplayName("Check signUp button on signIn page")
    @Description("Check that the signUp button on the signIn page redirect to signUp page")
    public void signUpButtonOnSignInPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnMainSignInButton();
        loginPage.enterValueToEmail(validUserTeacher);
        loginPage.enterValueToPassword(validUserTeacher);
        loginPage.clickOnSignUpButtonOnSignInPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        assertTrue(registrationPage.signUpButtonIsDisplayed());
    }
}
