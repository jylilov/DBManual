package by.dbmanual.model;

import java.util.*;

public class TaskModel {
    private final String resourceName;
    private double difficulty;

    private final String createTablesScriptResource;
    private final String dropTablesScriptResource;
    private final String answerScriptResource;

    private static final Map<String, TaskModel> taskMap = new HashMap<>();

    private TaskModel(String resourceName) {
        this.resourceName = resourceName;

        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceName);

        createTablesScriptResource = resourceBundle.getString("create");
        dropTablesScriptResource = resourceBundle.getString("drop");
        answerScriptResource = resourceBundle.getString("answer");

        difficulty = Double.valueOf(resourceBundle.getString("difficultyLevel"));
    }

    public static TaskModel getTaskModel(String resourceName) {
        TaskModel model = taskMap.get(resourceName);
        if (model == null) {
            model = new TaskModel(resourceName);
            taskMap.put(resourceName, model);
        }
        return model;
    }

    public static Collection<TaskModel> getAllTaskModels() {
        return taskMap.values();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskModel taskModel = (TaskModel) o;

        return resourceName.equals(taskModel.resourceName);

    }

    @Override
    public int hashCode() {
        return resourceName.hashCode();
    }

    public String getResourceName() {
        return resourceName;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public String getCreateTablesScriptResource() {
        return createTablesScriptResource;
    }

    public String getDropTablesScriptResource() {
        return dropTablesScriptResource;
    }

    public String getAnswerScriptResource() {
        return answerScriptResource;
    }
}
