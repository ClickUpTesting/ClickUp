/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {
    @FindBy(xpath = "//div[@class='cu-list-group__name']")
    private WebElement nameOfList;
    private By tasksList = By.cssSelector("span[class='cu-task-row-main__link-text-inner']");
    private String taskList = "//span[text() = '%s']";

    public ListPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
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
        webDriverWait.waitVisibilityOfElement(nameOfList);
    }
}
