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

public class TaskForm extends BasePage {
    @FindBy(css = "textarea[placeholder]")
    protected WebElement taskNameTextBox;

    @FindBy(css = "div[data-test='draft-view__submit-btn_createTask']")
    protected WebElement createTaskButton;

    public TaskForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets a name of task in text box.
     *
     * @param nameTask is name of task
     * @author Gustavo Huanca
     */
    public void setTaskName(String nameTask) {
        webDriverElementText.setText(taskNameTextBox, nameTask);
    }

    /**
     * Clicks in Create Task button.
     *
     * @author Gustavo Huanca
     */
    public void clickCreateTaskButton() {
        webDriverActions.clickElement(createTaskButton);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(createTaskButton);
    }
}
