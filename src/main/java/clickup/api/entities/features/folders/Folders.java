/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package clickup.api.entities.features.folders;

import clickup.api.entities.features.IGetAllFeatures;
import java.util.List;

public class Folders implements IGetAllFeatures {
    private List<Folder> folders;

    @Override
    public int getAmount() {
        return folders.size();
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
