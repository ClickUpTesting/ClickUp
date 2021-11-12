/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.list;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewColumn extends BasePage {
    @FindBy(xpath = "//button[@role='tab']")
    private WebElement tabs;
    private By enableButton = By.cssSelector("div.cu-btn.cu-btn_x-sm");
    private String textCustomField = "//div[@class='columns-list__item-name-text'][contains(.,'%s')]/../..";
    private static final int INTERVAL_TIME = 1000;

    public AddNewColumn(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks Enable button.
     *
     * @author Gustavo Huanca
     */
    public void clickEnableButton() {
        if (webDriverActions.isElementPresent(enableButton, INTERVAL_TIME)) {
            webDriverActions.clickElement(enableButton);
        }
    }

    /**
     * Clicks Rating text.
     *
     * @return a new object RatingForm
     * @author Gustavo Huanca
     */
    public RatingForm clickRating() {
        webDriverActions.clickElement(By.xpath(String.format(textCustomField, "Rating")));
        return new RatingForm(webDriverManager);
    }

    /**
     * Clicks Rating text.
     *
     * @return a new object RatingForm
     * @author Gustavo Huanca
     */
    public FormulaForm clickFormula() {
        webDriverActions.clickElement(By.xpath(String.format(textCustomField, "Formula")));
        return new FormulaForm(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    public void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(tabs);
    }
}
