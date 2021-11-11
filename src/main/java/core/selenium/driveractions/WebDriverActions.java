/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package core.selenium.driveractions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import core.selenium.WebDriverConfig;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverActions {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverManager webDriverManager;
    private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();

    /**
     * Selects and initializes a wev driver action.
     *
     * @param webDriverManager to be used for the interactions
     * @author Jorge Caceres
     */
    public WebDriverActions(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.driver = this.webDriverManager.getWebDriver();
        this.wait = this.webDriverManager.getWait();
    }

    /**
     * Clicks an element by locator.
     *
     * @param locator is the element to be clicked
     * @author Jorge Caceres
     */
    public void clickElement(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    /**
     * Clicks a web element.
     *
     * @param webElement to be clicked
     * @author Jorge Caceres
     */
    public void clickElement(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Scrolls to the end of the page.
     *
     * @author Jorge Caceres
     */
    public void scrollToBottom() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    /**
     * Scrolls to the top of the page.
     *
     * @author Jorge Caceres
     */
    public void scrollToTop() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 0)");
    }

    /**
     * Selects a webElement isn't able to click.
     *
     * @param locator type WebElement object
     * @author Jorge Caceres
     */
    public void selectByAction(final By locator) {
        Actions builder = new Actions(driver);
        Action action = builder.click(driver.findElement(locator)).build();
        action.perform();
    }

    /**
     * Refresh the page.
     *
     * @author Jorge Caceres
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Returns a list of elements found from the given locator.
     *
     * @param locator represents the locator
     * @return a List of web elements
     * @author Jorge Caceres
     */
    public List<WebElement> getWebElements(final By locator) {
        return driver.findElements(locator);
    }

    /**
     * Gets texts on a List of webElement.
     *
     * @param locator is a locator
     * @return a list with text in the webElements
     * @author Gustavo Huanca
     */
    public List<String> getStringsOfElements(final By locator) {
        List<WebElement> webElementList = getWebElements(locator);
        List<String> list = new ArrayList<>();
        webElementList.forEach(element -> list.add(element.getText()));
        return list;
    }

    /**
     * Verifies if an element is in the DOM.
     *
     * @param locator of the element to be verified
     * @return a boolean that indicates if an element exists
     * @author Jorge Caceres
     */
    public boolean isInDom(final By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    /**
     * Finds a locator and verifies if that exist.
     *
     * @param by           is locator
     * @param intervalTime is interval time
     * @return a boolean if a locator exists
     * @author Gustavo Huanca
     */
    public boolean isElementPresent(final By by, final int intervalTime) {
        webDriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(intervalTime));
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            webDriverManager.setDriverWaits(webDriverConfig.getImplicitWaitTime(),
                    webDriverConfig.getExplicitWaitTime(), webDriverConfig.getWaitSleepTime());
        }
    }
}
