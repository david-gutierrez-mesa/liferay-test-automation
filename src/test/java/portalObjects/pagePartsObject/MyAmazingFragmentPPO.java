package portalObjects.pagePartsObject;

import static common.CommonMethods.getTextFromElement;
import static portalObjects.paths.MyAmazingFragmentPaths.emailLocator;
import static portalObjects.paths.MyAmazingFragmentPaths.firstNameLocator;

public class MyAmazingFragmentPPO {

    public MyAmazingFragmentPPO() {

    }

    public boolean assertEmailIs(String expectedEmail) {
        String actualEmail = getTextFromElement(emailLocator);
        return expectedEmail.equals(actualEmail);
    }

    public boolean assertFirstNameIs(String expectedName) {
        String actualName = getTextFromElement(firstNameLocator);
        return expectedName.equals(actualName);
    }

}
