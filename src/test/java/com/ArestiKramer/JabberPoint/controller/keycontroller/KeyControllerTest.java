package com.ArestiKramer.JabberPoint.controller.keycontroller;

import com.ArestiKramer.JabberPoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

public class KeyControllerTest {

    private static class PresentationStub extends Presentation {
        int nextSlideCalls = 0;
        int previousSlideCalls = 0;
        int exitCalls = 0;

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
        presentation = mock(PresentationStub.class);
        keyController = new KeyController(presentation);
    }

    @Test
    void nextSlideCommand_caseNextSlide_fourExecutions() {
        KeyEvent keyEvent1 = mock(KeyEvent.class);
        when(keyEvent1.getKeyCode()).thenReturn(KeyEvent.VK_PAGE_DOWN);

        KeyEvent keyEvent2 = mock(KeyEvent.class);
        when(keyEvent2.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);

        KeyEvent keyEvent3 = mock(KeyEvent.class);
        when(keyEvent3.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);

        KeyEvent keyEvent4 = mock(KeyEvent.class);
        when(keyEvent4.getKeyChar()).thenReturn('+');

        keyController.keyPressed(keyEvent1);
        keyController.keyPressed(keyEvent2);
        keyController.keyPressed(keyEvent3);
        keyController.keyPressed(keyEvent4);

        verify(presentation, times(4)).nextSlide();
    }

    @Test
    void previousSlideCommand_casePreviousSlide_threeExecutions() {
        KeyEvent keyEvent1 = mock(KeyEvent.class);
        when(keyEvent1.getKeyCode()).thenReturn(KeyEvent.VK_PAGE_UP);

        KeyEvent keyEvent2 = mock(KeyEvent.class);
        when(keyEvent2.getKeyCode()).thenReturn(KeyEvent.VK_UP);

        KeyEvent keyEvent3 = mock(KeyEvent.class);
        when(keyEvent3.getKeyChar()).thenReturn('-');

        keyController.keyPressed(keyEvent1);
        keyController.keyPressed(keyEvent2);
        keyController.keyPressed(keyEvent3);

        verify(presentation, times(3)).previousSlide();
    }
}