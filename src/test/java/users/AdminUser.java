package users;

public class AdminUser implements RegisteredUser {
    @Override
    public String getUserName() {
        return "test@liferay.com";
    }

    @Override
    public String getUserPassword() {
        return "test";
    }
}
