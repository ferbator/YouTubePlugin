package com.ferbator.youtubeplugin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class YouTubeForm extends JFrame {
    private JLabel prevInput;
    private JTextField jtInput;
    private JButton searchButton;
    private JPanel youtubeForm;
    private JTextArea textArea1;

    public YouTubeForm() {
        setSize(400, 600);
        setContentPane(youtubeForm);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchButton.addActionListener(e -> {
            String input = jtInput.getText();
            Search search = new Search();

            textArea1.append(search.SearchYouTube(input));
            Desktop desk = Desktop.getDesktop();
            textArea1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) //making sure there was a double click
                    {
                        int x = e.getX();
                        int y = e.getY();

                        int startOffset = textArea1.viewToModel2D(new Point(x, y));
                        String text = textArea1.getText();
                        int searchHttp;
                        int wordEndIndex;
                        String[] words = text.split("\\s");

                        for (String word : words) {
                            if (word.startsWith("https://") || word.startsWith("http://")) {
                                searchHttp = text.indexOf(word);
                                wordEndIndex = searchHttp + word.length();
                                if (startOffset >= searchHttp && startOffset <= wordEndIndex)//after the link word was found, making sure the double click was made on this link
                                {
                                    try {
                                        textArea1.select(searchHttp, wordEndIndex);
                                        desk.browse(new URI(word)); //opening the link in browser. Desktop desk = Desktop.getDesktop();
                                    } catch (Exception exception) {
                                        exception.printStackTrace();
                                    }

                                }
                            }
                        }
                    }
                }
            });
        });

        setVisible(true);
    }
}
