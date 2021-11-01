/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.sidebar.settings.workspaces;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Workspaces extends BasePage {
    @FindBy(css = "div[class='team-list-item__icon']")
    protected WebElement addNewButton;

    public Workspaces(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks in Add new button.
     *
     * @return go to page form
     */
    public WorkspaceForm clickAddNewIcon() {
        webDriverActions.clickElement(addNewButton);
        return new WorkspaceForm(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
