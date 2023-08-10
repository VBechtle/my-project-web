import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(className = "css-w0pj6f")
//    WebElement mainPageLoggedInUser;

    @FindBy(css = ".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.css-17qbyv7")
    WebElement mainPageHeaderUserAvatarButton;

    @FindBy(xpath = "//span[normalize-space()='Sign Out']")
    WebElement signOutButton;

    public boolean mainPageIsDisplayed() {
        return mainPageHeaderUserAvatarButton.isDisplayed();
    }

    public void clickOnHeaderUserAvatar() {
        mainPageHeaderUserAvatarButton.click();
    }

    public void clickOnSignOutButton() {
        signOutButton.click();
    }

}
