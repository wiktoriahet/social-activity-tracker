package pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.CredentialsProperties;

class CredentialsPropertiesTest {

    public static final String KEY = "database";
    public static final String VALUE = "jdbc:h2:~/test";

    @Test
    void getProperty() {
        //given
        CredentialsProperties credentialsProperties = new CredentialsProperties();

        // TODO: 18.05.2023 przenieść key value do stałych

        //when
        String property = credentialsProperties.getProperty(KEY);

        //then
        //Assertions.assertNotNull(property, "Property is null");
        Assertions.assertAll(
                ()-> Assertions.assertNotNull(property, "property is null"),
                ()-> Assertions.assertEquals(VALUE, property, "property not equals")
        );
    }
}