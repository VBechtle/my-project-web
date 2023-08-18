import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.css-17qbyv7")
    WebElement mainPageLoggedInUser;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']")
    WebElement mainPageHeaderUserAvatarButton;

    @FindBy(xpath = "//span[normalize-space()='Sign Out']")
    WebElement signOutButton;

    public boolean mainPageIsDisplayed() {
        return mainPageLoggedInUser.isDisplayed();
    }

    public boolean clickOnHeaderUserAvatar() {
        mainPageHeaderUserAvatarButton.click();
        return false;
    }

    public void clickOnSignOutButton() {
        signOutButton.click();
    }

}
