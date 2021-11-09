/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.task;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskSettings extends BasePage {
    @FindBy(css = "a[tooltipmodifier] div[class*=icon_remove]")
    private WebElement deleteIcon;

    public TaskSettings(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks in Delete icon
     *
     * @author Gustavo Huanca
     */
    public void clickDeleteIcon() {
        webDriverActions.clickElement(deleteIcon);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(deleteIcon);
    }
}
