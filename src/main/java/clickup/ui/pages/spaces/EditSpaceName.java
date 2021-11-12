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

public class EditSpaceName extends BasePage {
    @FindBy(xpath = "//input[@data-test='create-space-name-input']")
    protected WebElement spaceNameTextBox;
    @FindBy(xpath = "//button[normalize-space()]")
    protected WebElement saveButton;

    public EditSpaceName(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Types the name of space.
     *
     * @param nameSpace is name's space
     * @author Gustavo Huanca
     */
    public void typeNameSpace(String nameSpace) {
        webDriverElementText.setText(spaceNameTextBox, nameSpace);
    }

    /**
     * Clicks in Save button.
     *
     * @author Gustavo Huanca
     */
    public void clickSaveButton() {
        webDriverActions.clickElement(saveButton);
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
