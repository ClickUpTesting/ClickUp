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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoveOption extends BasePage {
    @FindBy(xpath = "//div[@class='nav-menu__group']//a[@class='nav-menu-item']")
    private WebElement moveListOption;
    @FindBy(css = ".cu-nav-project__toggle.cu-nav-project__toggle-create-task.cu-dropdown__toggle")
    private WebElement spaceDropDownLists;
    @FindBy(xpath = "//button[@class='cu-btn']//div[@class='cu-btn__text']")
    private WebElement moveButton;
    private String spaceOfDropDownSpaceLists = "//a[@class='cu-project-list__link'][normalize-space()='%s']";
    private String selectAFolder = "//div[@class='category-list__cat-name']//span[normalize-space()='%s']";

    public MoveOption(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on Move List.
     *
     * @author Gustavo Huanca
     */
    public void clickMoveList() {
        webDriverActions.clickElement(moveListOption);
    }

    /**
     * Clicks SPACE DropDownList.
     * Move List form
     *
     * @author Gustavo Huanca
     */
    public void clickDropDownSpaceLists() {
        webDriverActions.clickElement(spaceDropDownLists);
    }

    /**
     * Click Move Button.
     * Move List form
     *
     * @author Gustavo Huanca
     */
    public void clickMoveButton() {
        webDriverActions.clickElement(moveButton);
    }

    /**
     * Selects a Space on SPACE DropDownList.
     * Move List form
     *
     * @param nameSpace is name of space
     * @author Gustavo Huanca
     */
    public void selectASpaceOfDropDownSpaceLists(final String nameSpace) {
        webDriverActions.clickElement(By.xpath(String.format(spaceOfDropDownSpaceLists, nameSpace)));
    }

    /**
     * Select a folder to move.
     * Move List form
     *
     * @param nameFolder is name of folder
     * @author Gustavo Huanca
     */
    public void selectAFolder(final String nameFolder) {
        webDriverActions.clickElement(By.xpath(String.format(selectAFolder, nameFolder)));
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
