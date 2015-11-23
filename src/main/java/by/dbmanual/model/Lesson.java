package by.dbmanual.model;

import by.dbmanual.utils.InternalisationUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Lesson {
    private Theory theory;
    private String name;

    private VBox vBox;

    public Lesson(String resourceName) throws NoSuchLessonException {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceName);
            name = resourceBundle.getString("name");
            theory = new Theory(resourceBundle.getString("theory"));
            initView();
        } catch (MissingResourceException | NoSuchTheoryException e) {
            throw new NoSuchLessonException(e);
        }
    }

    private void initView() {
        vBox = new VBox();
        vBox.getChildren().add(theory.getView());
        vBox.getChildren().add(new Button(InternalisationUtils.getString("lesson.check_knowledge")));
    }

    public Node getView() {
        return vBox;
    }

    public String getName() {
        return name;
    }
}
