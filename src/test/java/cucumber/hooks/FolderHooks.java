package cucumber.hooks;

import clickup.Endpoints;
import clickup.entities.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.api.request.Header;
import core.utils.BaseContext;
import core.utils.Context;
import io.cucumber.java.Before;

public class FolderHooks {
    private Context context;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse = new ApiResponse();

    public FolderHooks(Context context) {
        this.context = context;
    }

    private final String TOKEN = "pk_18915744_BBOVH8SIAV8XZZA3W06NS6PSY8WZI7LJ";

    /**
     * Sets base of request.
     *
     * @return ApiRequestBuilder contains base request
     */
    public ApiRequestBuilder baseRequest() {
        return new ApiRequestBuilder()
                .baseUri(Endpoints.URL_BASE.getEndpoint())
                .headers(Header.AUTHORIZATION.getValue(), TOKEN)
                .headers(Header.CONTENT_TYPE.getValue(), Header.APPLICATION_JSON.getValue());
    }

    @Before(value = "@CreateList")
    public void createFolder() throws JsonProcessingException {
        Folder folder = new Folder();
        folder.setName("Folder before From API");
        apiRequest = baseRequest()
                .method(ApiMethod.POST)
                .endpoint(Endpoints.CREATE_FOLDER_IN_SPACE.getEndpoint())
                .pathParams("space_id", BaseContext.getBaseContext().getPathParamsBase().get("space_id"))
                .body(new ObjectMapper().writeValueAsString(folder))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        context.addPathParams("folder_id", apiResponse.getBody(Folder.class).getId());
    }
}
