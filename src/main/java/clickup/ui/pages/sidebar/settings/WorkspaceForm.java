package clickup.ui.pages.sidebar.settings;

import clickup.ui.pages.BasePage;
import clickup.ui.pages.sidebar.SideBar;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspaceForm extends BasePage {
    @FindBy(css = ".cu-onboarding-v2__input.ng-pristine.ng-valid.ng-touched")
    private WebElement nameWorkspaceTxt;

    @FindBy(css = ".cu-btn.onboarding__name-next")
    private WebElement nextButtonOfNameWorkSpace;

    @FindBy(css = ".cu-btn.onboarding__theme-color-next.onboarding__team-avatar")
    private WebElement imHappySoFarButton;

    @FindBy(css = "div.cu-onboarding-v2__number-of-team-users div[class*='2-5']")
    private WebElement workTwoToFiveOptions;

    @FindBy(css = "button.cu-btn.onboarding__emails-next")
    private WebElement imDoneButton;

    @FindBy(css = "button.cu-btn.onboarding__clickapps-next")
    private WebElement looksGoodButton;

    @FindBy(css = "button.cu-btn.onboarding__team-integrations-next")
    private WebElement noThanksButtonInAnyApps;

    @FindBy(css = "button.cu-btn.onboarding__imports-next")
    private WebElement noThanksButtonInImportTasks;

    @FindBy(css = "button.cu-btn.onboarding__finish")
    private WebElement playWithClickUPButton;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     * @author Gustavo Huanca
     */
    public WorkspaceForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void setNameWorkspaceTxt(String nameWorkSpace){
        webDriverElementText.setText(nameWorkspaceTxt, nameWorkSpace);
    }

    public void clickNexButtonOfNameWorkspace(){
        webDriverActions.clickElement(nextButtonOfNameWorkSpace);
    }

    public void clickImHappySoFarButton(){
        webDriverActions.clickElement(imHappySoFarButton);
    }

    public void clickWorkTwoToFiveOptions(){
        webDriverActions.clickElement(workTwoToFiveOptions);
    }

    public void clickImDoneButton(){
        webDriverActions.clickElement(imDoneButton);
    }

    public void clickLooksGoodButton(){
        webDriverActions.clickElement(looksGoodButton);
    }

    public void clickNoThanksButtonInAnyApps(){
        webDriverActions.clickElement(noThanksButtonInAnyApps);
    }

    public SideBar clickPlayWithClickUPButton(){
        webDriverActions.clickElement(playWithClickUPButton);
        return new SideBar(webDriverManager);
    }


    @Override
    protected void waitForPageLoaded() {

    }
}
