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

public class FeatureSettings extends BasePage {
    @FindBy(css = "div[class='nav-menu__group ng-star-inserted'] div[class='cu-dropdown'] a[class='nav-menu-item']")
    protected WebElement createNewButton;

    public FeatureSettings(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks in Create new
     *
     * @return a CreateNew object
     * @author Gustavo Huanca
     */
    public CreateNew clickCreateNew() {
        webDriverActions.clickElement(createNewButton);
        return new CreateNew(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
