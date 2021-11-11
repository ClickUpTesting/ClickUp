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
import clickup.ui.pages.list.AddNewColumn;
import clickup.ui.pages.list.ListPage;
import clickup.ui.pages.list.RatingForm;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class CustomFieldSteps {
    private WebDriverManager webDriverManager;
    private ListPage listPage;
    private Map<String, String> bodyCustomFieldForm;
    private SoftAssert softAssert;
    private ScenarioTrash scenarioTrash;
    private ClickUpMainPage clickUpMainPage;

    public CustomFieldSteps(WebDriverManager webDriverManager, SoftAssert softAssert, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.softAssert = softAssert;
        this.scenarioTrash = scenarioTrash;
    }

    @When("I create a new custom field ranting with field")
    public void createANewCustomFieldRantingWithField(final Map<String, String> bodyCustomFieldForm) {
        this.bodyCustomFieldForm = bodyCustomFieldForm;
        listPage = new ListPage(webDriverManager);
        AddNewColumn addNewColumn = listPage.clickAddNewColumnIcon();
        addNewColumn.clickEnableButton();
        RatingForm ratingForm = addNewColumn.clickRating();
        ratingForm.typeFieldName(bodyCustomFieldForm.get("name"));
        ratingForm.clickAddColumnButton();
    }

    @Then("I verify that the created list contains the default values of ranting")
    public void verifyThatTheCreatedListContainsTheDefaultValuesOfRanting() {
        ListPage listPageRefresh = new ListPage(webDriverManager);
        softAssert.assertTrue(listPageRefresh.getNameColumnsOfTaskInStatus().stream().
                anyMatch(value -> value.equals(bodyCustomFieldForm.get("name").toUpperCase())), "Don't match");
        softAssert.assertTrue(listPageRefresh.isDisplayedRantingStars(), "Doesn't exit stars");
    }
}
