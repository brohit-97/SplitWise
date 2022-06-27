package com.lld.splitwise.commands;

public interface Command {

    boolean parse(String commandLine);

    void execute(String command);
}
