package org.bootcamp.latam.model;

public class SessionState {
    private DialogAction dialogAction;
    private Intent intent;

    public SessionState() {
        dialogAction=new DialogAction();
        intent=new Intent();
    }

    public DialogAction getDialogAction() {
        return dialogAction;
    }

    public void setDialogAction(DialogAction dialogAction) {
        this.dialogAction = dialogAction;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @Override
    public String toString() {
        return "SessionState{" +
                "dialogAction=" + dialogAction +
                ", intent=" + intent +
                '}';
    }
}
