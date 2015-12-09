package by.dbmanual.model;

import by.dbmanual.controller.Task;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.HashMap;
import java.util.Map;

public class Profile {
    private static final double DEFAULT_INTELLIGENCE = 2.0;
    private static Profile profile = null;

    public static Profile getProfile() {
        if (profile == null) {
            profile = new Profile();
        }
        return profile;
    }

    private DoubleProperty intelligence = new SimpleDoubleProperty(DEFAULT_INTELLIGENCE);

    private Profile() {}

    public void clearIntelligence() {
        intelligence.set(DEFAULT_INTELLIGENCE);
    }

    private class TaskResult {
        private boolean isCompleted = false;
        private boolean isSkipped = false;
        private int attemptsCount = 0;
    }

    private Map<TaskModel, TaskResult> statisticsMap = new HashMap<>();

    public void addAttempt(TaskModel task, boolean isCompleted) {
        TaskResult taskResult = getTaskResult(task);
        taskResult.attemptsCount++;
        taskResult.isCompleted = isCompleted;
        taskResult.isSkipped = false;

        if (isCompleted) {
            double v = Math.max(0, 0.05 * (task.getDifficulty() - intelligence.get() + 1));
            intelligence.setValue(intelligence.get() + v);
            task.setDifficulty(task.getDifficulty() - 0.1 * v);
        } else {
            double v = Math.max(0, 0.01 * (intelligence.get() - task.getDifficulty() + 1));
            intelligence.setValue(intelligence.get() - v);
            task.setDifficulty(task.getDifficulty() + 0.1 * v);
        }

        System.out.printf("User[%.3f] %s %s[%.3f]%n",
                Profile.getProfile().getIntelligence(),
                isCompleted ? "success attempt" : "error attempt",
                task.getResourceName(),
                task.getDifficulty());
    }

    private TaskResult getTaskResult(TaskModel task) {
        TaskResult taskResult;
        if (statisticsMap.containsKey(task)) {
            taskResult = statisticsMap.get(task);
        } else {
            taskResult = new TaskResult();
            statisticsMap.put(task, taskResult);
        }
        return taskResult;
    }

    public void skip(TaskModel task) {
        TaskResult taskResult = getTaskResult(task);
        taskResult.isSkipped = true;
        double v = Math.max(0, 0.05 * (intelligence.get() - task.getDifficulty() + 1));
        intelligence.setValue(intelligence.get() - v);
        task.setDifficulty(task.getDifficulty() + 0.1 * v);
    }

    public void hint(TaskModel task) {
        TaskResult taskResult = getTaskResult(task);
        double v = Math.max(0, 0.025 * (intelligence.get() - task.getDifficulty() + 1));
        intelligence.setValue(intelligence.get() - v);
        task.setDifficulty(task.getDifficulty() + 0.1 * v);
    }

    public boolean isSkipped(TaskModel task) {
        boolean result;
        if (result = statisticsMap.containsKey(task)) {
            result = statisticsMap.get(task).isSkipped;
        }
        return result;
    }

    public boolean isCompleted(TaskModel task) {
        boolean result;
        if (result = statisticsMap.containsKey(task)) {
            result = statisticsMap.get(task).isCompleted;
        }
        return result;
    }

    public double getIntelligence() {
        return intelligence.get();
    }

    public DoubleProperty intelligenceProperty() { return intelligence; }

}
