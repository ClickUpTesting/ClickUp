/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.ui.steps;

import clickup.ui.pages.ClickUpMainPage;
import clickup.ui.pages.sidebar.ListForm;
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.topbar.ListTopBar;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.util.Map;

public class ListSteps {
    private WebDriverManager webDriverManager;
    private ScenarioTrash scenarioTrash;
    private Map<String, String> listSettings;
    private ClickUpMainPage clickUpMainPage;
    private ListTopBar listTopBar;
    private SoftAssert softAssert;

    public ListSteps(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash, SoftAssert softAssert) {
        this.webDriverManager = webDriverManager;
        this.scenarioTrash = scenarioTrash;
        this.softAssert = softAssert;
    }

    @When("I create a list with the following parameters")
    public void createListWithDefaultSettings(Map<String, String> settingsMap) {
        listSettings = settingsMap;
        SideBar sideBar = new SideBar(webDriverManager);
        sideBar.clickInASpace(scenarioTrash.getTrashValue("name_space"));
        ListForm listForm = sideBar.clickListTextLink();
        listForm.setListName(listSettings.get("name"));
        clickUpMainPage = listForm.clickCreateListButton();

    }

    @Then("I verify that the created list contains the default values")
    public void verifyDefaultListSettings() {
        softAssert.assertTrue(clickUpMainPage.getSideBar().verifyListName(listSettings.get("name")));
    }

    @When("I update a list with the following parameters")
    public void updateListSettings(Map<String, String> settingsMap) {
        listSettings = settingsMap;
        listTopBar = new ListTopBar(webDriverManager);
        listTopBar.clicksListName();
        listTopBar.getListSettingMenu().clickEditButton();
        listTopBar.editListName(listSettings.get("name"));
    }

    @Then("I verify that the list contains the default values")
    public void verifyListSettings() {
        softAssert.assertEquals(listTopBar.getListName(), listSettings.get("name"));
    }

    @When("I delete a list")
    public void deleteList() {
        listTopBar = new ListTopBar(webDriverManager);
        listTopBar.clicksListName();
        listTopBar.getListSettingMenu().clickDeleteButton();
    }

    @Then("I verify that the list does not exist in the space")
    public void verifyDeletedList() {
        SideBar sideBar = new SideBar(webDriverManager);
        softAssert.assertFalse(sideBar.verifyListName(scenarioTrash.getTrashValue("list_name")));
    }
}
