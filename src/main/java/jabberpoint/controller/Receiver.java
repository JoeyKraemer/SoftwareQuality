package jabberpoint.controller;

/**
 * <p>This is the Receiver, its the bridge between the controller and the presentation</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/05/28
 */

public interface Receiver
{

    void executeCommand(Command command);
}
