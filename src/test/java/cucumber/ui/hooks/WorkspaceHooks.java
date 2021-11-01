package cucumber.ui.hooks;

import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.sidebar.SubMenuSideBar;
import clickup.ui.pages.sidebar.settings.Settings;
import clickup.ui.utils.PageTransporter;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.After;

import static clickup.ui.utils.PageUrl.getUrlPage;

public class WorkspaceHooks {
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private ScenarioTrash scenarioTrash;

    public WorkspaceHooks(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(webDriverManager);
        this.scenarioTrash = scenarioTrash;
    }

    @After(value = "@DeleteWorkspace")
    public void deleteWorkspace() {
        pageTransporter.goToUrl(getUrlPage("base ClickUp"));
        SideBar sideBar = new SideBar(webDriverManager);
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        Settings settings =  subMenuSideBar.clickMySettingLinkTxt();
        settings.clickSettingsLinkTxt();
        settings.clickDeleteWorkspaceButtonInSettingsLinkTxt();
        settings.fillUpDeleteWorkspaceTxtBox(scenarioTrash.getScenarioBodyRequest().get("name"));
        settings.clickDeleteWorkspaceButtonToDelete();
    }
}
