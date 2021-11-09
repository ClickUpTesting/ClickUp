package clickup.ui.pages.topbar;

import clickup.ui.pages.BasePage;

import clickup.ui.pages.sidebar.FeatureSettings;
import core.selenium.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FolderTopBar extends BasePage {
    @FindBy(css = ".cu-views-bar-title__container.ng-star-inserted")
    private WebElement listIcon;
    @FindBy(css = "div.cu-views-bar-title__label-text.ng-star-inserted")
    private WebElement folderName;
    @FindBy(css = ".cu-editable.cu-views-bar-title__label-inner input")
    private WebElement folderNameTxtArea;

    public FolderTopBar(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks on the list name text.
     *
     * @author Jorge Caceres
     */
    public FeatureSettings clicksFolderName() {
        webDriverActions.clickElement(folderName);
        return new FeatureSettings(webDriverManager);
    }

    /**
     * Updates the list name.
     *
     * @param newListName list name to be updated
     * @author Jorge Caceres
     */
    public void editFolderName(final String newListName) {
        webDriverElementText.cleartext(folderNameTxtArea);
        webDriverElementText.setText(folderNameTxtArea, newListName);
        webDriverElementText.pressKeyboard(folderNameTxtArea, Keys.TAB);
    }

//    public String getFolderName() {
//        webDriverWait.waitRefreshedAndClickable(folderName);
//        return webDriverElementText.getWebElementText(folderName);
//    }

    /**
     * Waits until the page is loaded.
     *
     * @author Jorge Caceres
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(folderName);
    }
}
