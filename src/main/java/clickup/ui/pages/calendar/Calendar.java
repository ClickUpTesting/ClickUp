/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.calendar;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calendar extends BasePage {
    @FindBy(css = "div[data-test='calendar-picker__done']")
    private WebElement closeButton;
    private String quickDataOptions = "//div[@class='cu-quick-date-options__item ng-star-inserted']//div[text()='%s']";

    public Calendar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Click in s quit data on calendar.
     *
     * @param dateWord is name of date
     * @author Gustavo Huanca
     */
    public void clickQuickDataOptions(final String dateWord) {
        webDriverActions.clickElement(By.xpath(String.format(quickDataOptions, dateWord)));
    }

    /**
     * Clicks on Close Button
     *
     * @author Gustavo Huanca
     */
    public void clickCloseButton() {
        webDriverActions.clickElement(closeButton);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
