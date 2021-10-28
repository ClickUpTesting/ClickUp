package clickup.ui.pages.sidebar;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.sidebar.settings.Settings;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubMenuSideBar extends BasePage {
    @FindBy(css = "a.ng-star-inserted[data-test='user-settings-menu-item-my-settings']")
    private WebElement mySettingLinkTxt;

    @FindBy(css = "div[data-test*='column-title-name'][tooltipmodifier]")
    private WebElement workSpaceTittle;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     * @author Gustavo Huanca
     */
    public SubMenuSideBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public Settings clickMySettingLinkTxt(){
        webDriverActions.clickElement(mySettingLinkTxt);
        return new Settings(webDriverManager);
    }

    public String getWorkSpaceTittle(){
        return webDriverElementText.getWebElementText(workSpaceTittle);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
