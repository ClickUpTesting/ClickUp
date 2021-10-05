/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package cucumber.runner;

import clickup.ApiEndpoints;
import clickup.api.ApiFacade;
import clickup.entities.features.folders.Folder;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.api.ApiHeaders;
import core.utils.ReportGenerator;
import clickup.utils.ScenarioContext;
import clickup.entities.Space;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static core.utils.RandomCustom.random;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:build/cucumber/cucumber-pretty.html", "json:build/cucumber/cucumber.json"},
        glue = {"cucumber"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    private ApiResponse apiResponse = new ApiResponse();
    private final String TOKEN = System.getenv("API_TOKEN");
    private String teamId = System.getenv("TEAM_ID");
    private ApiRequest apiRequest;
    private ScenarioContext scenarioContext;
    private ApiFacade apiFacade = new ApiFacade();

    /**
     * Sets base of request.
     *
     * @return ApiRequestBuilder contains base request
     */
    private ApiRequestBuilder baseRequest() {
        return new ApiRequestBuilder()
                .baseUri(ApiEndpoints.URL_BASE.getEndpoint())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), TOKEN)
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue());
    }

    @BeforeSuite
    public void setBaseEnv() {
        scenarioContext = ScenarioContext.getInstance();
        scenarioContext.setBaseEnvironment("team_id", teamId);
    }

    @BeforeTest()
    public void createSpace() throws JsonProcessingException {
        Space space = new Space();
        space.setName("Space created RunTest before From API");
        apiResponse = apiFacade.createObject(space, ApiEndpoints.CREATE_SPACE, "team_id", teamId);
        scenarioContext.setBaseEnvironment("space_id", apiResponse.getBody(Space.class).getId());
    }

    @BeforeTest(dependsOnMethods = {"createSpace"})
    public void createFolder() throws JsonProcessingException {
        Folder folder = new Folder();
        folder.setName("Folder created in RunTest From API".concat(random()));
        apiResponse = apiFacade.createObject(folder, ApiEndpoints.CREATE_FOLDER_IN_SPACE, "space_id",
                scenarioContext.getEnvData("space_id"));
        scenarioContext.setBaseEnvironment("folder_id", apiResponse.getBody(Folder.class).getId());
    }

    @AfterTest()
    public void deleteSpace() {
        apiFacade.deleteObject(ApiEndpoints.GET_SPACE, "space_id", scenarioContext.getEnvData("space_id"));

    }

    @AfterSuite
    public void createReports() {
        ReportGenerator.generateReport();
    }
}
