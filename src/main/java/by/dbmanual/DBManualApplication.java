package by.dbmanual;

import by.dbmanual.controller.Lesson;
import by.dbmanual.controller.LessonExam;
import by.dbmanual.model.NoSuchLessonException;
import by.dbmanual.model.Profile;
import by.dbmanual.model.TaskModel;
import by.dbmanual.utils.InternalisationUtils;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.AllPermission;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class DBManualApplication extends Application {
    private List<Lesson> lessonList = new LinkedList<>();
    private Label splash;
    private ToolBar toolBar;
    private BorderPane root;
    private MenuItem userRatingMenuItem;

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

        MenuBar menuBar = new MenuBar();

        Menu profileMenu = new Menu(InternalisationUtils.getString("app.menu.profile"));
        userRatingMenuItem = new MenuItem(InternalisationUtils.getString("app.menu.ratingLabel"));
        userRatingMenuItem.setOnAction(event -> updateMenuProfile());
        Profile.getProfile().intelligenceProperty().addListener((observable, oldValue, newValue) -> updateMenuProfile());
        MenuItem clearRatingMenuItem = new MenuItem(InternalisationUtils.getString("app.menu.newUser"));
        clearRatingMenuItem.setOnAction(event -> {
            updateMenuProfile();
            Profile.getProfile().clearIntelligence();
        });
        profileMenu.getItems().addAll(userRatingMenuItem, clearRatingMenuItem);

        Menu testMenu = new Menu(InternalisationUtils.getString("app.menu.tests"));
        Menu testForLessonMenuItem = new Menu(InternalisationUtils.getString("app.menu.testForLesson"));
        for (Lesson l: lessonList) {
            MenuItem menuItem = new MenuItem(l.getName());
            menuItem.setOnAction(event -> l.startLessonExam());
            testForLessonMenuItem.getItems().add(menuItem);
        }
        MenuItem finalTestMenuItem = new MenuItem(InternalisationUtils.getString("app.menu.allTests"));
        testMenu.getItems().addAll(testForLessonMenuItem, finalTestMenuItem);

        List<String> list = TaskModel.getAllTaskModels().stream().map(TaskModel::getResourceName).collect(Collectors.toCollection(LinkedList::new));
        LessonExam exam = new LessonExam(list.toArray(new String[list.size()]), 10);
        finalTestMenuItem.setOnAction(event -> exam.start());

        Menu aboutMenu = new Menu(InternalisationUtils.getString("app.menu.help"));
        MenuItem helpMenuItem = new MenuItem(InternalisationUtils.getString("app.menu.help"));
        aboutMenu.getItems().add(helpMenuItem);
        helpMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(InternalisationUtils.getString("app.menu.help"));
            alert.setHeaderText(InternalisationUtils.getString("app.menu.helpHeader"));
            WebView webView = new WebView();
            webView.setPrefHeight(400);
            webView.setPrefWidth(500);
            webView.getEngine().load(DBManualApplication.class.getResource(InternalisationUtils.getString("app.menu.helpContentHtmlResource")).toExternalForm());
            alert.getDialogPane().setContent(webView);
            alert.showAndWait();
        });

        updateMenuProfile();
        menuBar.getMenus().addAll(profileMenu, testMenu, aboutMenu);

        root.setTop(menuBar);

        root.setLeft(toolBar);
        root.setCenter(splash);

        primaryStage.setScene(scene);
        primaryStage.setTitle(InternalisationUtils.getString("app.dbManual"));
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
        splash = new Label(InternalisationUtils.getString("app.chooseLesson"));
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

    private void updateMenuProfile() {
        userRatingMenuItem.setText(String.format("%s %.2f",
                InternalisationUtils.getString("app.menu.ratingLabel"),
                Profile.getProfile().getIntelligence()));
    }
}
