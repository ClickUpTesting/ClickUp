package cucumber.hooks;

import clickup.entities.Folder;
import core.api.ApiResponse;
import io.cucumber.java.After;

import static clickup.FoldersRequests.deleteFolder;

public class FolderHooks {
    ApiResponse apiResponse;

    public FolderHooks(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    @After(value = "@CreateFolder")
    public void deleteCreatedFolder() {
        deleteFolder(apiResponse.getBody(Folder.class).getIdentifier());
    }
}
