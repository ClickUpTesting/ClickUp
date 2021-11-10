/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.sidebar.settings.workspaces;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspaceSetting extends BasePage {
    @FindBy(css = "button.cu-btn.cu-btn_danger-link")
    protected WebElement deleteWorkspaceButtonInSettingsLinkTxt;
    @FindBy(css = "div.cu-form__field input[placeholder]")
    protected WebElement workspaceNameTextBox;
    @FindBy(css = "div.cu-btn__text")
    protected WebElement savedButton;

    public WorkspaceSetting(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Click delete button to delete workspace
     *
     * @return a WorkspaceFormToDelete object
     * @author Gustavo Huanca
     */
    public WorkspaceFormToDelete clickDeleteWorkspaceButtonInSettingsLinkTxt() {
        webDriverActions.clickElement(deleteWorkspaceButtonInSettingsLinkTxt);
        return new WorkspaceFormToDelete(webDriverManager);
    }

    /**
     * Clicks in SAVED button.
     *
     * @author Gustavo Huanca
     */
    public void clickSavedButton() {
        webDriverActions.clickElement(savedButton);
    }

    /**
     * Types in name workspace textBox.
     *
     * @param nameWorkspace is the name of workspace
     * @author Gustavo Huanca
     */
    public void typeNameWorkspace(String nameWorkspace) {
        webDriverElementText.setText(workspaceNameTextBox, nameWorkspace);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(workspaceNameTextBox);
    }
}
