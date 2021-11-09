/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.topbar;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.sidebar.FeatureSettings;
import core.selenium.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FolderTopBar extends BasePage {
    @FindBy(css = ".cu-views-bar-title__container.ng-star-inserted")
    private WebElement listIcon;
    @FindBy(css = "div.cu-views-bar-title__label-text.ng-star-inserted")
    private WebElement folderName;
    @FindBy(css = ".cu-editable.cu-views-bar-title__label-inner input")
    private WebElement folderNameTxtArea;

    public FolderTopBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the folder name text.
     *
     * @return a new object FeatureSettings
     * @author Gustavo Huanca
     */
    public FeatureSettings clicksFolderName() {
        webDriverActions.clickElement(folderName);
        return new FeatureSettings(webDriverManager);
    }

    /**
     * Updates the folder name.
     *
     * @param newListName folder name to be updated
     * @author Gustavo Huanca
     */
    public void editFolderName(final String newListName) {
        webDriverElementText.cleartext(folderNameTxtArea);
        webDriverElementText.setText(folderNameTxtArea, newListName);
        webDriverElementText.pressKeyboard(folderNameTxtArea, Keys.TAB);
    }

    /**
     * Gets the folder name.
     *
     * @return a string with name of folder
     * @author Gustavo Huanca
     */
    public String getFolderName() {
        webDriverWaits.waitRefreshedAndClickable(folderName);
        return webDriverElementText.getWebElementText(folderName);
    }

    /**
     * Waits until the page is loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(folderName);
    }
}
