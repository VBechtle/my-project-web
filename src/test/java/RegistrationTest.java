import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest{

    @Test
    public void registrationWithValidDataTeacher() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnSelectYourRoleDropdown();
        registrationPage.clickSelectRoleTeacherInDropDown();
        registrationPage.enterValueToUserFullName(newValidUserTeacher);
        registrationPage.enterValueToUserEmail(newValidUserTeacher);
        registrationPage.enterValueToUserPassword(newValidUserTeacher);
        registrationPage.tickCheckbox();
        registrationPage.clickOnSignUpButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
//        ApiBaseTest apiBaseTest = new ApiBaseTest();
//        apiBaseTest.deleteExistingUser(200, newValidUserTeacher.getUserEmail());
    }

    @Test
    public void registrationWithValidDataStudent() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnSelectYourRoleDropdown();
        registrationPage.clickSelectRoleStudentInDropDown();
        registrationPage.enterValueToUserFullName(newValidUserStudent);
        registrationPage.enterValueToUserEmail(newValidUserStudent);
        registrationPage.enterValueToUserPassword(newValidUserStudent);
        registrationPage.tickCheckbox();
        registrationPage.clickOnSignUpButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
//        ApiBaseTest apiBaseTest = new ApiBaseTest();
//        apiBaseTest.deleteExistingUser(200, newValidUserTeacher.getUserEmail());
    }

    @Test
    public void registrationWithInvalidPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnSelectYourRoleDropdown();
        registrationPage.clickSelectRoleStudentInDropDown();
        registrationPage.enterValueToUserFullName(newValidUserStudent);
        registrationPage.enterValueToUserEmail(newValidUserStudent);
        registrationPage.enterValueToUserPassword(newInvalidUser);
        registrationPage.tickCheckbox();
        registrationPage.clickOnSignUpButton();
        assertEquals("Password must contain at least 6 characters", registrationPage.passwordErrorMessageTextIsCorrect());
    }

    @Test
    public void registrationWithInvalidEmail() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnSelectYourRoleDropdown();
        registrationPage.clickSelectRoleStudentInDropDown();
        registrationPage.enterValueToUserFullName(newValidUserStudent);
        registrationPage.enterValueToUserEmail(newInvalidUser);
        registrationPage.enterValueToUserPassword(newValidUserStudent);
        registrationPage.tickCheckbox();
        registrationPage.clickOnSignUpButton();
        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageTextIsCorrect());
        // Селектор не правильный на сайте (Нужная ошибка скрыта)
    }

    @Test
    public void registrationWithCheckBoxNotSelected() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnSelectYourRoleDropdown();
        registrationPage.clickSelectRoleStudentInDropDown();
        registrationPage.enterValueToUserFullName(newValidUserStudent);
        registrationPage.enterValueToUserEmail(newInvalidUser);
        registrationPage.enterValueToUserPassword(newValidUserStudent);
        registrationPage.clickOnSignUpButton();
        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageTextIsCorrect());
    }

    @Test
    public void registrationWithRoleNotSelected() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.enterValueToUserFullName(newValidUserTeacher);
        registrationPage.enterValueToUserEmail(newValidUserTeacher);
        registrationPage.enterValueToUserPassword(newValidUserTeacher);
        registrationPage.tickCheckbox();
        registrationPage.clickOnSignUpButton();
        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageTextIsCorrect());
    }

    @Test
    public void registrationWithValidDataAndCheckPasswordEyeIcon() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnSelectYourRoleDropdown();
        registrationPage.clickSelectRoleTeacherInDropDown();
        registrationPage.enterValueToUserFullName(newValidUserTeacher);
        registrationPage.enterValueToUserEmail(newValidUserTeacher);
        registrationPage.enterValueToUserPassword(newValidUserTeacher);
        registrationPage.clickOnPasswordEyeIconHidden();
        assertTrue(registrationPage.checkPasswordEyeIconIsVisible());
        registrationPage.tickCheckbox();
        registrationPage.clickOnSignUpButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.mainPageIsDisplayed());
//        ApiBaseTest apiBaseTest = new ApiBaseTest();
//        apiBaseTest.deleteExistingUser(200, newValidUserTeacher.getUserEmail());
    }

    @Test
    public void registrationWithAllEmptyFields() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnSignUpButton();
        assertEquals("Please make sure there are no empty required fields.", registrationPage.errorMessageTextIsCorrect());
    }

    @Test
    public void registrationPageCheckTermsAndConditionsLink() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnTermsLink();
        assertTrue(registrationPage.termsAndConditionsPageIsDisplayed());
    }

    @Test
    public void registrationPageCheckPrivacyPolicyLink() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnMainSignUpButton();
        registrationPage.clickOnPrivacyPolicyLink();
        assertTrue(registrationPage.privacyPolicyPageIsDisplayed());
    }
}
