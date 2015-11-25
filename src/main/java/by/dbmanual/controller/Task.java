package by.dbmanual.controller;

import by.dbmanual.model.NoSuchTaskException;
import by.dbmanual.model.Profile;
import by.dbmanual.utils.DataBase;
import by.dbmanual.utils.InternalisationUtils;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.sql.SQLException;
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
    private BooleanProperty isCompleted = new SimpleBooleanProperty(false);

    public Task(String resourceName) throws NoSuchTaskException {
        try {
            this.resourceName = resourceName;

            ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceName);

            createTablesScriptResource = resourceBundle.getString("create");
            dropTablesScriptResource = resourceBundle.getString("drop");
            answerScriptResource = resourceBundle.getString("answer");

            initView(resourceBundle);
        } catch (MissingResourceException e) {
            throw new NoSuchTaskException(String.format("Task resource (\"%s\") not found", resourceName));
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
            alert.setTitle(InternalisationUtils.getString("task.result"));
            Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);

            boolean isCompleted = false;

            try {
                String [][] userAnswer = runCode();

                alert.getDialogPane().setContent(createAnswerTable(userAnswer));

                if (isCompleted = checkAnswer(userAnswer)) {
                    alert.setHeaderText(InternalisationUtils.getString("task.success"));
                    okButton.setText(InternalisationUtils.getString("task.nextTask"));
                } else {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setHeaderText(InternalisationUtils.getString("task.error"));
                    okButton.setText(InternalisationUtils.getString("task.tryAgain"));
                }
            } catch (SQLException e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setHeaderText(InternalisationUtils.getString("task.syntaxError"));
                okButton.setText(InternalisationUtils.getString("task.tryAgain"));
                alert.setContentText(e.getLocalizedMessage());
            }
            alert.showAndWait();
            this.isCompleted.set(isCompleted);
        });

        HBox hBox = new HBox(answerTextArea, runButton);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        vBox = new VBox(10, webView, answerLabel, hBox);
        vBox.setFillWidth(true);
        vBox.setPadding(new Insets(10));
    }

    private TableView<String[]> createAnswerTable(String[][] answer) {
        TableView<String []> stringTableView = new TableView<>();

        for (int i = 0; i < answer[0].length; ++i) {
            TableColumn<String[], String> tableColumn = new TableColumn<>(answer[0][i]);
            final int columnIndex = i;
            tableColumn.setCellValueFactory(param -> {
                String a = param.getValue()[columnIndex];
                return new SimpleStringProperty(a);
            });
            stringTableView.getColumns().add(tableColumn);
        }

        for (int i = 1; i < answer.length; ++i) {
            stringTableView.getItems().addAll(answer[i]);
        }
        return stringTableView;
    }

    private boolean checkAnswer(String[][] userAnswer) {
        boolean result = Arrays.deepEquals(userAnswer, answer);
        Profile.getProfile().addAttempt(this, result);
        return result;
    }

    private String[][] runCode() throws SQLException {
        return dataBase.query(answerTextArea.getText());
    }

    public void start() {
        dataBase = new DataBase();
        dataBase.execute(createTablesScriptResource);
        try {
            answer = dataBase.queryFromResource(answerScriptResource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public boolean getIsCompleted() {
        return isCompleted.get();
    }

    public BooleanProperty isCompletedProperty() {
        return isCompleted;
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
