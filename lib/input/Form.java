package lib.input;

/**
 * Component that is used to combine many {@link InputPrompt}s into one.
 * Example:
 * <pre>
 *     // Coordinate.java
 *     package example;
 *     public class Coordinate { public int x, y; }
 *
 *     // CoordinateForm.java
 *     package example;
 *     import lib.input.*;
 *     public class CoordinateForm extends Form&lt; Coordinate&gt; {
 *          &#064;Override
 *          public Coordinate ask() {
 *              int x = IntegerInputPrompt.promptUserWithPrompt("x:").getResult();
 *              int y = IntegerInputPrompt.promptUserWithPrompt("y:").getResult();
 *              Coordinate c = new Coordinate();
 *              c.x = x;
 *              c.y = y;
 *              return c;
 *          }
 *     }
 * </pre>
 * @param <T> The return type of the prompted data.
 */
public interface Form<T> {
    T ask();
}
