package by.dbmanual.controller;

import by.dbmanual.model.NoSuchTaskException;
import by.dbmanual.utils.DataBase;
import by.dbmanual.utils.InternalisationUtils;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Task {

    private final String resourceName;

    private VBox vBox;
    private String createTablesScriptResource;
    private String dropTablesScriptResource;
    private String answerScriptResource;

    private DataBase dataBase;
    private String [][] answer;
    private TextArea answerTextArea;

    public Task(String resourceName) throws NoSuchTaskException {
        try {
            this.resourceName = resourceName;

            ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceName);

            createTablesScriptResource = resourceBundle.getString("create");
            dropTablesScriptResource = resourceBundle.getString("drop");
            answerScriptResource = resourceBundle.getString("answer");

            initView(resourceBundle);
        } catch (MissingResourceException e) {
            throw new NoSuchTaskException("Task resource (\"%s\") not found");
        }
    }

    private void initView(ResourceBundle resourceBundle) {
        WebView webView = new WebView();
        webView.setPrefHeight(400);
        webView.getEngine().load(Task.class.getResource(resourceBundle.getString("task")).toExternalForm());

        answerTextArea = new TextArea();
        answerTextArea.setPromptText(InternalisationUtils.getString("task.answerPrompt"));
        answerTextArea.setPrefRowCount(4);

        Label answerLabel = new Label(InternalisationUtils.getString("task.answerLabel"));
        answerLabel.setLabelFor(answerTextArea);

        Button runButton = new Button(InternalisationUtils.getString("task.run"));
        runButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            String [][] userAnswer = runCode();
            String text = checkAnswer(userAnswer) ? "RIGHT" : "FALSE";
            alert.setContentText(Arrays.deepToString(userAnswer).replaceAll("],", "],\n") + "\n" + text);
            alert.showAndWait();
        });

        vBox = new VBox(10, webView, answerLabel, new HBox(answerTextArea, runButton));
        vBox.setFillWidth(true);
        vBox.setPadding(new Insets(10));
    }

    private boolean checkAnswer(String[][] userAnswer) {
        return Arrays.deepEquals(userAnswer, answer);
    }

    private String[][] runCode() {
        return dataBase.query(answerTextArea.getText());
    }

    public void start() {
        dataBase = new DataBase();
        dataBase.execute(createTablesScriptResource);
        answer = dataBase.queryFromResource(answerScriptResource);
    }

    public void finish() {
        if (dataBase != null) {
            dataBase.execute(dropTablesScriptResource);
            dataBase.close();
        }
    }

    public Node getView() {
        return vBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return resourceName.equals(task.resourceName);

    }

    @Override
    public int hashCode() {
        return resourceName.hashCode();
    }
}
