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

import clickup.ui.pages.task.TaskPage;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.util.Map;

public class TagSteps {
    private WebDriverManager webDriverManager;
    private TaskPage taskPage;
    private Map<String, String> tagsSettings;
    private SoftAssert softAssert;
    private ScenarioTrash scenarioTrash;

    public TagSteps(WebDriverManager webDriverManager, SoftAssert softAssert, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I create a tag with the following parameters")
    public void createTag(Map<String, String> settingsMap) {
        scenarioTrash.setScenarioBodyRequest(settingsMap);
        tagsSettings = settingsMap;
        taskPage = new TaskPage(webDriverManager);
        taskPage.clickAddTagButton();
        taskPage.getTagForm().setTagTextArea(tagsSettings.get("name"));
    }

    @Then("I verify that the created tag contains the default values")
    public void verifyTag() {
        softAssert.assertTrue(taskPage.verifySpaceName(tagsSettings.get("name")));
    }
}
