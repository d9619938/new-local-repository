package com.local.project.lesson22.strategy;

public class RunFast implements IAction<Unit>{
    @Override
    public void execute(Unit unit) {
        System.out.println("unit runfast");
    }
}
