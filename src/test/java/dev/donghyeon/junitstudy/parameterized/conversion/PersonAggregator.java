package dev.donghyeon.junitstudy.parameterized.conversion;

import dev.donghyeon.junitstudy.Person;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.time.LocalDate;

public class PersonAggregator implements ArgumentsAggregator {
    @Override
    public Person aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        return new Person(arguments.getString(0),
                arguments.getString(1),
                arguments.get(2, Person.Gender.class),
                arguments.get(3, LocalDate.class));
    }
}
