package lib.util;

public class ConsoleClearer {
    public void clearConsole() {
        try {
            ProcessBuilder process = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = process.inheritIO().start();
            startProcess.waitFor();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
