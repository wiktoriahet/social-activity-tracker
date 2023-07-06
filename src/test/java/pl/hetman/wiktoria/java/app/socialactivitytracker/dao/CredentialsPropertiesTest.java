package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CredentialsPropertiesTest {

    @Test
    void getProperty() {
        //given
        CredentialsProperties credentialsProperties = new CredentialsProperties();

        //when
        String property = credentialsProperties.getProperty("database");

        //then
        Assertions.assertNotNull(property, "property is null");

    }
}