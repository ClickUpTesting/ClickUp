package clickup.entities.features.folders;

import clickup.entities.features.GetAllFeatures;

import java.util.List;

public class Folders implements GetAllFeatures {
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
