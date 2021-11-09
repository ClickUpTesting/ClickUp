/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages.topbar;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.ListSettingMenu;
import core.selenium.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListTopBar extends BasePage {
    @FindBy(css = ".cu-views-bar-title__container.ng-star-inserted")
    private WebElement listIcon;
    @FindBy(css = "div[class='cu-views-bar-title__list-btn-label'] cu-editable[class='cu-editable']")
    private WebElement listName;
    @FindBy(css = ".cu-editable.cu-editable_editing input")
    private WebElement listNameTxtArea;
    private ListSettingMenu listSettingMenu;

    public ListTopBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets the list settings menu
     *
     * @return a new list settings menu
     * @author Jorge Caceres
     */
    public ListSettingMenu getListSettingMenu() {
        return listSettingMenu;
    }

    /**
     * Clicks on the list name text.
     *
     * @author Jorge Caceres
     */
    public void clicksListName() {
        webDriverActions.clickElement(listName);
        listSettingMenu = new ListSettingMenu(webDriverManager);
    }

    /**
     * Updates the list name.
     *
     * @param newListName list name to be updated
     * @author Jorge Caceres
     */
    public void editListName(final String newListName) {
        webDriverElementText.cleartext(listNameTxtArea);
        webDriverElementText.setText(listNameTxtArea, newListName);
        webDriverElementText.setText(listNameTxtArea, Keys.TAB);
    }

    /**
     * Gets the list name.
     *
     * @return list name
     * @author Jorge Caceres
     */
    public String getListName() {
        webDriverWaits.waitRefreshedAndClickable(listName);
        return webDriverElementText.getWebElementText(listName);
    }

    /**
     * Waits until the page is loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(listIcon);
    }
}
