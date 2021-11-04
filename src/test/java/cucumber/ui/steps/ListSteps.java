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
    ClickUpMainPage clickUpMainPage;
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
}
