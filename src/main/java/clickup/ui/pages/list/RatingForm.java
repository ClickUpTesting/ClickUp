/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.list;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RatingForm extends BasePage {
    @FindBy(css = "div.cu-custom-fields__form-input-container input[placeholder]")
    private WebElement fieldNameTextBox;

    @FindBy(css = "button.cu-btn.cu-btn_sm.ng-star-inserted.cu-btn_spinner")
    private WebElement addColumnButton;

    public RatingForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Types a name to rating.
     *
     * @param nameRatingColumn is name of rating
     * @author Gustavo Huanca
     */
    public void typeFieldName(String nameRatingColumn) {
        webDriverElementText.setText(fieldNameTextBox, nameRatingColumn);
    }

    /**
     * Clicks in Add Column button.
     *
     * @author Gustavo Huanca
     */
    public void clickAddColumnButton() {
        webDriverActions.clickElement(addColumnButton);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(fieldNameTextBox);
    }
}
