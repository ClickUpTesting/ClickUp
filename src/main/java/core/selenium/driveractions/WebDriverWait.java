package core.selenium.driveractions;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebDriverWait {
    protected WebDriver driver;
    protected org.openqa.selenium.support.ui.WebDriverWait wait;
    protected WebDriverManager webDriverManager;

    /**
     * Selects and initializes a wev driver action.
     *
     * @param webDriverManager to be used for the interactions
     * @author Jorge Caceres
     */
    public WebDriverWait(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.driver = this.webDriverManager.getWebDriver();
        this.wait = this.webDriverManager.getWait();
    }

    /**
     * Waits until a web element is visible.
     *
     * @param locator of the web element to be waited
     * @author Jorge Caceres
     */
    public void waitVisibilityOfElement(final By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until a web element is visible.
     *
     * @param webElement to be waited
     * @author Jorge Caceres
     */
    public void waitVisibilityOfElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
