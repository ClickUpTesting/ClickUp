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
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewSpacePage extends BasePage {
    @FindBy(css = ".cu-form__field input")
    private WebElement spaceNameTxtArea;

    @FindBy(css = ".cu-btn.cu-btn_m.cu-create-project-modal__next.ng-star-inserted")
    private WebElement nextButton;

    public CreateNewSpacePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets the space's name.
     *
     * @param spaceName a String with the value
     * @author Jorge Caceres
     */
    public void setSpaceName(final String spaceName) {
        webDriverElementText.setText(spaceNameTxtArea, spaceName);
    }

    /**
     * Clicks on the next button.
     *
     * @return a color or avatar page
     * @author Jorge Caceres
     */
    public ColorOrAvatarPage clickNextButton() {
        webDriverActions.clickElement(nextButton);
        return new ColorOrAvatarPage(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(nextButton);
    }
}
