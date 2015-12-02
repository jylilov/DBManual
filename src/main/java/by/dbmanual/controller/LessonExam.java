package by.dbmanual.controller;

import by.dbmanual.model.NoSuchTaskException;
import by.dbmanual.model.Profile;
import by.dbmanual.utils.InternalisationUtils;
import by.dbmanual.view.LessonExamView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LessonExam {
    private static final int NEAREST_TASK_COUNT = 8;
    private static final Random random = new Random(137);

    private List<Task> tasks = new ArrayList<>();

    private Task currentTask;

    private final int taskToComplete;
    private int completedTaskCount;

    private LessonExamView view = new LessonExamView();

    public LessonExam(String [] taskResourceNames, int taskToComplete) {
        this.taskToComplete = taskToComplete;
        for (String taskResourceName: taskResourceNames) {
            try {
                Task task = new Task(taskResourceName);
                tasks.add(task);
                task.isCompletedProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        taskCompleted(currentTask);
                    }
                });
            } catch (NoSuchTaskException e) {
                e.printStackTrace();
            }
        }

        view.getSkipButton().addEventFilter(ActionEvent.ACTION, event -> {
            skipTask(currentTask);
            event.consume();
        });
        view.getCancelButton().addEventFilter(ActionEvent.ACTION, event -> currentTask.finish());
    }

    private void taskCompleted(Task task) {
        task.finish();
        ++completedTaskCount;
        if (completedTaskCount == taskToComplete) {
            view.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(InternalisationUtils.getString("lessonExam.successTitle"));
            alert.setHeaderText(InternalisationUtils.getString("lessonExam.success"));
            alert.setContentText(InternalisationUtils.getString("lessonExam.successMessage"));
            alert.showAndWait();
        } else {
            startTask(getNextTask());
        }
    }

    private void startTask(Task task) {
        view.setTitle(String.format("%s (%.2f) User (%.2f)",
                task.getModel().getResourceName(),
                task.getModel().getDifficulty(),
                Profile.getProfile().getIntelligence()));
        task.start();
        currentTask = task;
        view.setTask(task.getView());
    }

    private void skipTask(Task task) {
        Profile.getProfile().skip(task.getModel());
        task.finish();
        startTask(getNextTask());
    }

    public void start() {
        completedTaskCount = 0;
        startTask(getNextTask());
        view.showAndWait();
    }

    private Task getNextTask() {
        List<Task> list = new ArrayList<>();

        tasks.stream().filter(task -> !Profile.getProfile().isSkipped(task.getModel())
                && !Profile.getProfile().isCompleted(task.getModel())).forEach(list::add);

        if (list.size() < NEAREST_TASK_COUNT) {
            List<Task> shuffled = new ArrayList<>(tasks);
            Collections.shuffle(shuffled);
            while (list.size() < NEAREST_TASK_COUNT || list.size() != tasks.size()) {
                for (Task t : shuffled) {
                    if (!list.contains(t)) {
                        list.add(t);
                        break;
                    }
                }
            }
        }

        final double difficulty = Profile.getProfile().getIntelligence();
        list.sort((o1, o2) -> {
            double d1 = o1.getModel().getDifficulty() - difficulty;
            if (d1 < 0) d1 *= 2;
            double d2 = o2.getModel().getDifficulty() - difficulty;
            if (d2 < 0) d2 *= 2;
            return (int) Math.round(Math.abs(d1) - Math.abs(d2));
        });

        return list.get(random.nextInt(Math.min(list.size(), NEAREST_TASK_COUNT)));
    }
}
