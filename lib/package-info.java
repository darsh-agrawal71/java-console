/**
 * <h3>Library package</h3>
 * <ul>
 *     <li>{@link lib.ui}: Main library package, dependant on {@link lib.util}.
 *         <ul>
 *             <li>{@link lib.ui.components}: Base UI components to quickly build a UI.</li>
 *             <li>{@link lib.ui.contracts}: Interfaces/Abstract Classes for defining what UI elements should be and do.</li>
 *             <li>{@link lib.ui.navigation}: Provides Navigator class which navigates between {@link lib.ui.contracts.UIScreen}s.</li>
 *             <li>{@link lib.services}: Contains `ServiceCallback`, a callback interface that should be used in all services as a way to get the result of the service.</li>
 *         </ul>
 *     </li>
 *     <li>{@link lib.util}: Provides utility classes, {@link lib.ui} depends on util.</li>
 *     <li>{@link lib.util}: Provides ways to prompt user for input. Provides two basic input prompt classes, and a base interface for custom prompts.</li>
 * </ul>
 */
package lib;