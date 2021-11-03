/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages;

import clickup.ui.pages.spaces.CreateNewSpacePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickUpMainPage extends BasePage {
    @FindBy(css = "div[data-test='create-space-btn']")
    private WebElement newSpace;
    @FindBy(css = "a[data-test='simple-sidebar-home-item']")
    private WebElement homeButton;
    private String sideBarSpace = "//a[normalize-space()='%s']";
    private String topBarSpace = "//div[contains(text(),'%s')]";

    public ClickUpMainPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the next button.
     *
     * @return a create space form
     * @author Jorge Caceres
     */
    public CreateNewSpacePage clickNewSpace() {
        webDriverActions.clickElement(newSpace);
        return new CreateNewSpacePage(webDriverManager);
    }

    /**
     * Verifies the spaces name if exists in the DOM.
     *
     * @param spaceName space to be verified
     * @return a boolean if a space exists
     * @author Jorge Caceres
     */
    public boolean verifySpaceName(final String spaceName) {
        By space = By.xpath(String.format(sideBarSpace, spaceName));
        return webDriverActions.isInDom(space);
    }

    /**
     * click a spaces by name.
     *
     * @param spaceName space to be clicked
     * @author Jorge Caceres
     */
    public void clickSpace(final String spaceName) {
        By space = By.xpath(String.format(sideBarSpace, spaceName));
        webDriverActions.clickElement(space);
        webDriverWait.waitRefreshedAndClickable(By.xpath(String.format(topBarSpace, spaceName)));
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(homeButton);
    }
}
