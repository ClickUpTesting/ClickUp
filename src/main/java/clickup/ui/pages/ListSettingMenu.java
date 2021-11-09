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

public class ListSettingMenu extends BasePage {
    @FindBy(css = "div[data-test='nav-menu-item__name']")
    private WebElement deleteButton;
    @FindBy(css = "button[aria-label='Rename']")
    private WebElement editButton;

    public ListSettingMenu(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the edit button.
     *
     * @author Jorge Caceres
     */
    public void clickEditButton() {
        webDriverActions.clickElement(editButton);
    }

    /**
     * Clicks on the delete list button.
     *
     * @author Jorge Caceres
     */
    public void clickDeleteButton() {
        webDriverActions.clickElement(deleteButton);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(deleteButton);
    }
}
