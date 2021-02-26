package dev.donghyeon.junitstudy.parameterized.conversion;

import dev.donghyeon.junitstudy.Book;
import dev.donghyeon.junitstudy.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConversionTest {

    // String -> ENUM 변환
    @ParameterizedTest
    @ValueSource(strings = "SECONDS")
    void testWithImplicitArgumentConversion(ChronoUnit argument) {
        assertNotNull(argument.name());
    }

    // 정적 팩터리 메서드를 이용한 Book 인스턴스 만들어서 주입
    @ParameterizedTest
    @ValueSource(strings = "42 Cats")
    void testWithImplicitFallbackArgumentConversion(Book book) {
        assertEquals("42 Cats", book.getTitle());
    }

    //Enum -> String 변환
    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testWithExplicitArgumentConversion(
            @ConvertWith(ToStringArgumentConverter.class) String argument) {
        assertNotNull(ChronoUnit.valueOf(argument));
    }

    //인자가 많을 경우 ArgumentsAccessor 파라미터로 접근할 수 있다.
    @ParameterizedTest
    @CsvSource({
            "Jane, Doe, F, 1990-05-20",
            "John, Doe, M, 1990-10-22"
    })
    void testWithArgumentsAccessor(ArgumentsAccessor arguments) {
        Person person = new Person(arguments.getString(0),
                arguments.getString(1),
                arguments.get(2, Person.Gender.class),
                arguments.get(3, LocalDate.class));

        if (person.getFirstName().equals("Jane")) {
            assertEquals(Person.Gender.F, person.getGender());
        } else {
            assertEquals(Person.Gender.M, person.getGender());
        }
        assertEquals("Doe", person.getLastName());
        assertEquals(1990, 	person.getDateOfBirth().getYear());
    }

    //ArgumentsAggregor 인터페이스를 구현해서 더 쉽게 사용할 수도 있다.
    @ParameterizedTest
    @CsvSource({
            "Jane, Doe, F, 1990-05-20",
            "John, Doe, M, 1990-10-22"
    }) void testWithArgumentsAggregator(@AggregateWith(PersonAggregator.class) Person person)
    {
    }

    //아니면 커스텀 인터페이스를 만들어 손쉽게 사용할 수 있음.
    @ParameterizedTest
    @CsvSource({
            "Jane, Doe, F, 1990-05-20",
            "John, Doe, M, 1990-10-22"
    })
    void testWithCustomAggregatorAnnotation(@CsvToPerson Person person) {
// perform assertions against person
    }
}
