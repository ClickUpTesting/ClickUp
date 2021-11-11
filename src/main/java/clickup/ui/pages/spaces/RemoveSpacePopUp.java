/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages.spaces;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.sidebar.SideBar;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemoveSpacePopUp extends BasePage {
    @FindBy(css = ".cu-dc__input.ng-untouched.ng-pristine.ng-valid")
    private WebElement spaceNameTextArea;
    @FindBy(css = "button[class='cu-btn cu-btn_fw-sm'] div[class='cu-btn__text']")
    private WebElement deleteButton;

    public RemoveSpacePopUp(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Types the space name to confirm delete.
     *
     * @param spaceName to be deleted
     * @author Jorge Caceres
     */
    public void fillSpaceName(final String spaceName) {
        webDriverElementText.setText(spaceNameTextArea, spaceName);
    }

    /**
     * clicks the delete button.
     *
     * @return to a sidebar
     * @author Jorge Caceres
     */
    public SideBar clickDelete() {
        webDriverActions.clickElement(deleteButton);
        return new SideBar(webDriverManager);
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
