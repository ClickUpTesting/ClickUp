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

import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.sidebar.SubMenuSideBar;
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceForm;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class WorkspaceSteps {
    private WebDriverManager webDriverManager;
    private SideBar sideBar;
    private Map<String, String> bodyWorkspaceForm;
    private SoftAssert softAssert;

    public WorkspaceSteps(final WebDriverManager webDriverManager, final SoftAssert softAssert) {
        this.webDriverManager = webDriverManager;
        this.softAssert = softAssert;
    }

    @And("I create a new workspace with field")
    public void createANewWithField(final Map<String, String> bodyWorkspaceForm) {
        this.bodyWorkspaceForm = bodyWorkspaceForm;
        SideBar sideBar2 = new SideBar(webDriverManager);
        SubMenuSideBar subMenuSideBar = sideBar2.clickUserSettingDropdown();
        WorkspaceForm workspaceForm = subMenuSideBar.clickAddWorkspaceIcon();
        sideBar = workspaceForm.fillUpWorkspaceForm(bodyWorkspaceForm.get("name"));
    }


    @Then("I verify that the created workspace contains the default values")
    public void verifyThatTheCreatedContainsTheDefaultValues() {
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        softAssert.assertEquals(subMenuSideBar.getWorkSpaceTittle(), bodyWorkspaceForm.get("name"));
    }
}
