/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages;

import core.selenium.driveractions.WebDriverActions;
import core.selenium.WebDriverManager;
import core.selenium.driveractions.WebDriverElementText;
import core.selenium.driveractions.WebDriverWaits;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriverActions webDriverActions;
    protected WebDriverElementText webDriverElementText;
    protected WebDriverWaits webDriverWaits;
    protected WebDriverManager webDriverManager;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     * @author Gustavo Huanca
     */
    public BasePage(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        webDriverActions = new WebDriverActions(this.webDriverManager);
        webDriverElementText = new WebDriverElementText(this.webDriverManager);
        webDriverWaits = new WebDriverWaits(this.webDriverManager);
        PageFactory.initElements(webDriverManager.getWebDriver(), this);
        waitForPageLoaded();
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    protected abstract void waitForPageLoaded();
}
