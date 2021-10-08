package clickup.requests;

import clickup.ApiEndpoints;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import org.json.JSONObject;
import java.util.LinkedList;

public class TagsRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Creates a tag and returns its identifier.
     *
     * @param tagName to be set on the tag
     * @author Jorge Caceres
     */
    public void createTag(final String tagName) {
        JSONObject jsonBody = new JSONObject();
        JSONObject tagBody = new JSONObject();
        tagBody.put("name", tagName);
        jsonBody.put("tag", tagBody);
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.CREATE_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST)
                .body(jsonBody.toString())
                .build();
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }

    /**
     * Deletes a tag's list.
     *
     * @author Jorge Caceres
     */
    public void deleteTagsList() {
        LinkedList<String> tagsTrashList = scenarioContext.getTrashList("Tags");
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.DELETE_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.DELETE);
        for (String tagName : tagsTrashList) {
            apiRequestBuilder.pathParams("tag_name", tagName);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
    }

    /**
     * Deletes a tag.
     *
     * @param tagName tag's name to be deleted
     * @author Jorge Caceres
     */
    public void deleteTag(String tagName) {
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.DELETE_TAG.getEndpoint())
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.DELETE);
            apiRequestBuilder.pathParams("tag_name", tagName);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
    }
}
