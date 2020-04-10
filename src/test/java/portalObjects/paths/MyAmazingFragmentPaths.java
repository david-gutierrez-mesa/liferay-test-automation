package portalObjects.paths;

import org.openqa.selenium.By;

public class MyAmazingFragmentPaths {
    public static By firstNameLocator = By.xpath("//*[@data-qa-id=\"maf-firstName\"]");
    public static By emailLocator = By.xpath("//*[@data-qa-id=\"maf-email\"]");

    private MyAmazingFragmentPaths() {
    }
}
