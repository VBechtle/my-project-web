import API.tests.ApiBaseTest;
import API.tests.DeleteUserTest;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver;
    String BASE_URL = "https://jere237.softr.app";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Обучение\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


//    @Rule
//    public TestWatcher screenShotOnFailure = new TestWatcher() {
//        @Override
//        protected void failed(Throwable e, Description description) {
//            makeScreenshotOnFailure();
//            driver.close();
//            driver.quit();
//        }
//        @Override
//        protected void skipped(AssumptionViolatedException e, Description description) {
//            driver.close();
//            driver.quit();
//        }
//        @Override
//        protected void succeeded(Description description) {
//            driver.close();
//            driver.quit();
//        }
//        @Attachment
//        public byte[] makeScreenshotOnFailure(){
//            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//        }
//    };



    User validUserTeacher = new User("test@gmail.com", "123456", "");
    User validUserStudent = new User("malik@example.com", "123456", "");
    User invalidUserPassword = new User("test@gmail.com", "111111", "");
    User invalidUserEmail = new User("test.com", "123456", "");
    User newValidUserTeacher = new User("test.teacher@gmail.com", "123456", "Test Teacher");
    User newValidUserStudent = new User("test.student@gmail.com", "123456", "Test Student");
    User newInvalidUser = new User("test.studentgmail.com", "123", "");
}
