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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "login-email-input")
    public WebElement usernameTextBox;

    @FindBy(id = "login-password-input")
    public WebElement passwordTextBox;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

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
        webDriverWait.waitVisibilityOfElement(loginButton);
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
}
