import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-ov6rm9")
    private WebElement mainSignUpButton;
    @FindBy(css = "div[class='dropdown bootstrap-select sw-form-capture-element d-none sw-background-color-FAFAFC hover:sw-background-color-FAFAFC sw-font-size-s sw-text-color-212121 sw-font-family-default sw-border-radius-l sw-padding-top-5xs sw-padding-bottom-5xs sw-margin-top-6xs sw-margin-bottom-6xs sw-border-style-solid sw-border-width-xs sw-border-color-F0F0F4 hover:sw-border-style-solid hover:sw-border-width-xs hover:sw-border-color-AEAEB5 sw-box-shadow-none sw-display-inline-block sw-padding-left-4xs sw-outline-none sw-width-full']")
    private WebElement selectYourRoleDropdown;
    @FindBy(id = "bs-select-1-0")
    private WebElement selectRoleTeacherInDropDown;
    @FindBy(id = "bs-select-1-1")
    private WebElement selectRoleStudentInDropDown;
    @FindBy(id = "sw-form-capture-full_name-input")
    private WebElement userFullNameInputField;
    @FindBy(id = "sw-form-capture-email-input")
    private WebElement userEmailInputField;
    @FindBy(id = "sw-form-password-input")
    private WebElement userPasswordInputField;
    @FindBy(css = ".checkmark.position-relative.sw-checkbox")
    private WebElement selectCheckbox;
    @FindBy(id = "sw-sign-up-submit-btn")
    private WebElement signUpButton;
    @FindBy(css=".validation-message.d-none.d-block")
    private WebElement passwordErrorMessage;
    @FindBy(css = ".error-message.required-errors.d-block")
    private WebElement errorMessage;
    @FindBy(css = ".fa.show-password.fa-eye-slash")
    private WebElement passwordEyeIconHidden;
    @FindBy(css = ".fa.show-password.active.fa-eye")
    private WebElement passwordEyeIconVisible;
    @FindBy(xpath = "//a[normalize-space()='Terms']")
    private WebElement termsLink;
    @FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
    private WebElement privacyPolicyLink;
    @FindBy(css = ".content")
    WebElement softrTermsAndConditionsPage;
    @FindBy(css = ".content")
    WebElement softrPrivacyPolicyPage;


    public void clickOnMainSignUpButton() {
        mainSignUpButton.click();
        }
    public void clickOnSelectYourRoleDropdown() {
        selectYourRoleDropdown.click();
        }
    public void clickSelectRoleTeacherInDropDown() {
        selectRoleTeacherInDropDown.click();
    }
    public void clickSelectRoleStudentInDropDown() {
        selectRoleStudentInDropDown.click();
    }
    public void enterValueToUserFullName(User user) {
        userFullNameInputField.sendKeys(user.getUserFullName());
    }
    public void enterValueToUserEmail(User user) {
        userEmailInputField.sendKeys(user.getUserEmail());
    }
    public void enterValueToUserPassword(User user) {
        userPasswordInputField.sendKeys(user.getUserPassword());
    }
    public void tickCheckbox() {
        selectCheckbox.click();
    }
    public void clickOnSignUpButton() {
        signUpButton.click();
    }
    public String passwordErrorMessageTextIsCorrect() {
        return passwordErrorMessage.getText();
    }
    public String errorMessageTextIsCorrect() {
        return errorMessage.getText();
    }
    public void clickOnPasswordEyeIconHidden() {
        passwordEyeIconHidden.click();
    }
    public boolean checkPasswordEyeIconIsVisible() {
        return passwordEyeIconVisible.isEnabled();
    }
    public void clickOnTermsLink() {
        termsLink.click();
    }
    public void clickOnPrivacyPolicyLink() {
        privacyPolicyLink.click();
    }
    public boolean termsAndConditionsPageIsDisplayed() {
        return softrTermsAndConditionsPage.isDisplayed();
    }
    public boolean privacyPolicyPageIsDisplayed() {
        return softrPrivacyPolicyPage.isDisplayed();
    }
}
