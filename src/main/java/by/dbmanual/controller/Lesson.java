package by.dbmanual.controller;

import by.dbmanual.model.NoSuchLessonException;
import by.dbmanual.model.NoSuchTheoryException;
import by.dbmanual.utils.InternalisationUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Lesson {
    private LessonExam lessonExam;
    private Theory theory;
    private String name;

    private VBox vBox;

    public Lesson(String resourceName) throws NoSuchLessonException {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceName);
            name = resourceBundle.getString("name");
            theory = new Theory(resourceBundle.getString("theory"));
            lessonExam = new LessonExam(resourceBundle.getString("tasks").split(","));
            initView();
        } catch (MissingResourceException | NoSuchTheoryException e) {
            throw new NoSuchLessonException(e);
        }
    }

    private void initView() {
        Button checkKnowledgeButton = new Button(InternalisationUtils.getString("lesson.checkKnowledge"));
        checkKnowledgeButton.setOnAction(event -> lessonExam.start());

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_RIGHT);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().add(theory.getView());
        vBox.getChildren().add(checkKnowledgeButton);
    }

    public Node getView() {
        return vBox;
    }

    public String getName() {
        return name;
    }
}
