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
import clickup.ui.pages.ClickUpMainPage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllGoodPage extends BasePage {
    @FindBy(css = ".cu-btn.cu-btn_m.cu-create-project-modal__next.ng-star-inserted")
    private WebElement createSpaceButton;

    public AllGoodPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the next button.
     *
     * @return click up main page
     * @author Jorge Caceres
     */
    public ClickUpMainPage clickCreateSpaceButton() {
        webDriverActions.clickElement(createSpaceButton);
        return new ClickUpMainPage(webDriverManager);
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
