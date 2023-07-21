package pageObject;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.LoginSteps;

import java.io.IOException;
import java.time.Duration;

public class Checkout extends LoginSteps {
    public static WebDriver driver = LoginSteps.driver;
    static WebDriverWait wait = new WebDriverWait(LoginSteps.driver, Duration.ofSeconds(10));

    public static void captureShippingInfo(String FirstName, String LastName, String SCompany, String SCountry, String SAddress, String SCity, String SProvince, String SCode, String SPhone) throws IOException {
        test.info("User is filling shipping information");
        //        Fill in personal info
        WebElement firstNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name, \"firstname\")]")));
        firstNameInput.clear();
        firstNameInput.sendKeys(FirstName);

        WebElement lastNameInput = LoginSteps.driver.findElement(By.name("lastname"));
        lastNameInput.clear();
        lastNameInput.sendKeys(LastName);


        WebElement companyInput = LoginSteps.driver.findElement(By.name("company"));
        companyInput.clear();
        companyInput.sendKeys(SCompany);

//        address
        WebElement addressInput = LoginSteps.driver.findElement(By.name("street[0]"));
        addressInput.clear();
        addressInput.sendKeys(SAddress);

        WebElement cityInput = LoginSteps.driver.findElement(By.name("city"));
        cityInput.clear();
        cityInput.sendKeys(SCity);
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Shipping Info1")).build());



//        Select country
        WebElement  countryDropdown = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"KXK8X9A\"]")));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(SCountry);


//        province
        WebElement  provinceInput = LoginSteps.driver.findElement(By.name("region"));
        provinceInput.sendKeys(SProvince);


//      postal code
        WebElement zipInput = LoginSteps.driver.findElement(By.name("postcode"));
        zipInput.clear();
        zipInput.sendKeys(SCode);


//      cellphone
        WebElement cellNumberInput = LoginSteps.driver.findElement(By.name("telephone"));
        cellNumberInput.clear();
        cellNumberInput.sendKeys(SPhone);

//        shipping method
        WebElement shippingMethod= wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//input[@name='ko_unique_2'])[1]")));
        Actions actions = new Actions(LoginSteps.driver);
        actions.moveToElement(shippingMethod).click().perform();

        LoginSteps.driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("Shipping Info")).build());
        //        place order
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='primary'])[3]"))).click();


    }
}
