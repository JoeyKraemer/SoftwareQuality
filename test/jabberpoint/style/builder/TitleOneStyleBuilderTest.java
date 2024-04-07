package jabberpoint.style.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TitleOneStyleBuilderTest {
    private TitleOneStyleBuilder titleOneStyleBuilder;

    @BeforeEach
    void setup()
    {
        this.titleOneStyleBuilder = new TitleOneStyleBuilder();
    }

    @Test
    void setIndent_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleOneStyleBuilder.setIndent(-1);
        });
    }

    @Test
    void setIndent_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleOneStyleBuilder.setIndent(0);
        });
    }

    @Test
    void setIndent_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleOneStyleBuilder.setIndent(1);
        });
    }

    @Test
    void setFontSize_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleOneStyleBuilder.setFontSize(-1);
        });
    }

    @Test
    void setFontSize_zero_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleOneStyleBuilder.setFontSize(0);
        });
    }

    @Test
    void setFontSize_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleOneStyleBuilder.setFontSize(1);
        });
    }

    @Test
    void setLeading_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleOneStyleBuilder.setLeading(-1);
        });
    }

    @Test
    void setLeading_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleOneStyleBuilder.setLeading(0);
        });
    }

    @Test
    void setLeading_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleOneStyleBuilder.setLeading(1);
        });
    }
}