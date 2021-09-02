package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30, 500);
    }

    public LoginPage clickFormAuthentication(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/login']")));
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        return new LoginPage(driver);
    }
    public KeyPresses clickKeyPresses(){
        driver.findElement(By.linkText("Key Presses")).click();
        return new KeyPresses(driver);
    }
}
