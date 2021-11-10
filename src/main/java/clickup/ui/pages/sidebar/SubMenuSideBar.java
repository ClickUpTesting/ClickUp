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
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceSetting;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenuSideBar extends BasePage {
    @FindBy(css = "a.ng-star-inserted[data-test='user-settings-menu-item-my-settings']")
    protected WebElement mySettingLinkTxt;
    @FindBy(xpath = "//a[@data-test='workspace-settings-menu-item-settings']")
    protected WebElement workspaceSettingTxt;
    @FindBy(css = "div[data-test*='column-title-name'][tooltipmodifier]")
    protected WebElement workSpaceTittle;

    @FindBy(xpath = "//div[@class='cu-user-settings-menu-v2__workspaces-add-plus icon']")
    protected WebElement addWorkspaceIcon;

    public SubMenuSideBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets workspace name.
     *
     * @return a string with name of workspace
     * @author Gustavo Huanca
     */
    public String getWorkSpaceTittle() {
        return webDriverElementText.getWebElementText(workSpaceTittle);
    }

    /**
     * Clicks in my setting of ClickUp.
     *
     * @return a Settings object
     * @author Gustavo Huanca
     */
    public Settings clickMySettingLinkTxt() {
        webDriverActions.clickElement(mySettingLinkTxt);
        return new Settings(webDriverManager);
    }

    /**
     * Clicks in setting of workspace.
     *
     * @return a WorkspaceSetting object
     * @author Gustavo Huanca
     */
    public WorkspaceSetting clickWorkspaceSettingTxt() {
        webDriverActions.clickElement(workspaceSettingTxt);
        return new WorkspaceSetting(webDriverManager);
    }

    /**
     * Opens the page to create the workspace.
     *
     * @return a WorkspaceForm object
     * @author Gustavo Huanca
     */
    public WorkspaceForm clickAddWorkspaceIcon() {
        webDriverActions.clickElement(addWorkspaceIcon);
        return new WorkspaceForm(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(mySettingLinkTxt);
    }
}
