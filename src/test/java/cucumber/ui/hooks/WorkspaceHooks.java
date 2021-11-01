package cucumber.ui.hooks;

import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.sidebar.SubMenuSideBar;
import clickup.ui.pages.sidebar.settings.Settings;
import clickup.ui.utils.PageTransporter;
import core.selenium.WebDriverManager;
import io.cucumber.java.After;

public class WorkspaceHooks {
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    public WorkspaceHooks(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(webDriverManager);
    }

    @After(value = "@DeleteWorkspace")
    public void deleteWorkspace() {
        pageTransporter.goToUrl("https://app.clickup.com/login");
        SideBar sideBar = new SideBar(webDriverManager);
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        Settings settings =  subMenuSideBar.clickMySettingLinkTxt();
        settings.clickSettingsLinkTxt();
        settings.clickDeleteWorkspaceButtonInSettingsLinkTxt();
        settings.fillUpDeleteWorkspaceTxtBox(settings.getWorkspaceToDeleteTxt());
        settings.clickDeleteWorkspaceButtonToDelete();
    }
}
