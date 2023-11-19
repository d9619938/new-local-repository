package com.local.project.lesson22.strategy;

public class Unit{
    private IAction action;

    public Unit(IAction action) {
        if (action == null) throw new IllegalArgumentException("not null");
        this.action = action;
    }

  public void changeAction(IAction action) {
        if (action != null)
        this.action = action;
  }

    public void move() {
        action.execute(this);
    }

    public static void main(String[] args) {
        Unit unit = new Unit(new Walk());
        unit.move();
        unit.changeAction(new Run());
        unit.move();
        unit.changeAction(new RunFast());
        unit.move();
    }

}
