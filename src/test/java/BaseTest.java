import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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

    public void tearDown() {
        driver.quit();
    }

    @Rule
    public TestWatcher screenShotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }
        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            driver.close();
            driver.quit();
        }
        @Override
        protected void succeeded(Description description) {
            driver.close();
            driver.quit();
        }
        @Attachment
        public byte[] makeScreenshotOnFailure(){
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
    };

    User validUserTeacher = new User("test_teacher@gmail.com", "123456", "");
    User validUserStudent = new User("malik@example.com", "123456", "");
    User invalidUserPassword = new User("test@gmail.com", "111111", "");
    User invalidUserEmail = new User("test.com", "123456", "");
    User newValidUserTeacher = new User("test.teacher@gmail.com", "123456", "Test Teacher");
    User newValidUserStudent = new User("test.student@gmail.com", "123456", "Test Student");
    User newInvalidUser = new User("test.studentgmail.com", "123", "");


    static RequestSpecification specification = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri("https://studio-api.softr.io/v1/api")
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", "khIbAyJIU5CIuh1oDuBRx1s49")
            .addHeader("Softr-Domain", "jere237.softr.app" )
            .build();
    public Response deleteRequest(String endPoint, int responseCode) {
        Response response = RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .delete(endPoint)
                .then()
                .log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
    public void deleteExistingUser(Integer responseCode, String email) {
        String endpoint = "/users/";
        deleteRequest(endpoint + email, responseCode);
    }
}
