package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.utils.Context;
import io.cucumber.java.Before;

public class FolderHooks {
    private Context context;

    public FolderHooks(Context context) {
        this.context = context;
    }

    @Before(value = "@CreateList", order = 1)
    public void createFolder() {
        context.addPathParams("folder_id", "25022057");
    }


}
