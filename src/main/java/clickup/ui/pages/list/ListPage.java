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
import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {
    @FindBy(xpath = "//div[@class='cu-list-group__name']")
    protected WebElement nameOfList;
    @FindBy(css = "button[class*='cu-task-list-header-settings'][class*='add_right-btn']")
    protected WebElement addNewColumnIcon;
    protected By iconStarsToRanting = By.xpath("//div[@class='cu-emoji-custom-field-value__container']");
    protected By iconFormulaFx = By.xpath("//div[@class='cu-custom-field-type-formula__fx icon ng-star-inserted']");
    protected By nameColumnOfTaskInStatus = By.xpath("//div[@class='cu-task-list-header-field__title-text']"
            + "[normalize-space()]");
    protected By tasksList = By.cssSelector("span[class='cu-task-row-main__link-text-inner']");
    protected String taskList = "//span[text() = '%s']";
    private static final int INTERVAL_TIME = 1000;

    public ListPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Verifies the Stars icon exist.
     *
     * @return a boolean
     * @author Gustavo Huanca
     */
    public boolean isDisplayedRantingStars() {
        return webDriverActions.isElementPresent(iconStarsToRanting, INTERVAL_TIME);
    }

    /**
     * Verifies the Fx icon exist
     *
     * @return a boolean
     * @author Gustavo Huanca
     */
    public boolean isDisplayedFormulaIcon() {
        return webDriverActions.isElementPresent(iconFormulaFx, INTERVAL_TIME);
    }

    /**
     * Gets column's name in the status.
     *
     * @return a list with column's name
     * @author Gustavo Huanca
     */
    public List<String> getNameColumnsOfTaskInStatus() {
        webDriverActions.refreshPage();
        return webDriverActions.getStringsOfElements(nameColumnOfTaskInStatus);
    }

    /**
     * Clicks in tab add a New Column
     *
     * @return a new object AddNewColumn
     * @author Gustavo Huanca
     */
    public AddNewColumn clickAddNewColumnIcon() {
        webDriverActions.clickElement(addNewColumnIcon);
        return new AddNewColumn(webDriverManager);
    }

    /**
     * Clicks a task in a list.
     *
     * @param nameTask a name of task
     * @author Gustavo Huanca
     */
    public void clickATask(final String nameTask) {
        webDriverActions.clickElement(By.xpath(String.format(taskList, nameTask)));
    }

    /**
     * Gets a list of task.
     *
     * @return a list with task name
     * @author Gustavo Huanca
     */
    public List<String> getTasks() {
        List<WebElement> webElementList = webDriverActions.getWebElements(tasksList);
        List<String> list = new ArrayList<>();
        webElementList.forEach(element -> list.add(webDriverElementText.getWebElementText(element)));
        return list;
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(nameOfList);
    }
}
