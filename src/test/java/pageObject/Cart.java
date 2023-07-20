package pageObject;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepDefinition.LoginSteps;

import java.io.IOException;

public class Cart extends  LoginSteps{
    public static void threeStarsAddToCart() throws IOException {
        LoginSteps.driver.findElement(By.xpath("(//button[@id='product-addtocart-button'])[1]")).click();
    }
    public static void addPulloverToCart(){
        LoginSteps.driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]")).click();

    }
    public static void clickCartIcon(){
        LoginSteps.driver.findElement(By.xpath("(//a[@class='action showcart'])[1]")).click();
        Actions actions = new Actions(   LoginSteps.driver);

        WebElement proceedToCheckout =    LoginSteps.driver.findElement(By.cssSelector("#top-cart-btn-checkout"));
        actions.moveToElement(proceedToCheckout).click().perform();

    }
    public static  void heroHoodieCartButton() throws IOException {
        LoginSteps.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[1]/form/button")).click();

    }
}
