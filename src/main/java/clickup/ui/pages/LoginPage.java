/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.utils.EncryptManager.decryptText;

public class LoginPage extends BasePage {
    @FindBy(id = "login-email-input")
    public WebElement usernameTextBox;

    @FindBy(id = "login-password-input")
    public WebElement passwordTextBox;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;
    protected By sideBarCollapseIcon = By.xpath("//div[contains(@class,'cu-simple-bar__toggle') "
            + "or @class='cu-collapsed-sidebar__toggle-icon']//*[@class='ng-star-inserted']");
    private static final int INTERVAL_TIME = 1000;

    public LoginPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    public void waitForPageLoaded() {
    }

    /**
     * Sets the username text box value.
     *
     * @param userName a String with the value
     * @author Jorge Caceres
     */
    public void setUsernameTextBox(final String userName) {
        webDriverElementText.setText(usernameTextBox, userName);
    }

    /**
     * Sets the password text box value.
     *
     * @param password a String with the value
     * @author Jorge Caceres
     */
    public void setPasswordTextBox(final String password) {
        webDriverElementText.setText(passwordTextBox, password);
    }

    /**
     * Clicks on the login button.
     *
     * @return a main click up page
     * @author Jorge Caceres
     */
    public ClickUpMainPage clickLoginButton() {
        webDriverActions.clickElement(loginButton);
        return new ClickUpMainPage(webDriverManager);
    }

    /**
     * Logs in clickUp only once time.
     *
     * @return a main click up page
     * @author Gustavo Huanca
     */
    public ClickUpMainPage loginClickUp() {
        if (!webDriverActions.isElementPresent(sideBarCollapseIcon, INTERVAL_TIME)) {
            webDriverWaits.waitVisibilityOfElement(loginButton);
            setUsernameTextBox(System.getenv("CLICK_UP_USER"));
            setPasswordTextBox(decryptText(System.getenv("CLICK_UP_PASS")));
            return clickLoginButton();
        }
        return new ClickUpMainPage(webDriverManager);
    }
}
