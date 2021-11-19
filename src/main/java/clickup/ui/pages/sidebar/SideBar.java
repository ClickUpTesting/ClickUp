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
import clickup.ui.pages.spaces.CreateNewSpacePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class SideBar extends BasePage {
    @FindBy(css = "cu-user-settings-menu[class*='cu-simple-bar__bottom-menu']")
    protected WebElement userSettingDropdown;
    @FindBy(css = "a[data-test='simple-sidebar-home-item']")
    protected WebElement homeButton;
    @FindBy(xpath = "//cu-nav-section[@class='cu-nav-section cu-nav-section_active']"
            + "//div[@data-test='list-settings-toggle-btn']")
    protected WebElement selectListSetting;
    @FindBy(css = "div[data-test='create-space-btn']")
    protected WebElement newSpaceButton;
    protected String selectSpace = "//a[normalize-space()='%s']";
    protected String folderTextLink = "//span[normalize-space()='Folder']";
    protected String listTextLink = "//span[normalize-space()='List']";
    protected String selectList = "//div[@class='cu-nav-section__name-text'][normalize-space()='%s']";
    protected String selectFolderInSpace = selectSpace.concat("/../../../.."
            + "//*[contains(@class,'nav-category__name-text')]");
    protected String nameFolderText = "//cu-nav-category[@data-source='folder']//div[contains(.,'%s')]"
            + "//*[contains(@class,'nav-category__name-text')]";
    protected String selectFolderSetting = "//cu-nav-category[@data-source='folder']//div[contains(.,'%s')]"
            + "//div[@data-test='dropdown__toggle']";
    protected String getListOnFolder = "//*[contains(@class,'nav-category__name-text')][contains(text(),'%s')]/../../.."
            + "//div[@class='cu-nav-section__name-text']";
    private static final int INTERVAL_TIME = 2000;

    public SideBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets a list on a folder.
     *
     * @param folderName is name of folder
     * @return a List< String > with name of list
     * @author Gustavo Huanca
     */
    public List<String> getListInFolder(String folderName) {
        By listsInFolder = By.xpath(String.format(getListOnFolder, folderName));
        return webDriverActions.getStringsOfElements(listsInFolder);
    }

    /**
     * Clicks on a folder.
     *
     * @param nameFolder is name of folder
     * @author Gustavo Huanca
     */
    public void clickFolder(String nameFolder) {
        webDriverActions.clickElement(By.xpath(String.format(nameFolderText, nameFolder)));
    }

    /**
     * Gets a list of folder's name in a space.
     *
     * @param nameSpace is name of space
     * @return a list of folder's name
     * @author Gustavo Huanca
     */
    public List<String> getFoldersInASpace(String nameSpace) {
        List<WebElement> webElementList = webDriverActions.getWebElements(By.xpath(
                String.format(selectFolderInSpace, nameSpace)));
        List<String> list = new ArrayList<>();
        webElementList.forEach(webElement2 -> list.add(webDriverElementText.getWebElementText(webElement2)));
        return list;
    }

    /**
     * Clicks in a space.
     *
     * @param nameSpace is the name of space
     * @author Gustavo Huanca
     */
    public void clickInASpace(String nameSpace) {
        webDriverActions.clickElement(By.xpath(String.format(selectSpace, nameSpace)));
        webDriverWaits.waitRefreshedAndClickable(By.xpath(String.format(selectSpace, nameSpace)));
    }

    /**
     * Clicks on a folder in a space.
     *
     * @param nameSpace is name of space
     * @author Gustavo Huanca
     */
    public void clickFolderInSpace(String nameSpace) {
        webDriverActions.clickElement(By.xpath(String.format(selectFolderInSpace, nameSpace)));
    }

    /**
     * Clicks on a list.
     *
     * @param nameList is name of list
     * @author Gustavo Huanca
     */
    public void clickInAList(String nameList) {
        webDriverActions.clickElement(By.xpath(String.format(selectList, nameList)));
    }

    /**
     * Clicks in Add icon in a list.
     *
     * @return an object type FeatureSettings
     * @author Gustavo Huanca
     */
    public FeatureSettings clickInSettingList() {
        webDriverActions.clickElement(selectListSetting);
        return new FeatureSettings(webDriverManager);
    }

    /**
     * Clicks in ... icon in a folder.
     *
     * @param nameFolder is name folder
     * @return an object type FeatureSettings
     * @author Gustavo Huanca
     */
    public FeatureSettings clickInSettingFolder(String nameFolder) {
        webDriverActions.clickElement(By.xpath(String.format(selectFolderSetting, nameFolder)));
        return new FeatureSettings(webDriverManager);
    }

    /**
     * Clicks Folder link text in a space.
     *
     * @return a object type FolderForm
     * @author Gustavo Huanca
     */
    public FolderForm clickFolderTextLink() {
        webDriverActions.clickElement(By.xpath(folderTextLink));
        return new FolderForm(webDriverManager);
    }

    /**
     * Clicks List link text in a space.
     *
     * @return a ListForm
     * @author Jorge Caceres
     */
    public ListForm clickListTextLink() {
        webDriverActions.clickElement(By.xpath(listTextLink));
        return new ListForm(webDriverManager);
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

    /**
     * Clicks on the new Space button and opens the create space form.
     *
     * @return a create space form
     * @author Jorge Caceres
     */
    public CreateNewSpacePage clickNewSpaceButton() {
        webDriverActions.clickElement(newSpaceButton);
        return new CreateNewSpacePage(webDriverManager);
    }

    /**
     * Verifies the spaces name if exists in the DOM.
     *
     * @param spaceName space to be verified
     * @return a boolean true if a space exists
     * @author Jorge Caceres
     */
    public boolean verifySpaceName(final String spaceName) {
        return webDriverActions.isElementPresent(By.xpath(String.format(selectSpace, spaceName)), INTERVAL_TIME);
    }

    /**
     * Verifies the list's name if exists in the DOM.
     *
     * @param listName to be verified
     * @return a boolean true if a list exists
     * @author Jorge Caceres
     */
    public boolean verifyListName(final String listName) {
        return webDriverActions.isElementPresent(By.xpath(String.format(selectList, listName)), INTERVAL_TIME);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(homeButton);
    }
}
