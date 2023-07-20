package pageObject;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.ExtentReport;
import stepDefinition.LoginSteps;

import java.io.IOException;
import java.time.Duration;

import static reporting.ExtentReport.getScreenshot;
import static reporting.ExtentReport.test;

public class Login {
    public WebDriver driver= LoginSteps.driver;
    static WebDriverWait wait = new WebDriverWait(LoginSteps.driver, Duration.ofSeconds(10));


    public static void SignInButton(){
        LoginSteps.driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();

    }
    public static void LogIn(String Email, String password) throws IOException {

//       ExtentReport.createTest("User Login");

        ExtentReport.test.info("User entered correct credentials");


        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='email'])[1]")));
        emailInput.sendKeys(Email);

        WebElement passwordInput = LoginSteps.driver.findElement(By.xpath("(//input[@id='pass'])[1]"));
        passwordInput.sendKeys(password);
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Sign In")).build());



    }
    public static void clickLoginButton(){
        LoginSteps.driver.findElement(By.xpath("(//span[contains(text(),'Sign In')])[1]")).click();

    }

    public static void goTo(){
        LoginSteps.driver.findElement(By.xpath("(//img)[1]")).click();
    }


}


