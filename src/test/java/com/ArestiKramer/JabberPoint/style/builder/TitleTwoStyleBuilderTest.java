package com.ArestiKramer.JabberPoint.style.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleTwoStyleBuilderTest {
    private TitleTwoStyleBuilder titleTwoStyleBuilder;

    @BeforeEach
    void setup()
    {
        this.titleTwoStyleBuilder = new TitleTwoStyleBuilder();
    }

    @Test
    void setIndent_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleTwoStyleBuilder.setIndent(-1);
        });
    }

    @Test
    void setIndent_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleTwoStyleBuilder.setIndent(0);
        });
    }

    @Test
    void setIndent_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleTwoStyleBuilder.setIndent(1);
        });
    }

    @Test
    void setFontSize_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleTwoStyleBuilder.setFontSize(-1);
        });
    }

    @Test
    void setFontSize_zero_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleTwoStyleBuilder.setFontSize(0);
        });
    }

    @Test
    void setFontSize_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleTwoStyleBuilder.setFontSize(1);
        });
    }

    @Test
    void setLeading_negativeOne_expectException() {
        assertThrows(IllegalArgumentException.class, () -> {
            titleTwoStyleBuilder.setLeading(-1);
        });
    }

    @Test
    void setLeading_zero_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleTwoStyleBuilder.setLeading(0);
        });
    }

    @Test
    void setLeading_one_expectNoException()
    {
        assertDoesNotThrow( () -> {
            titleTwoStyleBuilder.setLeading(1);
        });
    }
}