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
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceSetting;
import clickup.ui.pages.sidebar.settings.workspaces.Workspaces;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Settings extends BasePage {
    @FindBy(css = ".cu-nav-sts__link[routerlink='teams']")
    protected WebElement workspacesLinkTxt;

    @FindBy(css = "a[href*='general']")
    protected WebElement settingsLinkTxt;

    @FindBy(css = "a[data-test='settings-back-btn']")
    protected WebElement backButton;

    public Settings(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks BACK button.
     *
     * @author Gustavo Huanca
     */
    public void clickBackButton() {
        webDriverActions.clickElement(backButton);
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
     * @return a new object WorkspaceSetting
     * @author Gustavo Huanca
     */
    public WorkspaceSetting clickSettingsLinkTxt() {
        webDriverActions.clickElement(settingsLinkTxt);
        return new WorkspaceSetting(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(settingsLinkTxt);
    }
}
