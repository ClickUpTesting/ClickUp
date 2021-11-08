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

import clickup.ui.pages.sidebar.SideBar;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickUpMainPage extends BasePage {
    @FindBy(css = "div[data-test='simple-bar__item-label']")
    protected WebElement homeIcon;
    private SideBar sideBar = new SideBar(webDriverManager);
    protected By closeIconInCreateSpace = By.cssSelector("div[data-test='modal-close-btn']");
    protected By spaceCopiedCloseIcon = By.cssSelector("div.toast__close-button-block.toast__"
            + "close-button-block_top-right");
    private static final int INTERVAL_TIME = 2000;

    /**
     * Gets the sidebar menu
     *
     * @return a new sidebar
     * @author Jorge Caceres
     */
    public SideBar getSideBar() {
        return sideBar;
    }

    public ClickUpMainPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Closes create space form.
     *
     * @author Gustavo Huanca
     */
    public void clickIconInCreateSpace() {
        if (webDriverActions.isElementPresent(closeIconInCreateSpace, INTERVAL_TIME)) {
            webDriverActions.clickElement(closeIconInCreateSpace);
        }
    }

    /**
     * Closes the message Space copied successful.
     *
     * @author Gustavo Huanca
     */
    public void clickMessageSpaceCopied() {
        if (webDriverActions.isElementPresent(spaceCopiedCloseIcon, INTERVAL_TIME)) {
            webDriverActions.clickElement(spaceCopiedCloseIcon);
        }
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
