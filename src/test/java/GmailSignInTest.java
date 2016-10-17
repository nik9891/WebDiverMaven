
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;


public class GmailSignInTest {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void gmailLoginShouldBeSuccessful(){
    //Go to gmail website

        driver.get("http://gmail.com");

        //fill in username
        WebElement usernameTextbox=driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("nikhillkumar98@gmail.com");
        //click on next
        WebElement next= driver.findElement(By.id("next"));
        next.click();
        //file in password
        WebElement password=driver.findElement(By.id("Passwd"));
        password.clear();
        password.sendKeys("lizanishi");
        //click sign in
        WebElement signInButton=driver.findElement(By.id("signIn"));
        signInButton.click();
        //verify user signed in
        WebDriverWait wait= new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("Inbox")).size()>0);
        //click sign-out span[class='gb_8a gbii']
        WebElement profilebutton=driver.findElement(By.cssSelector("span[class='gb_8a gbii']"));
        profilebutton.click();

        WebElement signOutLinkage=driver.findElement(By.id("gb_71"));
        signOutLinkage.click();
        //verify user signed-out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("signIn")));
        Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("signIn")).size()>0);


    }
    
    public void teardown(){
        driver.quit();
    }


}
