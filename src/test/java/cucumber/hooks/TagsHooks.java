package cucumber.hooks;

import core.api.*;
import core.utils.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.util.ArrayList;
import java.util.List;

public class TagsHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    public TagsHooks(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Before(value = "@DeleteTag or @CreateTag")
    public void createTag(){
        List<String> tagsTrashList = new ArrayList<>();
        String tagName = "deleteMe";
        apiRequestBuilder
                .endpoint("/space/{space_id}/tag")
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST)
                .body("{\n" +
                        "  \"tag\": {\n" +
                        "    \"name\": \"" +tagName+ "\"\n" +
                        "  }\n" +
                        "}")
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        System.out.println("dos");
        tagsTrashList.add(tagName);
        scenarioContext.setTrash("Tags Trash", tagsTrashList);
    }

    @After(value = "@DeleteTag or @CreateTag" )
    public void deleteTags(){
        List<String> tagsTrashList = scenarioContext.getTrashList("Tags Trash");
        apiRequestBuilder
                .endpoint("/space/{space_id}/tag/{tag_name}")
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.DELETE);
        for (String tagName : tagsTrashList) {
            apiRequestBuilder.pathParams("tag_name", tagName);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
    }
}
