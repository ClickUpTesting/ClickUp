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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage {
    @FindBy(css = ".cu-tags-view__icon.icon.ng-star-inserted")
    private WebElement addTagButton;
    @FindBy(css = "textarea[type='text']")
    protected WebElement nameTextBox;
    @FindBy(css = "div[data-test='task-close__icon']")
    protected WebElement closeIcon;
    private TagForm tagForm;
    private String addedTag = "//div[@class='cu-tags-select__name'][normalize-space()='%s']";


    public TaskPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
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
    public void clickCloseIcon(){
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
     * Clicks on the add tag button.
     *
     * @author Jorge Caceres
     */
    public void clickAddTagButton() {
        webDriverActions.clickElement(addTagButton);
        tagForm = new TagForm(webDriverManager);
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
        webDriverWait.waitVisibilityOfElement(addTagButton);
    }
}
