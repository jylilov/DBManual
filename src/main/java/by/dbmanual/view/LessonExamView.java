package by.dbmanual.view;

import by.dbmanual.utils.InternalisationUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class LessonExamView extends Dialog {
    public LessonExamView() {
        getDialogPane().getButtonTypes().add(ButtonType.NEXT);
        getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        getNextButton().setText(InternalisationUtils.getString("lessonExam.nextTask"));
        getCancelButton().setText(InternalisationUtils.getString("lessonExam.cancel"));
    }

    public Button getNextButton() {
        return (Button) getDialogPane().lookupButton(ButtonType.NEXT);
    }

    public Button getCancelButton() {
        return (Button) getDialogPane().lookupButton(ButtonType.CANCEL);
    }

    public void setTask(Node taskView) {
        getDialogPane().setContent(taskView);
    }
}
