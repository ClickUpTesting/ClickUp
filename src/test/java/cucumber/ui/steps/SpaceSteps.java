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
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.spaces.AllGoodPage;
import clickup.ui.pages.spaces.ColorOrAvatarPage;
import clickup.ui.pages.spaces.CreateNewSpacePage;
import clickup.ui.pages.spaces.EnableClickAppsPage;
import clickup.ui.pages.spaces.RemoveSpacePopUp;
import clickup.ui.pages.spaces.ShareSpacePage;
import clickup.ui.pages.spaces.TaskStatusesPage;
import clickup.ui.pages.spaces.ViewsSettingsPage;
import clickup.ui.pages.topbar.SpaceTopBar;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.util.Map;

import static core.utils.UrlSplitter.getLastUrlID;

public class SpaceSteps {
    private WebDriverManager webDriverManager;
    private ClickUpMainPage clickUpMainPage;
    private Map<String, String> spaceSettings;
    private SoftAssert softAssert;
    private ScenarioTrash scenarioTrash;
    private SpaceTopBar spaceTopBar;
    private SideBar sideBar;

    public SpaceSteps(WebDriverManager webDriverManager, SoftAssert softAssert, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I create a space with the following parameters")
    public void createASpaceWithDefaultSettings(Map<String, String> settingsMap) {
        scenarioTrash.setScenarioBodyRequest(settingsMap);
        spaceSettings = settingsMap;
        clickUpMainPage = new ClickUpMainPage(webDriverManager);
        CreateNewSpacePage createNewSpacePage = clickUpMainPage.getSideBar().clickNewSpaceButton();
        createNewSpacePage.setSpaceName(spaceSettings.get("name"));
        ColorOrAvatarPage colorOrAvatarPage = createNewSpacePage.clickNextButton();
        ShareSpacePage shareSpacePage = colorOrAvatarPage.clickNextButton();
        TaskStatusesPage taskStatusesPage = shareSpacePage.clickNextButton();
        EnableClickAppsPage enableClickAppsPage = taskStatusesPage.clickNextButton();
        ViewsSettingsPage viewsSettingsPage = enableClickAppsPage.clickNextButton();
        AllGoodPage allGoodPage = viewsSettingsPage.clickReviewSpaceButton();
        clickUpMainPage = allGoodPage.clickCreateSpaceButton();
        clickUpMainPage.getSideBar().clickInASpace(spaceSettings.get("name"));
    }

    @Then("I verify that the created space contains the default values")
    public void verifySpaceSettings() {
        String spaceId = getLastUrlID(webDriverManager.getWebDriver());
        scenarioTrash.setScenarioTrash("space_id", spaceId);
        softAssert.assertTrue(clickUpMainPage.getSideBar().verifySpaceName(spaceSettings.get("name")));
    }

    @When("I delete a scape")
    public void deleteASpaceFromTopBar() {
        spaceTopBar = new SpaceTopBar(webDriverManager);
        spaceTopBar.clicksSpaceName(scenarioTrash.getTrashValue("name_space"));
        RemoveSpacePopUp removeSpacePopUp = spaceTopBar.getSpaceSettingsMenu().clickDeleteButton();
        removeSpacePopUp.fillSpaceName(scenarioTrash.getTrashValue("name_space"));
        sideBar = removeSpacePopUp.clickDelete();
    }

    @Then("I verify that the space does not exist in the sidebar")
    public void verifyTheDeletedSpace() {
        softAssert.assertFalse(sideBar.verifySpaceName(scenarioTrash.getTrashValue("name_space")));
    }
}
