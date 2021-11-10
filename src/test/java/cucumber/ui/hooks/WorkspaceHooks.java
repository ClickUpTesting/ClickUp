package cucumber.ui.hooks;

import clickup.ui.pages.ClickUpMainPage;
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.sidebar.SubMenuSideBar;
import clickup.ui.pages.sidebar.settings.Settings;
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceForm;
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceFormToDelete;
import clickup.ui.pages.sidebar.settings.workspaces.WorkspaceSetting;
import clickup.ui.utils.PageTransporter;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static clickup.ui.utils.GetUrl.getIdTeam;
import static clickup.ui.utils.PageUrl.getUrlPage;
import static core.utils.RandomCustom.random;

public class WorkspaceHooks {
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private ScenarioTrash scenarioTrash;
    private ClickUpMainPage clickUpMainPage;

    public WorkspaceHooks(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(webDriverManager);
        this.scenarioTrash = scenarioTrash;
    }

    @Before(value = "@CreateWorkspace")
    public void createWorkspace() {
        String nameWorkspace = "workspace before From API".concat(random());
        clickUpMainPage = new ClickUpMainPage(webDriverManager);
        SideBar sideBar = clickUpMainPage.getSideBar();
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        WorkspaceForm workspaceForm = subMenuSideBar.clickAddWorkspaceIcon();
        workspaceForm.fillUpWorkspaceForm(nameWorkspace);
        ClickUpMainPage clickUpMainPage = new ClickUpMainPage(webDriverManager);
        scenarioTrash.setScenarioTrash("workspace_id", getIdTeam(webDriverManager.getWebDriver().getCurrentUrl()));
        scenarioTrash.setScenarioTrash("workspace_name", nameWorkspace);
    }

    @After(value = "@DeleteWorkspace")
    public void deleteWorkspace() {
        pageTransporter.goToUrl(getUrlPage("base ClickUp"));
        SideBar sideBar = new SideBar(webDriverManager);
        SubMenuSideBar subMenuSideBar = sideBar.clickUserSettingDropdown();
        Settings settings = subMenuSideBar.clickMySettingLinkTxt();
        WorkspaceSetting workspaceSetting = settings.clickSettingsLinkTxt();
        WorkspaceFormToDelete workspaceFormToDelete = workspaceSetting.clickDeleteWorkspaceButtonInSettingsLinkTxt();
        workspaceFormToDelete.fillUpDeleteWorkspaceTxtBox(scenarioTrash.getTrashValue("workspace_name"));
        workspaceFormToDelete.clickDeleteWorkspaceButtonToDelete();
    }
}
