import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-g27pfb")
    private WebElement mainSignInButton;
    @FindBy(id = "sw-form-capture-email-input")
    private WebElement userEmailInputField;
    @FindBy(id = "sw-form-password-input")
    private  WebElement passwordInputField;
    @FindBy(id = "sw-sign-in-submit-btn")
    private WebElement signInButton;
    @FindBy(css = ".error-message.login-error.d-block")
    private WebElement errorMessage;
    @FindBy(css = ".fa.show-password.fa-eye-slash")
    private WebElement passwordEyeIconHidden;
    @FindBy(css = ".fa.show-password.active.fa-eye")
    private WebElement passwordEyeIconVisible;

    @Step("Click on SignIn button on the main page")
    public void clickOnMainSignInButton() {
        mainSignInButton.click();
    }
    @Step("Enter value to email")
    public void enterValueToEmail(User user) {
        userEmailInputField.sendKeys(user.getUserEmail());
    }
    @Step("Enter value to password")
    public void enterValueToPassword(User user) {
        passwordInputField.sendKeys(user.getUserPassword());
    }
    @Step("Click on SignIn button on the login page ")
    public void clickOnSignInButton() {
        signInButton.click();
    }
    @Step("Check that the error message text is correct ")
    public String errorMessageTextIsCorrect() {
        return errorMessage.getText();
    }
    @Step("Click on password eye icon")
    public void clickOnPasswordEyeIconHidden() {
        passwordEyeIconHidden.click();
    }
    @Step("Check that password is visible after clicking on password eye icon")
    public boolean checkPasswordEyeIconIsVisible() {
        return passwordEyeIconVisible.isEnabled();
    }

    public boolean signInButtonOnSignInPageIsVisible() {
        return signInButton.isDisplayed();
    }

    public void successLoginTeacher(User user) {
        mainSignInButton.click();
        userEmailInputField.sendKeys(user.getUserEmail());
        passwordInputField.sendKeys(user.getUserPassword());
        signInButton.click();
    }

    public void successLoginStudent(User user) {
        mainSignInButton.click();
        userEmailInputField.sendKeys(user.getUserEmail());
        passwordInputField.sendKeys(user.getUserPassword());
        signInButton.click();
    }
}
