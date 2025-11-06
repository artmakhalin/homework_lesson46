package task02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import task02.exception.ProgrammerBusyException;
import task02.exception.TaskNotDoneException;
import task02.exception.TeamLeadBusyException;
import task02.exception.TeamLeadUnavailableNowException;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TeamLeadTest {

    @Test
    void doTaskSuccessTest() {
        Programmer jack = new Programmer("Jack", Status.AVAILABLE);
        Programmer john = new Programmer("John", Status.AVAILABLE);
        Programmer mike = new Programmer("Mike", Status.AVAILABLE);

        TeamLead teamLead = new TeamLead("Lena", List.of(
                jack,
                john,
                mike
        ), Status.AVAILABLE);
        String actualResult = teamLead.doTask("task");
        String expectedResult = "Jack is doing task: TASK";

        assertAll(
                () -> assertDoesNotThrow(() -> teamLead.doTask("task")),
                () -> assertEquals(expectedResult, actualResult)
        );
    }

    static Stream<Arguments> doTaskNegativeArguments() {
        Programmer jackAvailable = new Programmer("Jack", Status.AVAILABLE);
        Programmer johnBusy = new Programmer("John", Status.BUSY);
        Programmer mikeAvailable = new Programmer("Mike", Status.AVAILABLE);
        Programmer alexUnavailable = new Programmer("Alex", Status.UNAVAILABLE);
        return Stream.of(
                Arguments.of(
                        new TeamLead("Lena",
                                List.of(
                                        jackAvailable,
                                        mikeAvailable
                                ),
                                Status.UNAVAILABLE
                        ),
                        TeamLeadUnavailableNowException.class,
                        "Lena is unavailable"
                ),
                Arguments.of(
                        new TeamLead("Lena",
                                List.of(
                                        jackAvailable,
                                        mikeAvailable
                                ),
                                Status.BUSY
                        ),
                        TeamLeadBusyException.class,
                        "Lena is busy with other task"
                ),
                Arguments.of(
                        new TeamLead("Lena",
                                List.of(
                                        johnBusy,
                                        alexUnavailable
                                ),
                                Status.AVAILABLE
                        ),
                        TaskNotDoneException.class,
                        "All programmers are busy or unavailable"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("doTaskNegativeArguments")
    void doTaskNegativeTest(TeamLead teamLead, Class<? extends Throwable> clazz, String errMessage) {
        assertThrows(clazz, () -> teamLead.doTask("task"), errMessage);
    }
}