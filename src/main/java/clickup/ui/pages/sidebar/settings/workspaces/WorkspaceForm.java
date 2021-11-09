/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.pages.sidebar.settings.workspaces;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspaceForm extends BasePage {
    @FindBy(css = ".cu-onboarding-v2__input.ng-pristine.ng-valid.ng-touched")
    protected WebElement nameWorkspaceTxt;

    @FindBy(css = ".cu-btn.onboarding__name-next")
    protected WebElement nextButtonOfNameWorkSpace;

    @FindBy(css = ".cu-btn.onboarding__theme-color-next.onboarding__team-avatar")
    protected WebElement imHappySoFarButton;

    @FindBy(css = "div.cu-onboarding-v2__number-of-team-users div[class*='2-5']")
    protected WebElement workTwoToFiveOptions;

    @FindBy(css = "div div[class*='item-1 ng']")
    protected WebElement workJustMeOptions;

    @FindBy(css = "button.cu-btn.onboarding__emails-next")
    protected WebElement imDoneButton;

    @FindBy(css = "button.cu-btn.onboarding__clickapps-next")
    protected WebElement looksGoodButton;

    @FindBy(css = "button.cu-btn.onboarding__team-integrations-next")
    protected WebElement noThanksButtonInAnyApps;

    @FindBy(css = "button.cu-btn.onboarding__imports-next")
    protected WebElement noThanksButtonInImportTasks;

    @FindBy(css = "button.cu-btn.onboarding__finish")
    protected WebElement playWithClickUPButton;

    @FindBy(css = "div.cu-onboarding-v2__small.ng-star-inserted")
    protected WebElement pressEnterText;

    public WorkspaceForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets name of the new workspace.
     *
     * @param nameWorkSpace is name of the new workspace
     * @author Gustavo Huanca
     */
    public void setNameWorkspaceTxt(String nameWorkSpace) {
        webDriverElementText.setText(nameWorkspaceTxt, nameWorkSpace);
    }

    /**
     * Click Next button on Name your Workspace section
     *
     * @author Gustavo Huanca
     */
    public void clickNexButtonOfNameWorkspace() {
        webDriverActions.clickElement(nextButtonOfNameWorkSpace);
    }

    /**
     * Click I'm happy so far button in Customize your Workspace's avatar section.
     *
     * @author Gustavo Huanca
     */
    public void clickImHappySoFarButton() {
        webDriverActions.clickElement(imHappySoFarButton);
    }

    /**
     * Click Just me button.
     *
     * @author Gustavo Huanca
     */
    public void clickWorkJustMeOptions() {
        webDriverActions.clickElement(workJustMeOptions);
    }

    /**
     * Clicks I'm done button in Invite people section.
     *
     * @author Gustavo Huanca
     */
    public void clickImDoneButton() {
        webDriverActions.clickElement(imDoneButton);
    }

    /**
     * Clicks Looks goods button in Customize how you work by enabling section.
     *
     * @author Gustavo Huanca
     */
    public void clickLooksGoodButton() {
        webDriverActions.clickElement(looksGoodButton);
    }

    /**
     * Clicks No, thanks button in Do you use any of these apps? section.
     *
     * @author Gustavo Huanca
     */
    public void clickNoThanksButtonInAnyApps() {
        webDriverActions.clickElement(noThanksButtonInAnyApps);
    }

    /**
     * Clicks No, thanks button in Do you want to import tasks? section.
     *
     * @author Gustavo Huanca
     */
    public void clickNoThanksButtonInImportTasks() {
        webDriverActions.clickElement(noThanksButtonInImportTasks);
    }

    /**
     * Clicks in Play with ClickUp button.
     *
     * @author Gustavo Huanca
     */
    public void clickPlayWithClickUPButton() {
        webDriverActions.clickElement(playWithClickUPButton);
    }

    /**
     * Creates the workspace by default values.
     *
     * @param nameWorkspace is name workspace.
     * @author Gustavo Huanca
     */
    public void fillUpWorkspaceForm(String nameWorkspace) {
        setNameWorkspaceTxt(nameWorkspace);
        clickNexButtonOfNameWorkspace();
        clickImHappySoFarButton();
        clickWorkJustMeOptions();
        clickLooksGoodButton();
        clickNoThanksButtonInImportTasks();
        clickPlayWithClickUPButton();
    }

    @Override
    protected void waitForPageLoaded() {
        //The locator need one click on the page to work
        webDriverWaits.waitVisibilityOfElement(nextButtonOfNameWorkSpace);
        webDriverActions.clickElement(pressEnterText);
    }
}
