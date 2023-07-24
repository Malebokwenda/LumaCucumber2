package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Login;
import reporting.ExtentReport;
import utilities.ExcelReader;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps extends ExtentReport{

    public static WebDriver driver;
    public final static int TIMEOUT = 10;
    @Before
    public static void before_all() {
        ExtentReport.initReports();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }
    @Given("User is on LumaLogin page {string}")
    public void user_is_on_luma_login_page(String url) throws IOException {
        createTest("Sign in");
        Login.SignInButton();
    }

    @When("user enter a correct username and a correct password")
    public void user_enter_a_correct_username_and_a_correct_password() throws IOException {
        String email = ExcelReader.getCellData(1, 3);
        String password = ExcelReader.getCellData(1, 4);
        Login.LogIn(email, password);

    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        Login.clickLoginButton();
    }

    @Then("user should be logged in to my account")
    public void user_should_be_logged_in_to_my_account() {
        Login.goTo();
    }

    @After
    public  static void after_all() throws IOException {
        driver.quit();

        flushReports();
    }
}
