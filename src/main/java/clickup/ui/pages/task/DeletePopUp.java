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

public class DeletePopUp extends BasePage {
    @FindBy(css = "button[class='cu-btn']")
    private WebElement deleteButton;

    public DeletePopUp(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks the Delete icon
     *
     * @return to the task page after delete a tag
     * @author Jorge Caceres
     */
    public TaskPage clickDeleteIcon() {
        webDriverActions.clickElement(deleteButton);
        return new TaskPage(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(deleteButton);
    }
}
