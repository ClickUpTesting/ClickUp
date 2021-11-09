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

import clickup.ui.pages.sidebar.FeatureSettings;
import clickup.ui.pages.sidebar.FolderForm;
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.topbar.FolderTopBar;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.util.Map;

public class FolderSteps {
    protected ScenarioContext scenarioContext = clickup.utils.ScenarioContext.getInstance();
    protected WebDriverManager webDriverManager;
    protected ScenarioTrash scenarioTrash;
    private Map<String, String> bodyFolderForm;
    private FolderTopBar folderTopBar;
    private SoftAssert softAssert;

    public FolderSteps(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash, SoftAssert softAssert) {
        this.webDriverManager = webDriverManager;
        this.scenarioTrash = scenarioTrash;
        this.softAssert = softAssert;
    }

    @When("I create a new folder with field")
    public void createANewFolderWithField(final Map<String, String> bodyFolderForm) {
        this.bodyFolderForm = bodyFolderForm;
        SideBar sideBar = new SideBar(webDriverManager);
        sideBar.clickInASpace(scenarioTrash.getTrashValue("name_space"));
        FolderForm folderForm = sideBar.clickFolderTextLink();
        folderForm.setNameFolder(bodyFolderForm.get("name"));
        folderForm.clickCreateFolderButton();
    }

    @Then("I verify that the created folder contains the default values")
    public void verifyThatTheCreatedFolderContainsTheDefaultValues() {
        SideBar sideBar = new SideBar(webDriverManager);
        sideBar.clickFolderInSpace(scenarioTrash.getTrashValue("name_space"));
        softAssert.assertTrue(sideBar.getFoldersInASpace(scenarioTrash.getTrashValue("name_space")).stream().
                anyMatch(value -> value.equals(bodyFolderForm.get("name"))));
    }

    @When("I update a new folder with field")
    public void updateANewFolderWithField(final Map<String, String> bodyFolderForm) {
        this.bodyFolderForm = bodyFolderForm;
        folderTopBar = new FolderTopBar(webDriverManager);
        FeatureSettings featureSettings = folderTopBar.clicksFolderName();
        featureSettings.clickRenameIcon();
        folderTopBar.editFolderName(bodyFolderForm.get("name"));
    }

    @Then("I verify that the folder contains the default values")
    public void verifyThatTheFolderContainsTheDefaultValues() {
        softAssert.assertEquals(folderTopBar.getFolderName(), bodyFolderForm.get("name"));
    }

    @When("I delete a folder")
    public void deleteAFolder() {
        folderTopBar = new FolderTopBar(webDriverManager);
        FeatureSettings featureSettings = folderTopBar.clicksFolderName();
        featureSettings.clickDeleteIcon();
    }

    @Then("I verify that the folder does not exist in the space")
    public void verifyThatTheFolderDoesNotExistInTheSpace() {
        SideBar sideBar = new SideBar(webDriverManager);
        softAssert.assertFalse(sideBar.getFoldersInASpace(scenarioContext.getEnvData("space_id")).stream().
                anyMatch(value -> value.equals(scenarioTrash.getTrashValue("folder_name"))));
    }
}
