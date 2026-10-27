package com.hitms.lab01;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.GREEN;

import org.fusesource.jansi.AnsiConsole;

/**
 * Uses Jansi, the first extra package pulled in by Maven, to print the lab
 * greeting in green.
 */
public final class Colors {

    /** Prevents instantiation of this demo class. */
    private Colors() {
    }

    /**
     * Prints the greeting in green.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        System.out.println(ansi().fg(GREEN).a("Hello, Software Construction!").reset());
        AnsiConsole.systemUninstall();
    }
}
