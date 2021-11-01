/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.sidebar.settings;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.sidebar.settings.workspaces.Workspaces;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Settings extends BasePage {
    @FindBy(css = ".cu-nav-sts__link[routerlink='teams']")
    protected WebElement workspacesLinkTxt;

    @FindBy(css = "a[href*='general']")
    protected WebElement settingsLinkTxt;

    @FindBy(css = "button.cu-btn.cu-btn_danger-link")
    protected WebElement deleteWorkspaceButtonInSettingsLinkTxt;

    @FindBy(css = "input[class*='cu-dc__input cu-dc__input_team']")
    protected WebElement deleteWorkspaceTxtBox;

    @FindBy(css = "div.cu-dc__subtitle")
    protected WebElement workspaceToDeleteTxt;

    @FindBy(css = "button[class='cu-btn cu-btn_fw-sm']")
    protected WebElement deleteWorkspaceButtonToDelete;

    public Settings(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    /***
     * Clicks in workspaces in my settings page.
     *
     * @return a new object Workspaces
     * @author Gustavo Huanca
     */
    public Workspaces clickWorkspacesLinkTxt() {
        webDriverActions.clickElement(workspacesLinkTxt);
        return new Workspaces(webDriverManager);
    }

    /**
     * Clicks in settings of workspace.
     *
     * @author Gustavo Huanca
     */
    public void clickSettingsLinkTxt() {
        webDriverActions.clickElement(settingsLinkTxt);
    }

    /**
     * Gets name of workspace to delete
     * Settings < Settings (workspace) < Delete Workspace button < Workspace deletion form
     *
     * @return is String with name of workspace
     * @author Gustavo Huanca
     */
    public String getWorkspaceToDeleteTxt() {
       return webDriverElementText.getWebElementText(workspaceToDeleteTxt);
    }

    /**
     * Types or fills up workspace name to delete
     * Settings < Settings (workspace) < Delete Workspace button < Workspace deletion form
     *
     * @param nameWorkspaceToDelete is name of workspace will be deleted
     * @author Gustavo Huanca
     */
    public void fillUpDeleteWorkspaceTxtBox(String nameWorkspaceToDelete) {
        webDriverElementText.setText(deleteWorkspaceTxtBox, nameWorkspaceToDelete);
    }

    /**
     * Click delete button to delete workspace
     * Settings < Settings (workspace) < Delete Workspace button < Workspace deletion form
     *
     * @author Gustavo Huanca
     */
    public void clickDeleteWorkspaceButtonToDelete() {
        webDriverActions.clickElement(deleteWorkspaceButtonToDelete);
    }

    /**
     * Click delete button to delete workspace
     * Settings < Settings (workspace)
     *
     * @author Gustavo Huanca
     */
    public void clickDeleteWorkspaceButtonInSettingsLinkTxt() {
        webDriverActions.clickElement(deleteWorkspaceButtonInSettingsLinkTxt);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
