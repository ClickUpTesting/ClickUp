/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.ui.steps;

import clickup.ui.pages.ClickUpMainPage;
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.sidebar.SubMenuSideBar;
import clickup.ui.pages.sidebar.settings.Settings;
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceForm;
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceSetting;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class WorkspaceSteps {
    private WebDriverManager webDriverManager;
    private SideBar sideBar;
    private Map<String, String> bodyWorkspaceForm;
    private SoftAssert softAssert;
    private ScenarioTrash scenarioTrash;
    private ClickUpMainPage clickUpMainPage;

    public WorkspaceSteps(WebDriverManager webDriverManager, SoftAssert softAssert, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @And("I create a new workspace with field")
    public void createANewWithField(final Map<String, String> bodyWorkspaceForm) {
        scenarioTrash.setScenarioTrash("workspace_name", bodyWorkspaceForm.get("name"));
        this.bodyWorkspaceForm = bodyWorkspaceForm;
        clickUpMainPage = new ClickUpMainPage(webDriverManager);
        sideBar = clickUpMainPage.getSideBar();
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        WorkspaceForm workspaceForm = subMenuSideBar.clickAddWorkspaceIcon();
        workspaceForm.fillUpWorkspaceForm(bodyWorkspaceForm.get("name"));
    }

    @Then("I verify that the created workspace contains the default values")
    public void verifyThatTheCreatedContainsTheDefaultValues() {
        clickUpMainPage.clickMessageSpaceCopied();
        clickUpMainPage.clickIconInCreateSpace();
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        softAssert.assertEquals(subMenuSideBar.getWorkSpaceTittle(), bodyWorkspaceForm.get("name"));
    }

    @When("I update a workspace with the following parameters")
    public void updateAWorkspaceWithTheFollowingParameters(final Map<String, String> bodyWorkspaceForm) {
        this.bodyWorkspaceForm = bodyWorkspaceForm;
        clickUpMainPage = new ClickUpMainPage(webDriverManager);
        sideBar = clickUpMainPage.getSideBar();
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        WorkspaceSetting workspaceSetting = subMenuSideBar.clickWorkspaceSettingTxt();
        workspaceSetting.typeNameWorkspace(bodyWorkspaceForm.get("name"));
        workspaceSetting.clickSavedButton();
        Settings settings = new Settings(webDriverManager);
        settings.clickBackButton();
        scenarioTrash.setScenarioTrash("workspace_name", bodyWorkspaceForm.get("name"));
    }
}
