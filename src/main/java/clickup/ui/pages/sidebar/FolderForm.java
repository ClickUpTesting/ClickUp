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

public class FolderForm extends BasePage {
    @FindBy(css = "cu-create-category input[placeholder]")
    protected WebElement folderNameTextBox;

    @FindBy(css = "button [class='cu-btn__text']")
    protected WebElement createFolderButton;

    public FolderForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets the name of folder.
     *
     * @param nameFolder is the name of the folder
     * @author Gustavo Huanca
     */
    public void setNameFolder(String nameFolder) {
        webDriverElementText.setText(folderNameTextBox, nameFolder);
    }

    /**
     * Clicks in Create Folder button.
     *
     * @author Gustavo Huanca
     */
    public void clickCreateFolderButton() {
        webDriverActions.clickElement(createFolderButton);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(folderNameTextBox);
    }
}
