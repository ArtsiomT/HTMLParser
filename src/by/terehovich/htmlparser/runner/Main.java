package by.terehovich.htmlparser.runner;

import by.terehovich.htmlparser.view.Frame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame());
    }
}
