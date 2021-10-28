package clickup.ui.pages.sidebar.settings;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Settings extends BasePage {
    @FindBy(css = ".cu-nav-sts__link[routerlink='teams']")
    private WebElement workspacesLinkTxt;

    public Workspaces clickWorkspacesLinkTxt(){
        webDriverActions.clickElement(workspacesLinkTxt);
        return new Workspaces(webDriverManager);
    }

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     * @author Gustavo Huanca
     */
    public Settings(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
