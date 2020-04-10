package portalObjects.usersObjects;

import java.time.LocalDate;
import java.util.Locale;

public interface RegisteredUserUO {
    LocalDate getDateOfBirth();

    String getEmail();

    String getFirstName();

    String getLastName();

    Locale geLocale();

    String getMiddleName();

    String getPassword();

    String getScreenName();

}
