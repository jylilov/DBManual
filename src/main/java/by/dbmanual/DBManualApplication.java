package by.dbmanual;

import by.dbmanual.model.Lesson;
import by.dbmanual.model.NoSuchLessonException;
import by.dbmanual.utils.InternalisationUtils;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DBManualApplication extends Application {
    private List<Lesson> lessonList = new LinkedList<>();
    private Label splash;
    private ToolBar toolBar;
    private BorderPane root;

    public static void main(String []args) {
        DBManualApplication.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        initSplash();
        initLessonList();
        initToolBar();

        root.setLeft(toolBar);
        root.setCenter(splash);

        primaryStage.setScene(scene);
        primaryStage.setTitle(InternalisationUtils.getString("app.db_manual"));
        primaryStage.show();
    }

    private void initToolBar() {
        toolBar = new ToolBar();
        toolBar.setOrientation(Orientation.VERTICAL);
        ToggleGroup lessonToggleGroup = new ToggleGroup();
        for (Lesson lesson: lessonList) {
            ToggleButton toggleButton = new ToggleButton(lesson.getName());
            lessonToggleGroup.getToggles().add(toggleButton);
            toolBar.getItems().add(toggleButton);
            toggleButton.setUserData(lesson);
        }


        lessonToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Lesson lesson = (Lesson) newValue.getUserData();
                root.setCenter(lesson.getView());
            } else {
                root.setCenter(splash);
            }
        });
    }

    private void initSplash() {
        splash = new Label(InternalisationUtils.getString("app.choose_lesson"));
        splash.setFont(new Font(30));
        splash.setTextFill(Color.GRAY);
    }

    private void initLessonList() throws IOException {
        Properties properties = new Properties();
        properties.load(DBManualApplication.class.getResourceAsStream("/lessons.properties"));

        for (String lessonResourceName: properties.getProperty("lessons_list").split(",")) {
            try {
                Lesson lesson = new Lesson(lessonResourceName);
                lessonList.add(lesson);
            } catch (NoSuchLessonException e) {
                e.printStackTrace();
            }
        }
    }
}
