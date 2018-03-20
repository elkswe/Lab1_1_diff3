package coord.bl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class checkBelongingTest {

    @ParameterizedTest
    @MethodSource("trueCoordinateProvider")
    void checkTrueCoord(float x, float y) {
        assertTrue(checkBelonging.check(x, y), "Bad coordinate check.");
    }

    static Stream<Arguments> trueCoordinateProvider() {
        return Stream.of(
                Arguments.of(0f, 0f),
                Arguments.of(4f, 5f),
                Arguments.of(-6f, -3f),
                Arguments.of(-3f, 3f)
        );
    }

    @ParameterizedTest
    @MethodSource("falseCoordProvider")
    void checkFalseCoord(float x, float y) {
        assertFalse(checkBelonging.check(x, y), "Bad coordinate check.");
    }

    static Stream<Arguments> falseCoordProvider() {
        return Stream.of(
                Arguments.of(-7f, 6f),
                Arguments.of(6f, 3f),
                Arguments.of(0f, -4f),
                Arguments.of(-7f, -3f)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "-"})
    void correctDataEmptyAndMinusString(String source) {
        assertFalse(checkBelonging.correctData(source), "Bad data check.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12.345", "34.654"})
    void correctDataCorrectString(String source) {
        assertTrue(checkBelonging.correctData(source), "Bad converting.");
    }
}