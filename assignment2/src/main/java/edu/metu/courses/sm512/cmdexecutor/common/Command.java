package edu.metu.courses.sm512.cmdexecutor.common;

import java.io.PrintStream;

public interface Command {

    public String getCommandName();

    public void execute(PrintStream out, String params);

    public String getUsage();
}
