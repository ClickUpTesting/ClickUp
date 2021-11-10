package clickup.ui.pages.sidebar.settings.workspaces;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspaceFormToDelete extends BasePage {
    @FindBy(css = "input[class*='cu-dc__input cu-dc__input_team']")
    protected WebElement deleteWorkspaceTxtBox;

    @FindBy(css = "div.cu-dc__subtitle")
    protected WebElement workspaceToDeleteTxt;

    @FindBy(css = "button[class='cu-btn cu-btn_fw-sm']")
    protected WebElement deleteWorkspaceButtonToDelete;

    public WorkspaceFormToDelete(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets name of workspace to delete
     *
     * @return is String with name of workspace
     * @author Gustavo Huanca
     */
    public String getWorkspaceToDeleteTxt() {
        return webDriverElementText.getWebElementText(workspaceToDeleteTxt);
    }

    /**
     * Types or fills up workspace name to delete.
     *
     * @param nameWorkspaceToDelete is name of workspace will be deleted
     * @author Gustavo Huanca
     */
    public void fillUpDeleteWorkspaceTxtBox(String nameWorkspaceToDelete) {
        webDriverElementText.setText(deleteWorkspaceTxtBox, nameWorkspaceToDelete);
    }

    /**
     * Click delete button to delete workspace.
     *
     * @author Gustavo Huanca
     */
    public void clickDeleteWorkspaceButtonToDelete() {
        webDriverActions.clickElement(deleteWorkspaceButtonToDelete);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWaits.waitVisibilityOfElement(deleteWorkspaceButtonToDelete);
    }
}
