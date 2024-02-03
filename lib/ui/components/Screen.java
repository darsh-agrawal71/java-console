package lib.ui.components;

public class Screen {
    public static final int width = 50;

    public static void clear() {
        try {
            ProcessBuilder process = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = process.inheritIO().start();
            startProcess.waitFor();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
