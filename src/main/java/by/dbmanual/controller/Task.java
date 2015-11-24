package by.dbmanual.controller;

import by.dbmanual.model.NoSuchTaskException;
import by.dbmanual.utils.InternalisationUtils;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Task {

    private final VBox vBox;

    public Task(String resourceName) throws NoSuchTaskException {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceName);

            WebView webView = new WebView();
            webView.setPrefHeight(400);
            webView.getEngine().load(Task.class.getResource(resourceBundle.getString("task")).toExternalForm());

            TextArea answerTextArea = new TextArea();
            answerTextArea.setPromptText(InternalisationUtils.getString("task.answerPrompt"));
            answerTextArea.setPrefRowCount(4);

            Label answerLabel = new Label(InternalisationUtils.getString("task.answerLabel"));
            answerLabel.setLabelFor(answerTextArea);

            vBox = new VBox(10, webView, answerLabel, answerTextArea);
            vBox.setFillWidth(true);
            vBox.setPadding(new Insets(10));
        } catch (MissingResourceException e) {
            throw new NoSuchTaskException("Task resource (\"%s\") not found");
        }
    }

    public Node getView() {
        return vBox;
    }
}
