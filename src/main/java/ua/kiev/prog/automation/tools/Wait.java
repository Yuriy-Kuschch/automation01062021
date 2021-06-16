package ua.kiev.prog.automation.tools;

public class Wait {

    static public void sleep(long ms) {
        try { Thread.sleep(2000); } catch (Throwable e) {/* Ignore */} // Wait 5 sec
    }
}
