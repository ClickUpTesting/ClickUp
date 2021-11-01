/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.sidebar;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.sidebar.settings.Settings;
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceForm;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenuSideBar extends BasePage {
    @FindBy(css = "a.ng-star-inserted[data-test='user-settings-menu-item-my-settings']")
    protected WebElement mySettingLinkTxt;

    @FindBy(css = "div[data-test*='column-title-name'][tooltipmodifier]")
    protected WebElement workSpaceTittle;

    @FindBy(xpath = "//div[@class='cu-user-settings-menu-v2__workspaces-add-plus icon']")
    protected WebElement addWorkspaceIcon;

    public SubMenuSideBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public Settings clickMySettingLinkTxt() {
        webDriverActions.clickElement(mySettingLinkTxt);
        return new Settings(webDriverManager);
    }

    public String getWorkSpaceTittle() {
        return webDriverElementText.getWebElementText(workSpaceTittle);
    }

    /**
     * Opens the page to create the workspace
     *
     * @return a WorkspaceForm object
     * @author Gustavo Huanca
     */
    public WorkspaceForm clickAddWorkspaceIcon() {
        webDriverActions.clickElement(addWorkspaceIcon);
        return new WorkspaceForm(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
