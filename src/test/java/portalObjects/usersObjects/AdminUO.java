package portalObjects.usersObjects;

public class AdminUO implements RegisteredUserUO {
    @Override
    public String getUserName() {
        return "test@liferay.com";
    }

    @Override
    public String getUserPassword() {
        return "test";
    }
}
