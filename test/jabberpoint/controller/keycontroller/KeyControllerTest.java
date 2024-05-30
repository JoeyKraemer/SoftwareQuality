package jabberpoint.controller.keycontroller;

import jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class KeyControllerTest
{

    private static class PresentationStub extends Presentation
    {
        int nextSlideCalls = 0;
        int previousSlideCalls = 0;
        int exitCalls = 0;

        // Methods need to be overwritten otherwise no way of tracking the execution calls
        @Override
        public void nextSlide() {
            nextSlideCalls++;
        }

        @Override
        public void previousSlide() {
            previousSlideCalls++;
        }

        @Override
        public void exit() {
            exitCalls++;
        }

    }

    private PresentationStub presentation;
    private KeyController keyController;

    @BeforeEach
    void setup() {
        presentation = new PresentationStub();
        keyController = new KeyController(presentation);
    }

    @Test
    void nextSlideCommand_caseNextSlide_fourExecutions() {
        keyController.keyPressed(new KeyEvent(new java.awt.Label(),KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 0, '+'));

        assertEquals(4, presentation.nextSlideCalls);
    }

    @Test
    void previousSlideCommand_casePreviousSlide_threeExecutions() {
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 0, '-'));

        assertEquals(3, presentation.previousSlideCalls);
    }

    @Test
    void quitCommand_caseQuit_oneExecutions() {
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_Q, 'q'));

        assertEquals(1, presentation.exitCalls);
    }
}

