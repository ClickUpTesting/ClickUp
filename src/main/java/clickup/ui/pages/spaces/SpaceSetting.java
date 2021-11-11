/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.spaces;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpaceSetting extends BasePage {
    @FindBy(xpath = "//button[@aria-label='Rename']")
    protected WebElement renameIcon;

    public SpaceSetting(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks Rename Icon.
     *
     * @return a new EditSpaceName
     * @author Gustavo Huanca
     */
    public EditSpaceName clickRenameIcon() {
        webDriverActions.clickElement(renameIcon);
        return new EditSpaceName(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
