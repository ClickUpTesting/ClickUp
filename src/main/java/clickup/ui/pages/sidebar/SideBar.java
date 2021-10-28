package clickup.ui.pages.sidebar;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBar extends BasePage {
    @FindBy(css = "div[data-test='user-settings-dropdown-toggle']")
    private WebElement userSettingDropdown;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     * @author Gustavo Huanca
     */
    public SideBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public SubMenuSideBar clickUserSettingDropdown(){
        webDriverActions.clickElement(userSettingDropdown);
        return new SubMenuSideBar(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
