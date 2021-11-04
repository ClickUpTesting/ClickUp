/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages.sidebar;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.ClickUpMainPage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListForm extends BasePage {
    @FindBy(css = "div[class='simple-input-modal__body'] input[type = 'text']")
    protected WebElement listNameTextBox;
    @FindBy(css = ".simple-input-modal__button.simple-input-modal__button-submit")
    protected WebElement createListButton;

    public ListForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets the List's name.
     *
     * @param listName is the name of the list
     * @author Jorge Caceres
     */
    public void setListName(String listName) {
        webDriverElementText.setText(listNameTextBox, listName);
    }

    /**
     * Clicks in Create List button.
     *
     * @return a new click up main page
     * @author Jorge Caceres
     */
    public ClickUpMainPage clickCreateListButton() {
        webDriverActions.clickElement(createListButton);
        return new ClickUpMainPage(webDriverManager);
    }

    /**
     * Waits until the page is loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(createListButton);
    }
}
