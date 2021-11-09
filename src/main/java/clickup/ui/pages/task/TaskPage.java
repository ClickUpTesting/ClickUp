/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.ui.pages.task;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage {
    @FindBy(css = ".cu-tags-view__icon.icon.ng-star-inserted")
    private WebElement addTagButton;
    @FindBy(css = "textarea[type='text']")
    protected WebElement nameTextBox;
    @FindBy(css = "div[data-test='task-close__icon']")
    protected WebElement closeIcon;
    @FindBy(css = "div[class*='cu-dropdown_center'] div[class*='cu-task-header__control']")
    protected WebElement taskSettingIcon;
    private TagForm tagForm;
    private TagSettings tagSettings;
    private String addedTag = "//div[@class='cu-tags-select__name'][normalize-space()='%s']";
    private String tagSettingsButton = "//div[@class='cu-tags-select__name-shadow'][normalize-space()='%s']";
    private By tagButton;
    @FindBy(css = "input[class='nav-editor__input ng-untouched ng-pristine ng-valid']")
    private WebElement filledTextArea;
    @FindBy(css = "input[class='nav-editor__input ng-untouched ng-valid ng-dirty']")
    private WebElement textAreaToFill;

    public TaskPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks in task setting.
     *
     * @return a new TaskSettings
     * @author Gustavo Huanca
     */
    public TaskSettings clickTaskSetting() {
        webDriverActions.clickElement(taskSettingIcon);
        return new TaskSettings(webDriverManager);
    }

    /**
     * Types in textBox.
     *
     * @param nameTask is the name of task
     * @author Gustavo Huanca
     */
    public void typeName(String nameTask) {
        webDriverElementText.cleartext(nameTextBox);
        webDriverElementText.setText(nameTextBox, nameTask);
    }

    /**
     * Clicks in close icon.
     *
     * @author Gustavo Huanca
     */
    public void clickCloseIcon() {
        webDriverActions.clickElement(closeIcon);
    }

    /**
     * Gets a tag form.
     *
     * @return Tag form
     * @author Jorge Caceres
     */
    public TagForm getTagForm() {
        return tagForm;
    }

    /**
     * Gets a tag settings menu.
     *
     * @return Tag Settings menu
     * @author Jorge Caceres
     */
    public TagSettings getTagSettings() {
        return tagSettings;
    }

    /**
     * Clicks on the add tag button.
     *
     * @author Jorge Caceres
     */
    public void clickAddTagButton() {
        webDriverActions.clickElement(addTagButton);
        tagForm = new TagForm(webDriverManager);
    }

    /**
     * Clicks a Tag.
     *
     * @param tagName tag to be clicked
     * @author Jorge Caceres
     */
    public void clickTag(final String tagName) {
        tagButton = By.xpath(String.format(tagSettingsButton, tagName));
        webDriverActions.clickElement(tagButton);
        tagSettings = new TagSettings(webDriverManager);
    }

    /**
     * Edits a Tag name.
     *
     * @param tagName newTagName to be set
     * @author Jorge Caceres
     */
    public void editTagName(final String tagName) {
        webDriverElementText.cleartext(filledTextArea);
        webDriverElementText.setText(textAreaToFill, tagName);
        webDriverElementText.setText(textAreaToFill, Keys.TAB);
    }

    /**
     * Verifies the tag name if exists in the DOM.
     *
     * @param tagName to be verified
     * @return a boolean true if the tag exists
     * @author Jorge Caceres
     */
    public boolean verifySpaceName(final String tagName) {
        return webDriverActions.isInDom(By.xpath(String.format(addedTag, tagName)));
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(addTagButton);
    }
}
