package clickup;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;

public final class FoldersRequests {
    private FoldersRequests() {
    }

    public static ApiResponse getFolder(final String folderId) {
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse = new ApiResponse();
        ApiRequest apiRequest = apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "18916260_e3f36a2bafdfc1530ad6363cf86218a6b44acb36")
                .method(ApiMethod.GET)
                .endpoint("folder/{folder_id}")
                .pathParams("folder_id", folderId)
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        return apiResponse;
    }

    public static void deleteFolder(final String folderId) {
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse = new ApiResponse();
        ApiRequest apiRequest = apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "18916260_e3f36a2bafdfc1530ad6363cf86218a6b44acb36")
                .method(ApiMethod.DELETE)
                .endpoint("folder/{folder_id}")
                .pathParams("folder_id", folderId)
                .build();
        ApiManager.execute(apiRequest, apiResponse);
    }
}
