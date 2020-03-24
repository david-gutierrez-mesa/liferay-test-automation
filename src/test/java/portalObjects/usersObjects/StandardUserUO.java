package portalObjects.usersObjects;

public class StandardUserUO implements RegisteredUserUO {

    @Override
    public String getUserName() {
        return "standarduser@liferay.com";
    }

    @Override
    public String getUserPassword() {
        return "test";
    }
}
