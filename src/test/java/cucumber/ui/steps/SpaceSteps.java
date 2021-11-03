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
import clickup.ui.pages.spaces.AllGoodPage;
import clickup.ui.pages.spaces.ColorOrAvatarPage;
import clickup.ui.pages.spaces.CreateNewSpacePage;
import clickup.ui.pages.spaces.EnableClickAppsPage;
import clickup.ui.pages.spaces.ShareSpacePage;
import clickup.ui.pages.spaces.TaskStatusesPage;
import clickup.ui.pages.spaces.ViewsSettingsPage;
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
    private Map<String, String> spaceSetting;
    private SoftAssert softAssert;
    private ScenarioTrash scenarioTrash;

    public SpaceSteps(WebDriverManager webDriverManager, SoftAssert softAssert, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I create a space with the following parameters")
    public void createASpaceWithDefaultSettings(Map<String, String> settingsMap) {
        scenarioTrash.setScenarioBodyRequest(settingsMap);
        spaceSetting = settingsMap;
        clickUpMainPage = new ClickUpMainPage(webDriverManager);
        CreateNewSpacePage createNewSpacePage = clickUpMainPage.clickNewSpace();
        createNewSpacePage.setSpaceName(spaceSetting.get("name"));
        ColorOrAvatarPage colorOrAvatarPage = createNewSpacePage.clickNextButton();
        ShareSpacePage shareSpacePage = colorOrAvatarPage.clickNextButton();
        TaskStatusesPage taskStatusesPage = shareSpacePage.clickNextButton();
        EnableClickAppsPage enableClickAppsPage = taskStatusesPage.clickNextButton();
        ViewsSettingsPage viewsSettingsPage = enableClickAppsPage.clickNextButton();
        AllGoodPage allGoodPage = viewsSettingsPage.clickReviewSpaceButton();
        clickUpMainPage = allGoodPage.clickCreateSpaceButton();
        clickUpMainPage.clickSpace(spaceSetting.get("name"));
    }

    @Then("I verify that the created space contains the default values")
    public void verifySpaceSettings() {
        String spaceId = getLastUrlID(webDriverManager.getWebDriver());
        scenarioTrash.setScenarioTrash("space_id", spaceId);
        softAssert.assertTrue(clickUpMainPage.verifySpaceName(spaceSetting.get("name")));
    }
}
