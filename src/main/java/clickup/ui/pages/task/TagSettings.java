/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages.task;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TagSettings extends BasePage {
    @FindBy(xpath = "//div[normalize-space()='Rename']")
    private WebElement renameButton;
    @FindBy(css = ".nav-menu-item__icon.nav-menu-item__icon_delete.icon")
    private WebElement deleteButton;

    public TagSettings(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * click the rename button.
     *
     * @author Jorge Caceres
     */
    public void clickRenameButton() {
        webDriverActions.clickElement(renameButton);
    }

    /**
     * Clicks the Delete icon
     *
     * @author Jorge Caceres
     */
    public DeletePopUp clickDeleteIcon() {
        webDriverActions.clickElement(deleteButton);
        return new DeletePopUp(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(renameButton);
    }
}
