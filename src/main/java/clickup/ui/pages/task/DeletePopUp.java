package clickup.ui.pages.task;

import clickup.ui.pages.BasePage;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePopUp extends BasePage {
    @FindBy(css = "button[class='cu-btn']")
    private WebElement deleteButton;

    public DeletePopUp(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks the Delete icon
     *
     * @author Jorge Caceres
     */
    public TaskPage clickDeleteIcon() {
        webDriverActions.clickElement(deleteButton);
        return new TaskPage(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @author Gustavo Huanca
     */
    @Override
    protected void waitForPageLoaded() {

    }
}
