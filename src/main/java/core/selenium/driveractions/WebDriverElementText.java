package core.selenium.driveractions;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverElementText {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverManager webDriverManager;

    /**
     * Selects and initializes a wev driver action.
     *
     * @param webDriverManager to be used for the interactions
     * @author Jorge Caceres
     */
    public WebDriverElementText(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.driver = this.webDriverManager.getWebDriver();
        this.wait = this.webDriverManager.getWait();
    }

    /**
     * Sends keys to a form .
     *
     * @param locator of the web element with an entry form
     * @param input is the data to be sent
     * @author Jorge Caceres
     */
    public void setText(final By locator, final String input) {
        setText(driver.findElement(locator), input);
    }

    /**
     * Sends keys to a web element with an entry form .
     *
     * @param webElement with an entry form
     * @param input is the data to be sent
     * @author Jorge Caceres
     */
    public void setText(final WebElement webElement, final String input) {
        webElement.clear();
        webElement.sendKeys(input);
    }

    /**
     * Gets the text of a web element.
     *
     * @param locator web element to get text
     * @return web element's text
     * @author Jorge Caceres
     */
    public String getWebElementText(final By locator) {
        return getWebElementText(driver.findElement(locator));
    }

    /**
     * Gets the text of a web element.
     *
     * @param webElement to get text
     * @return web element's text
     * @author Jorge Caceres
     */
    public String getWebElementText(final WebElement webElement) {
        return webElement.getText();
    }
}
