/**
 * <h3>Application package</h3>
 * <ul>
 *  <li>{@link app}: Example application which demonstrates use of library.
 *      <ul>
 *          <li>{@link app.views}: Package that contains all screens of the application. All screen-related classes are prefixed with the screen name (e.g AScreen, AScreenOptions).<br>
 *              Screen classes have naming convention of ending with `Screen` (e.g AScreen).</li>
 *          <li>{@link app.components}: Package that hosts custom UI components that extend {@link lib.ui.contracts.CustomUIElement}. <br>
 *              They build upon the base components or custom components, but always result in the base components defined in {@link lib.ui.components}. </li>
 *          <li>{@link app.services}: Contains basic service example. Services are used as high-level abstraction from the data, providing user-friendly and readable methods to do work.</li>
 *          <li>{@link app.models}: Models are used as data classes in services. They serve as a high-level abstraction from the actual data.</li>
 *      </ul>
 *  </li>
 * </ul>
 */
package app;