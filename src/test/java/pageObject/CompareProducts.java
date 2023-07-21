package pageObject;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.LoginSteps;

import java.io.IOException;
import java.time.Duration;

public class CompareProducts extends LoginSteps{
    static WebDriverWait wait = new WebDriverWait(LoginSteps.driver, Duration.ofSeconds(10));
    public static void scrollToHotSellers(){

        JavascriptExecutor js = (JavascriptExecutor)LoginSteps.driver;
        WebElement RadiantTee = LoginSteps.driver.findElement(By.xpath("(//img[@alt='Radiant Tee'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", RadiantTee);

    }
    public static  void HoverToClickCompareIcon() throws IOException, InterruptedException {
        test.info("User clicks an img to add item to compare");
//          selected colour so that the hover won't disappear
        WebElement hoverColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='option-label-color-93-item-57'])[1]")));
        hoverColor.click();
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("CompareIcon")).build());
//        click add to compare button
        LoginSteps.driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]")).click();
        Thread.sleep(1500);
    }
    public static  void compareOnImgClicked() throws IOException, InterruptedException {
        test.info("User clicks an img to add item to compare");
//        find product to compare
        WebElement BreatheTank = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@alt='Breathe-Easy Tank'])[1]")));
        BreatheTank.click();
//        click add to compare button
        WebElement CompareButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(text(),'Add to Compare')])[1]")));
        CompareButton.click();
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("compareOnImgClicked")).build());

        Thread.sleep(1500);
    }

    public static void weatherTankProduct(){
//                find product to compare
        LoginSteps.driver.findElement(By.xpath("(//img[@alt='Argus All-Weather Tank'])[1]")).click();
//        click add to compare button
        LoginSteps.driver.findElement(By.xpath("(//span[contains(text(),'Add to Compare')])[1]")).click();

    }
    public static void removeComparedItem() throws IOException, InterruptedException {
        test.info("User is removing item on product compare page");
        WebElement removeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Remove Product'])[1]")));
        removeElement.click();
        test.info("Value entered", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot("remove Compared Item")).build());

    }

    public static void okAlertButton() throws InterruptedException {
        WebElement okAlertButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='action-primary action-accept'])[1]")));
        okAlertButton.click();
        Thread.sleep(1500);

    }

    public static void compareListLink(){
        //        click compare list link on the confirmation message
        JavascriptExecutor js = (JavascriptExecutor)LoginSteps.driver;
        WebElement LinkOnConfirmMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='comparison list'])[1]")));
        js.executeScript("arguments[0].scrollIntoView();",LinkOnConfirmMessage);
        LoginSteps.driver.findElement(By.linkText("comparison list")).click();
    }
    public static  void compareProducts(){
        LoginSteps.driver.findElement(By.xpath("(//div[@class='page-wrapper'])[1]"));
    }
}
