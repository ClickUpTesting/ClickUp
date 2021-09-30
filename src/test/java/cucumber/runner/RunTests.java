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
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.api.ApiHeaders;
import core.utils.ReportGenerator;
import core.utils.ScenarioContext;
import clickup.entities.Space;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = {"src/test/resources/features/tags"},
        plugin = {"html:build/cucumber/cucumber-pretty.html", "json:build/cucumber/cucumber.json"},
        glue = {"cucumber"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    private ApiResponse apiResponse = new ApiResponse();
    private final String TOKEN = "3152915_d6831bb6342aea560c0d7bdcfd16a6f9ce50b1fb";
    private String teamId = "12908325";
    private ApiRequest apiRequest;
    private ScenarioContext scenarioContext;

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
        scenarioContext.setBaseEnvironment("space_id", teamId);
    }

    @BeforeTest()
    public void createSpace() throws JsonProcessingException {
        Space space = new Space();
        space.setName("Space before From API");
        apiRequest = baseRequest()
                .method(ApiMethod.POST)
                .endpoint(ApiEndpoints.CREATE_SPACE.getEndpoint())
                .pathParams("team_id", teamId)
                .body(new ObjectMapper().writeValueAsString(space))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        scenarioContext.setBaseEnvironment("space_id", apiResponse.getBody(Space.class).getId());
    }

    @AfterTest()
    public void deleteSpace() {
         apiRequest = baseRequest()
                .method(ApiMethod.DELETE)
                .endpoint(ApiEndpoints.GET_SPACE.getEndpoint())
                 .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
    }

    @AfterSuite
    public void createReports() {
        ReportGenerator.generateReport();
    }
}
