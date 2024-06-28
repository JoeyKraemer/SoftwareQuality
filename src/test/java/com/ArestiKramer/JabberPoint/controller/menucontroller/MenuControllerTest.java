package com.ArestiKramer.JabberPoint.controller.menucontroller;

import com.ArestiKramer.JabberPoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;

class MenuControllerTest {

    private MenuController menuController;
    private PresentationStub presentationStub;
    private Frame frameStub;

    private static class PresentationStub extends Presentation {

        int openCalls = 0;
        int exitCalls = 0;
        int nextSlideCalls = 0;
        int previousSlideCalls = 0;

        @Override
        public void clear() {
            openCalls++;
        }

        @Override
        public void exit() {
            exitCalls++;
        }

        @Override
        public void nextSlide() {
            nextSlideCalls++;
        }

        @Override
        public void previousSlide() {
            previousSlideCalls++;
        }
    }

    @BeforeEach
    void setup() {
        System.setProperty("java.awt.headless", "true");
        presentationStub = new PresentationStub();
        frameStub = new Frame();
        menuController = new MenuController(frameStub, presentationStub);
    }

    @Test
    void nextSlideMenuItem_callNextSlideCommand_oneExecution() {
        simulateMenuItemAction(menuController.getViewMenu(), "Next");
        assertEquals(1, presentationStub.nextSlideCalls);
    }

    @Test
    void previousSlideMenuItem_callPreviousSlideCommand_oneExecution() {
        simulateMenuItemAction(menuController.getViewMenu(), "Previous");
        assertEquals(1, presentationStub.previousSlideCalls);
    }

    private void simulateMenuItemAction(Menu menu, String itemName) {
        for (int i = 0; i < menu.getItemCount(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.getLabel().equals(itemName)) {
                ActionListener actionListener = menuItem.getActionListeners()[0];
                ActionEvent actionEvent = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, menuItem.getActionCommand());
                actionListener.actionPerformed(actionEvent);
                break;
            }
        }
    }
}