/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package clickup.requests;

import clickup.ApiEndpoints;
import clickup.entities.features.folders.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import java.util.LinkedList;

import static core.utils.RandomCustom.random;

public class FoldersRequest extends BaseRequest {
    private ApiRequest apiRequest;

    /**
     * Creates a folder and returns its identifier.
     *
     * @return a folder_id
     * @throws JsonProcessingException when the response is not a valid json
     * @author Raymundo GuaraGuara
     */
    public String createFolder() throws JsonProcessingException {
        Folder folder = new Folder();
        folder.setName("Folder created in FolderHooks From API".concat(random()));
        apiResponse = apiFacade.createObject(folder, ApiEndpoints.CREATE_FOLDER_IN_SPACE, "space_id",
                scenarioContext.getEnvData("space_id"));
        return apiResponse.getBody(Folder.class).getId();
    }

    /**
     * Deletes a folder.
     *
     * @param id the folder id to be deleted
     * @author Raymundo GuaraGuara
     */
    public void deleteFolder(final String id) {
        apiFacade.deleteObject(ApiEndpoints.DELETE_FOLDER, "folder_id", id);
    }

    /**
     * Deletes a folder's list.
     *
     * @author Raymundo GuaraGuara
     */
    public void deleteFolders() {
        LinkedList<String> foldersTrashList = scenarioContext.getTrashList("Folders");
        apiRequestBuilder
                .cleanParams()
                .endpoint(ApiEndpoints.DELETE_FOLDER.getEndpoint())
                .method(ApiMethod.DELETE);
        for (String folderId : foldersTrashList) {
            apiRequestBuilder.pathParams("folder_id", folderId);
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
            apiResponse.getResponse().then().log().body();
        }
        scenarioContext.getTrashList("Folders").clear();
    }
}
