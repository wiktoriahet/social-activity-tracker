package pl.hetman.wiktoria.java.app.socialactivitytracker.model.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredentialsPropertiesTest {

    @Test
    void getProperty() {
        //given
        CredentialsProperties credentialsProperties = new CredentialsProperties();
        String key = "database";
        String value = "jdbc:h2:~/test";

        // TODO: 18.05.2023 przenieść key value do stałych

        //when
        String property = credentialsProperties.getProperty(key);

        //then
        //Assertions.assertNotNull(property, "Property is null");
        Assertions.assertAll(
                ()-> Assertions.assertNotNull(property, "property is null"),
                ()-> Assertions.assertEquals(value, property, "property not equals")
        );
    }
}