package cucumber.hooks;

import clickup.ApiEndpoints;
import clickup.entities.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.utils.ScenarioContext;
import io.cucumber.java.Before;

public class FolderHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;

    public FolderHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@CreateList")
    public void createFolder() throws JsonProcessingException {
        Folder folder = new Folder();
        folder.setName("Folder before From API");
        apiRequestBuilder
                .method(ApiMethod.POST)
                .endpoint(ApiEndpoints.CREATE_FOLDER_IN_SPACE.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .body(new ObjectMapper().writeValueAsString(folder))
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        scenarioContext.setBaseEnvironment("folder_id", apiResponse.getBody(Folder.class).getId());
    }
}
