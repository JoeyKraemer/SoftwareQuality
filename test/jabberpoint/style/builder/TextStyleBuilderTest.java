package jabberpoint.style.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextStyleBuilderTest {
    private TextStyleBuilder textStyleBuilder;

    @BeforeEach
    void setup()
    {
        this.textStyleBuilder = new TextStyleBuilder();
    }

    @Test
    void setIndent_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            textStyleBuilder.setIndent(-1);
        });
    }

    @Test
    void setIndent_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            textStyleBuilder.setIndent(0);
        });
    }

    @Test
    void setIndent_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            textStyleBuilder.setIndent(1);
        });
    }

    @Test
    void setFontSize_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            textStyleBuilder.setFontSize(-1);
        });
    }

    @Test
    void setFontSize_zero_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            textStyleBuilder.setFontSize(0);
        });
    }

    @Test
    void setFontSize_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            textStyleBuilder.setFontSize(1);
        });
    }

    @Test
    void setLeading_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            textStyleBuilder.setLeading(-1);
        });
    }

    @Test
    void setLeading_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            textStyleBuilder.setLeading(0);
        });
    }

    @Test
    void setLeading_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            textStyleBuilder.setLeading(1);
        });
    }
}