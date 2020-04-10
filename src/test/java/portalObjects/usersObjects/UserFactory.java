package portalObjects.usersObjects;

public class UserFactory {
    public static RegisteredUserUO getUser(UserTypes userRole) {
        RegisteredUserUO user = null;

        switch (userRole) {
            case ADMINISTRATOR:
                user = new AdminUO();
                break;
            case STANDARD_USER:
                user = new StandardUserUO();
                break;
        }

        return user;
    }
}
