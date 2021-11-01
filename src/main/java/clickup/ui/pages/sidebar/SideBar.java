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
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBar extends BasePage {
    @FindBy(css = "div[data-test='user-settings-dropdown-toggle']")
    protected WebElement userSettingDropdown;

    public SideBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Opens a setting of workspace in sidebar.
     *
     * @return a new panel with new options to workspace (subMenuSideBar)
     * @author Gustavo Huanca
     */
    public SubMenuSideBar clickUserSettingDropdown() {
        webDriverActions.clickElement(userSettingDropdown);
        return new SubMenuSideBar(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(userSettingDropdown);
    }
}
