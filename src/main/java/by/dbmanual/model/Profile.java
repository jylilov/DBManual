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
            double v = Math.max(0, 0.05 * (task.getDifficulty() - intelligence + 1));
            intelligence += v;
            task.setDifficulty(task.getDifficulty() - 0.1 * v);
        } else {
            double v = Math.max(0, 0.01 * (intelligence - task.getDifficulty() + 1));
            intelligence -= v;
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
        double v = Math.max(0, 0.05 * (intelligence - task.getDifficulty() + 1));
        intelligence -= v;
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
        return intelligence;
    }

}
