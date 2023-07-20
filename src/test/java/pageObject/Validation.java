package pageObject;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinition.LoginSteps;

import java.io.IOException;
import java.time.Duration;

public class Validation extends  LoginSteps {
    static WebDriverWait wait = new WebDriverWait(LoginSteps.driver, Duration.ofSeconds(10));
    public static void EmptyFields() throws IOException {
//         Wait for the error message to be displayed
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='super_attribute[143]-error'])[1]")));

//         Verify the error message
        String expectedErrorMessage = "This is a required field.";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }
    public static void itemAddedToCart(){

        //         Wait for the item added to cart  message to be displayed
        WebElement AddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div")));
//         Verify the  message
        String expectedAddedItemMessage = "You added Miko Pullover Hoodie to your shopping cart.";
        String actualAddedItemMessage = AddedMessage.getText();
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );

    }
    public static  void compareSuccessText() throws IOException {
        WebElement AddedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")));
        String expectedAddedItemMessage = "You added product Breathe-Easy Tank to the comparison list.";
        String actualAddedItemMessage = AddedMessage.getText() ;
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );
    }
    public static void removedItemText() throws IOException {
        WebElement AddedMessage = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)'])[1]")));
        String expectedAddedItemMessage = "You removed product Argus All-Weather Tank from the comparison list.";
        String actualAddedItemMessage = AddedMessage.getText() ;
        Assert.assertEquals(actualAddedItemMessage,expectedAddedItemMessage );

    }
}
