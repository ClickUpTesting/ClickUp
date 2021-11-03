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

public class ViewsSettingsPage extends BasePage {
    @FindBy(css = ".cu-btn.cu-btn_m.cu-create-project-modal__next.ng-star-inserted")
    private WebElement reviewSpaceButton;

    public ViewsSettingsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the next button.
     *
     * @return All good page
     * @author Jorge Caceres
     */
    public AllGoodPage clickReviewSpaceButton() {
        webDriverActions.clickElement(reviewSpaceButton);
        return new AllGoodPage(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {

    }
}
