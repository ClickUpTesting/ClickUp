package clickup.ui.pages.sidebar.settings;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import core.selenium.driveractions.WebDriverActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Workspaces extends BasePage {
    @FindBy(css = "div[class='team-list-item__icon']")
    private WebElement addNewButton;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     * @author Gustavo Huanca
     */
    public Workspaces(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public WorkspaceForm clickAddNewIcon() {
        webDriverActions.clickElement(addNewButton);
        return new WorkspaceForm(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
