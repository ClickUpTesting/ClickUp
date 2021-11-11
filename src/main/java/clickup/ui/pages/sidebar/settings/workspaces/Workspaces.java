/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.sidebar.settings.workspaces;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Workspaces extends BasePage {
    @FindBy(css = "div[class='team-list-item__icon']")
    protected WebElement addNewButton;
    protected By listNameWorkspace = By.xpath("//div[@class='team-list-item__name'][normalize-space()]");

    public Workspaces(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks in Add new button.
     *
     * @return go to page form
     * @author Gustavo Huanca
     */
    public WorkspaceForm clickAddNewIcon() {
        webDriverActions.clickElement(addNewButton);
        return new WorkspaceForm(webDriverManager);
    }

    /**
     * Gets a list of workspace.
     *
     * @return a list with a name of workspace
     * @author Gustavo Huanca
     */
    public List<String> getNamesWorkspace(){
        List<WebElement> webElementList = webDriverActions.getWebElements(listNameWorkspace);
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
        webDriverWaits.waitVisibilityOfElement(addNewButton);
    }
}
