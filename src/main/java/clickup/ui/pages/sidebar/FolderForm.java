package clickup.ui.pages.sidebar;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FolderForm extends BasePage {
    @FindBy(css = "cu-create-category input[placeholder]")
    protected WebElement folderNameTextBox;

    @FindBy(css = "button [class='cu-btn__text']")
    protected WebElement createFolderButton;

    public FolderForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }
    /**
     * Set the name of folder
     *
     * @param nameFolder is the name of the folder
     */
    public void setNameFolder(String nameFolder){
        webDriverElementText.setText(folderNameTextBox, nameFolder);
    }

    /**
     * Clicks in Create Folder button
     */
    public void clickCreateFolderButton() {
        webDriverActions.clickElement(createFolderButton);
    }


    @Override
    protected void waitForPageLoaded() {
        webDriverWait.waitVisibilityOfElement(folderNameTextBox);
    }
}
