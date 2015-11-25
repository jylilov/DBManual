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

    private double intelligence = 1;

    private Profile() {}

    private class TaskResult {
        private boolean isCompleted = false;
        private int attemptsCount = 0;
    }

    private Map<Task, TaskResult> statisticsMap = new HashMap<>();

    public void addAttempt(Task task, boolean isCompleted) {
        TaskResult taskResult;
        if (statisticsMap.containsKey(task)) {
            taskResult = statisticsMap.get(task);
        } else {
            taskResult = new TaskResult();
            statisticsMap.put(task, taskResult);
        }
        taskResult.attemptsCount++;
        taskResult.isCompleted = isCompleted;
    }
}
