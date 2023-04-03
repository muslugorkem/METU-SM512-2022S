package edu.metu.courses.sm512.cmdexecutor.common;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class CommandManager {

    public final Command HELP = new Command() {
        @Override
        public String getCommandName() {
            return "help";
        }

        @Override
        public void execute(PrintStream out, String args) {
            for (Command cmd : CommandManager.this.getCommands()) {
                out.println(cmd.getUsage());
            }
        }

        @Override
        public String getUsage() {
            return "help ; Displays all available commands and their usages";
        }
    };

    public static final Command ECHO = new Command() {

        @Override
        public String getCommandName() {
            return "echo";
        }

        @Override
        public void execute(PrintStream out, String args) {
            if (args.trim().length() == 0) {
                throw new IllegalArgumentException();
            }
            out.println(args);
        }

        @Override
        public String getUsage() {
            return "echo <arguments>; Parameters are printed back to the output";
        }
    };

    private final Map<String, Command> commandMap;

    public CommandManager() {
        commandMap = new LinkedHashMap<>(); //remembers insertion order
    }

    public void registerPackageCommands(String packageName, boolean sorted) {
        CommandLoader loader = new CommandLoader();
        Iterable<Command> commands = loader.getAvailableCommands(packageName, sorted);
        //Add available commands in the package to the command map
        for (Command cmd : commands) {
            registerCommand(cmd);
        }
    }

    public void registerCommand(Command command) {
        if (commandMap.put(command.getCommandName(), command) != null) {
            throw new IllegalArgumentException("Command was already registered");
        }
    }

    public Iterable<Command> getCommands() {
        return commandMap.values();
    }

    public Command get(String cmdstr) {
        Command cmd = commandMap.get(cmdstr);
        return cmd;
    }

    public void execute(PrintStream out, String cmdstr) {
        String param = "";
        int spacepos = cmdstr.indexOf(' ');
        if (spacepos > 0) {
            param = cmdstr.substring(spacepos + 1);
            cmdstr = cmdstr.substring(0, spacepos);
        }
        Command cmd = this.get(cmdstr.toLowerCase(Locale.US));
        if (cmd == null) {
            out.println("Use command HELP to get a list of available commands");
        } else
            try {
            cmd.execute(out, param);
        } catch (Exception ex) {
            out.println("ERROR:");
            out.println(ex);
            out.println("USAGE:");
            out.println(cmd.getUsage());
        }
    }

}
