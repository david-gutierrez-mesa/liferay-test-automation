package portalObjects.usersObjects;

import java.time.LocalDate;
import java.util.Locale;

public class AdminUO implements RegisteredUserUO {

    @Override
    public LocalDate getDateOfBirth() {
        return LocalDate.of(1986, 8, 24);
    }

    @Override
    public String getEmail() {
        return "test@liferay.com";
    }

    @Override
    public String getFirstName() {
        return "Test";
    }

    @Override
    public String getLastName() {
        return "Test";
    }

    @Override
    public Locale geLocale() {
        return new Locale("EN", "US");
    }

    @Override
    public String getMiddleName() {
        return null;
    }

    @Override
    public String getPassword() {
        return "test";
    }

    @Override
    public String getScreenName() {
        return "test";
    }

}
