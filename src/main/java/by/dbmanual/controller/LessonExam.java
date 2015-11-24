package by.dbmanual.controller;

import by.dbmanual.model.NoSuchTaskException;
import by.dbmanual.view.LessonExamView;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class LessonExam {
    private List<Task> tasks = new ArrayList<>();
    private Task currentTask = null;

    private LessonExamView view = new LessonExamView();

    public LessonExam(String [] taskResourceNames) {
        for (String taskResourceName: taskResourceNames) {
            try {
                Task task = new Task(taskResourceName);
                tasks.add(task);
            } catch (NoSuchTaskException e) {
                e.printStackTrace();
            }
        }
        view.getNextButton().addEventFilter(ActionEvent.ACTION, event -> {
            Task task = nextTask();
            if (task != null) {
                view.setTask(task.getView());
                event.consume();
            }
        });
    }

    public void start() {
        if (!tasks.isEmpty()) {
            currentTask = firstTask();
            view.setTask(currentTask.getView());
            view.showAndWait();
        }
    }

    private Task firstTask() {
        if (!tasks.isEmpty()) {
            currentTask = tasks.get(0);
        } else {
            currentTask = null;
        }
        return currentTask;

    }

    private Task nextTask() {
        int index;
        if (currentTask != null) {
            index = tasks.indexOf(currentTask);
            if (index + 1 < tasks.size()) {
                currentTask = tasks.get(index + 1);
            } else {
                currentTask = null;
            }
        }

        return currentTask;
    }
}
