package lib.ui.contracts;

/**
 * Represents an application that can be initialized.
 */
public interface Application {
    /**
     * Entry point for application.
     * Responsible for:
     * <ul>
     *     <li>Initializing application</li>
     *     <li>Running pre-render tasks</li>
     *     <li>Returning the initial screen instance</li>
     * </ul>
     * @return The initial screen that needs to be rendered.
     */
    UIScreen initializeApp();
}
