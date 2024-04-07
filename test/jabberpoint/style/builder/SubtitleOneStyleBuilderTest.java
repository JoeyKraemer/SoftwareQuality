package jabberpoint.style.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtitleOneStyleBuilderTest {
    private SubtitleOneStyleBuilder subtitleOneStyleBuilder;

    @BeforeEach
    void setup()
    {
        this.subtitleOneStyleBuilder = new SubtitleOneStyleBuilder();
    }

    @Test
    void setIndent_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            subtitleOneStyleBuilder.setIndent(-1);
        });
    }

    @Test
    void setIndent_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            subtitleOneStyleBuilder.setIndent(0);
        });
    }

    @Test
    void setIndent_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            subtitleOneStyleBuilder.setIndent(1);
        });
    }

    @Test
    void setFontSize_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            subtitleOneStyleBuilder.setFontSize(-1);
        });
    }

    @Test
    void setFontSize_zero_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            subtitleOneStyleBuilder.setFontSize(0);
        });
    }

    @Test
    void setFontSize_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            subtitleOneStyleBuilder.setFontSize(1);
        });
    }

    @Test
    void setLeading_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            subtitleOneStyleBuilder.setLeading(-1);
        });
    }

    @Test
    void setLeading_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            subtitleOneStyleBuilder.setLeading(0);
        });
    }

    @Test
    void setLeading_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            subtitleOneStyleBuilder.setLeading(1);
        });
    }
}