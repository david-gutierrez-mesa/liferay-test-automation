package users;

public class StandardUser implements RegisteredUser {

    @Override
    public String getUserName() {
        return "standarduser@liferay.com";
    }

    @Override
    public String getUserPassword() {
        return "test";
    }
}
