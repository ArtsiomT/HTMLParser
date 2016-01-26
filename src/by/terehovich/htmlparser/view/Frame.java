package by.terehovich.htmlparser.view;

import by.terehovich.htmlparser.model.Validate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aterehovich on 26.1.16.
 */
public class Frame extends JFrame {

    private final static String TITLE = "HTML Parser";
    private final static String URL_TITLE = "Url to parse: ";
    private final static String START_TAG = "Element begins with: ";
    private final static String END_TAG = "Element ends with: ";
    private final static String START_BUTTON_TITLE = "Parse";
    private final static String RESULT_TITLE = "Result: ";

    private final static int URL_TITTLE_SIZE = 30;
    private final static int TAG_SIZE = 8;

    private final JPanel urlPanel = new JPanel(new FlowLayout());
    private final JLabel urlTitleLabel = new JLabel(URL_TITLE);
    private final JTextField urlField = new JTextField(URL_TITTLE_SIZE);

    private final JPanel tagPanel = new JPanel(new GridLayout(3, 2));
    private final JLabel startTagTitleLabel = new JLabel(START_TAG);
    private final JTextField startTagField = new JTextField(TAG_SIZE);

    private final JLabel endTagTitleLabel = new JLabel(END_TAG);
    private final JTextField endTagField = new JTextField(TAG_SIZE);

    private final JButton startButton = new JButton(START_BUTTON_TITLE);

    private final JPanel resultPanel = new JPanel();
    private final JLabel resultTitle = new JLabel(RESULT_TITLE);
    private final JTextArea resultTextArea = new JTextArea(10, 20);

    public Frame(){
        initialize();
        addActions();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initialize(){
        this.setTitle(TITLE);
        urlTitleLabel.setLabelFor(urlField);
        startTagTitleLabel.setLabelFor(startTagField);
        endTagTitleLabel.setLabelFor(endTagField);
        resultTitle.setLabelFor(resultTextArea);

        startButton.setPreferredSize(new Dimension(40, 20));

        urlPanel.add(urlTitleLabel);
        urlPanel.add(urlField);

        tagPanel.add(startTagTitleLabel);
        tagPanel.add(startTagField);
        tagPanel.add(endTagTitleLabel);
        tagPanel.add(endTagField);
        tagPanel.add(startButton);

        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.add(resultTitle);
        resultPanel.add(resultTextArea);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(urlPanel);
        this.add(tagPanel);
        this.add(resultPanel);
        this.pack();
    }

    private void addActions(){
        this.startButton.addActionListener(e -> {
            StringBuffer result = new StringBuffer();
            this.resultTextArea.setText("");
            boolean hasErrors = false;
            String url = "";
            String startTag = "";
            String endTag = "";
            if(Validate.getAndCheckText(this.urlField)){
                url = Validate.getResult();
            } else {
                result.append("Error with url field\n");
                hasErrors = true;
            }
            if(Validate.getAndCheckText(this.startTagField)){
                startTag = Validate.getResult();
            } else {
                result.append("Error with start tag field\n");
                hasErrors = true;
            }
            if(Validate.getAndCheckText(this.endTagField)){
                endTag = Validate.getResult();
            } else {
                result.append("Error with end tag field\n");
                hasErrors = true;
            }

            if (!hasErrors){
                //TODO: startParse
            } else {
                this.resultTextArea.setText(result.toString());
            }
        });
    }
}
