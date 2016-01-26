package by.terehovich.htmlparser.model;

import javax.swing.*;

/**
 * Created by aterehovich on 26.1.16.
 */
public class Validate {
    private static String result;

    public static boolean getAndCheckText(JTextField textField){
        String text = textField.getText().trim();
        if (text != null && !text.isEmpty()){
            result = text;
            return true;
        } else {
            return false;
        }
    }

    public static String getResult(){
        return result;
    }
}
