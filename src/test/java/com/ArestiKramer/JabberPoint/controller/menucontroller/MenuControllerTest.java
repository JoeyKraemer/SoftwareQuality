package com.ArestiKramer.JabberPoint.controller.menucontroller;

import com.ArestiKramer.JabberPoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.mockito.Mockito.*;

class MenuControllerTest {

    private MenuController menuController;
    private Presentation presentationStub;
    private Frame frameStub;

    @BeforeEach
    void setup() {
        presentationStub = mock(Presentation.class);
        frameStub = mock(Frame.class);
        menuController = new MenuController(frameStub, presentationStub);
    }

    @Test
    void nextSlideMenuItem_callNextSlideCommand_oneExecution() {
        simulateMenuItemAction(menuController.getViewMenu(), "Next");
        verify(presentationStub, times(1)).nextSlide();
    }

    @Test
    void previousSlideMenuItem_callPreviousSlideCommand_oneExecution() {
        simulateMenuItemAction(menuController.getViewMenu(), "Previous");
        verify(presentationStub, times(1)).previousSlide();
    }

    private void simulateMenuItemAction(Menu menu, String itemName) {
        for (int i = 0; i < menu.getItemCount(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.getLabel().equals(itemName)) {
                for (ActionListener listener : menuItem.getActionListeners()) {
                    ActionEvent event = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, itemName);
                    listener.actionPerformed(event);
                }
                break;
            }
        }
    }
}