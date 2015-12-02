package by.dbmanual.model;

import by.dbmanual.controller.Task;

import java.util.HashMap;
import java.util.Map;

public class Profile {
    private static Profile profile = null;

    public static Profile getProfile() {
        if (profile == null) {
            profile = new Profile();
        }
        return profile;
    }

    private double intelligence = 2;

    private Profile() {}

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
        return intelligence;
    }

}
