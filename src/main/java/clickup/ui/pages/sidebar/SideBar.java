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
import core.selenium.driveractions.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SideBar extends BasePage {
    @FindBy(css = "div[data-test='user-settings-dropdown-toggle']")
    protected WebElement userSettingDropdown;
    protected String selectSpace = "//a[normalize-space()='%s']";
    protected String folderTextLink = "//span[normalize-space()='Folder']";
    protected String selectFolderInSpace = selectSpace.concat("/../../../.."
            + "//*[contains(@class,'nav-category__name-text')]");

    public SideBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets a list of folder's name in a space.
     *
     * @param nameSpace is name of space
     * @return a list of folder's name
     */
    public List<String> getFoldersInASpace(String nameSpace) {
        List<WebElement> webElementList = webDriverActions.getWebElements(By.xpath(String.format(selectFolderInSpace, nameSpace)));
        List<String> list = new ArrayList<>();
        webElementList.forEach(webElement2 -> list.add(webDriverElementText.getWebElementText(webElement2)));
        return list;
    }

    /**
     * Click in a space
     *
     * @param nameSpace is the name of space
     */
    public void clickInASpace(String nameSpace) {
        webDriverActions.clickElement(By.xpath(String.format(selectSpace, nameSpace)));
    }

    /**
     * Click on a folder in a space
     *
     * @param nameSpace is name of space
     */
    public void clickFolderInSpace(String nameSpace) {
        webDriverActions.clickElement(By.xpath(String.format(selectFolderInSpace, nameSpace)));
    }

    /**
     * Click Folder link text in a space.
     *
     * @return a object type FolderForm
     */
    public FolderForm clickFolderTextLink(){
        webDriverActions.clickElement(By.xpath(folderTextLink));
        return new FolderForm(webDriverManager);
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
