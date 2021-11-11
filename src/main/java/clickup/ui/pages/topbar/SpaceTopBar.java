/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages.topbar;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.sidebar.SpaceSettingsMenu;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpaceTopBar extends BasePage {
    @FindBy(css = ".cu-project-avatar__item.cu-avatar.cu-project-avatar__text.cu-project-avatar__"
            + "text_no-project-color.cu-project-avatar__text_bg.ng-star-inserted")
    private WebElement spaceIcon;
    private String spaceNameButton = "//div[contains(text(),'%s')]";
    private SpaceSettingsMenu spaceSettingsMenu;


    public SpaceTopBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Get the space settings menu.
     *
     * @return space settings menu
     * @author Jorge Caceres
     */
    public SpaceSettingsMenu getSpaceSettingsMenu() {
        return spaceSettingsMenu;
    }

    /**
     * Clicks on the space name text.
     *
     * @param spaceName to be clicked
     * @author Jorge Caceres
     */
    public void clicksSpaceName(final String spaceName) {
        webDriverActions.clickElement(By.xpath(String.format(spaceNameButton, spaceName)));
        spaceSettingsMenu = new SpaceSettingsMenu(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(spaceIcon);
    }
}
