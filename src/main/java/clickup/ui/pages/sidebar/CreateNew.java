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

public class CreateNew extends BasePage {
    @FindBy(css = "a[cutooltip='Create task']")
    protected WebElement newTaskButton;

    public CreateNew(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Click in New task.
     *
     * @return a TaskForm object
     * @author Gustavo Huanca
     */
    public TaskForm clickNewTask() {
        webDriverActions.clickElement(newTaskButton);
        return new TaskForm(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(newTaskButton);
    }
}
