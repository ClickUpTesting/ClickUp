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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TagForm extends BasePage {
    @FindBy(css = "div[class='cu-search'] input")
    private WebElement tagTextArea;

    public TagForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets a tag name.
     *
     * @param tagName to be set
     * @return the tag form
     * @author Jorge Caceres
     */
    public TagForm setTagTextArea(final String tagName) {
        webDriverElementText.setText(tagTextArea, tagName);
        webDriverElementText.setText(tagTextArea, Keys.ENTER);
        return this;
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(tagTextArea);
    }
}
