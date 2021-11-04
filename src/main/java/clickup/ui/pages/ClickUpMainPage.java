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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickUpMainPage extends BasePage {
    @FindBy(css = "img[src*='./assets/images/brand/clickup-text']")
    protected WebElement clickUpIcon;
    private SideBar sideBar = new SideBar(webDriverManager);

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
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(clickUpIcon);
    }
}
