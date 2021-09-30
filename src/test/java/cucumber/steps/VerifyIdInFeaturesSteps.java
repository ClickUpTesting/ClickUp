package cucumber.steps;

import clickup.ApiEndpoints;
import clickup.entities.features.lists.Lisst;
import clickup.entities.features.lists.Lists;
import clickup.utils.ScenarioContext;
import core.api.*;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.asserts.SoftAssert;

public class VerifyIdInFeaturesSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert = new SoftAssert();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private Lists lists;

    public VerifyIdInFeaturesSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @And("I verify the list exists in the folder")
    public void iVerifyTheIdOfListExistInFolder() {
        apiRequestBuilder
                .method(ApiMethod.GET)
                .endpoint(ApiEndpoints.LIST_IN_FOLDER.getEndpoint())
                .cleanParams()
                .pathParams("folder_id", scenarioContext.getEnvData("folder_id"))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        lists = apiResponse.getBody(Lists.class);
        boolean actual = false;
        if (lists.getLists().size() != 0) {
            System.out.println(lists.getLists().size());
            for (Lisst lisst : lists.getLists()) {
                if (scenarioContext.getEnvData("list_id").equals(lisst.getId())) {
                    System.out.println(equals(lisst.getId()));
                    actual = true;
                    break;
                }
            }
        }
        softAssert.assertEquals(actual, false);
        softAssert.assertAll();
    }
}
