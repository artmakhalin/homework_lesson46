package task02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import task02.Programmer;
import task02.exception.ProgrammerBusyException;
import task02.exception.ProgrammerUnavailableNowException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammerTest {
    @Test
    void doWorkSuccessTest() {
        Programmer jack = new Programmer("Jack", Status.AVAILABLE);
        String actualResult = jack.doWork("work");
        String expectedResult = "Jack is doing task: WORK";
        assertAll(
                assertDoesNotThrow(() -> jack.doWork("work")),
                () -> assertEquals(expectedResult, actualResult)
        );
    }

    static Stream<Arguments> doWorkNegativeArguments() {
        return Stream.of(
                Arguments.of(
                        new Programmer("Jack", Status.UNAVAILABLE),
                        ProgrammerUnavailableNowException.class,
                        "Jack is unavailable"
                ),
                Arguments.of(
                        new Programmer("John", Status.BUSY),
                        ProgrammerBusyException.class,
                        "John is busy with other task"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("doWorkNegativeArguments")
    void doWorkNegativeTest(Programmer programmer, Class<? extends Throwable> clazz, String errMessage) {
        assertThrows(clazz, () -> programmer.doWork("task"), errMessage);
    }
}