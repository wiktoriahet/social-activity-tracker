package pl.hetman.wiktoria.java.app.socialactivitytracker.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.java.app.socialactivitytracker.dao.jdbc.UniqueIdGenerator;

class UniqueIdGeneratorTest {

    @Test
    void generateId() {
        //given - stworzenie obiektu testowanej klasy oraz parametrów testowanej metody
        //UniqueIdGenerator uniqueIdGenerator = new UniqueIdGenerator();


        //when - wywołanie testowanej metody
        Long firstGeneratedId = UniqueIdGenerator.generateId();
        Long secondGeneratedId = UniqueIdGenerator.generateId();
        System.out.println(firstGeneratedId);
        System.out.println(secondGeneratedId);

        //then - weryfikacja poprawności wprowadzanych danych oraz zwracanych wyników
        Assertions.assertAll(
                () -> Assertions.assertNotNull(firstGeneratedId, "firstGeneratedId is Null"),
                () -> Assertions.assertNotEquals(firstGeneratedId, secondGeneratedId, "firstGeneratedId equals secondGeneratedId")
        );


    }
}