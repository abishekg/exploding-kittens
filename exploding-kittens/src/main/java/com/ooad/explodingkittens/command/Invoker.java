package com.ooad.explodingkittens.command;

/**
 * Reflects Command Invoker in Command Design Pattern
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void runCommand() {
        command.execute();
    }
}
