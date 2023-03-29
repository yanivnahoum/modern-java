package com.att.tlv.training.java.exercises.switches;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class SwitchExpressionsTest {

    @Mock private Logger logger;

    @ParameterizedTest
    @CsvSource({
            "NORTH, 0",
            "EAST, 90",
            "SOUTH, 180",
            "WEST, 270",
    })
    void directionToAzimuth(Direction direction, int expectedAzimuth) {
        int actualAzimuth = SwitchExpressions.directionToAzimuth(direction);
        assertThat(actualAzimuth).isEqualTo(expectedAzimuth);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            10, ten,
            20, twenty,
            30, thirty,
            50, unexpected, 'Unexpected value: 50'
            100, unexpected, 'Unexpected value: 100'
            """)
    void toName(int value, String expectedName, String expectedLog) {
        String actualName = SwitchExpressions.toName(value, logger);
        assertThat(actualName).isEqualTo(expectedName);
        if (expectedLog != null) {
            verify(logger).info(expectedLog);
        }
    }
}