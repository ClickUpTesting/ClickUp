/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */
package clickup.ui.pages;

import clickup.ui.pages.spaces.RemoveSpacePopUp;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpaceSettingsMenu extends BasePage {
    @FindBy(css = "div[data-test='nav-menu-item__name']")
    protected WebElement deleteIcon;

    public SpaceSettingsMenu(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the edit button.
     *
     * @return a popup to edit the space's name
     * @author Jorge Caceres
     */
    public RemoveSpacePopUp clickDeleteButton() {
        webDriverActions.clickElement(deleteIcon);
        return new RemoveSpacePopUp(webDriverManager);
    }


    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(deleteIcon);
    }
}
