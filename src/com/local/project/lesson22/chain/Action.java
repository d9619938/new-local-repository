package com.local.project.lesson22.chain;

public abstract class Action {
    private Action nextAction;
    public void nextAction(Action nextAction) {
        this.nextAction = nextAction;
    }

    public void executeNext(){
        execute();
        if(this.nextAction != null) this.nextAction.executeNext();
    }

    protected abstract void execute();
}
