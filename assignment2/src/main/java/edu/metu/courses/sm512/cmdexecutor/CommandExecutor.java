/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.cmdexecutor;

/**
 *
 * @author YourName
 */
import edu.metu.courses.sm512.cmdexecutor.common.Command;
import edu.metu.courses.sm512.cmdexecutor.common.CommandManager;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandExecutor {

    private static boolean terminated;

    static Command quit = new Command() {

        @Override
        public String getCommandName() {
            return "quit";
        }

        @Override
        public void execute(PrintStream out, String args) {
            terminated = true;
        }

        @Override
        public String getUsage() {
            return "quit ; Exits application";
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CommandManager manager = new CommandManager();
        //Register commands
        String shapesPackage = edu.metu.courses.sm512.cmdexecutor.common.Command.class.getPackage().getName();
        shapesPackage = shapesPackage.replace(".common", ".shapes");
        manager.registerPackageCommands(shapesPackage, true);
        manager.registerCommand(CommandManager.ECHO);
        manager.registerCommand(manager.HELP);
        manager.registerCommand(quit);
        //Print welcome messages
        System.out.println("--- Welcome to the SM512 command execution engine ---");
        //Get user input and execute command
        Scanner scanner = new Scanner(System.in);
        while (!terminated) {
            System.out.print(">"); //Display prompt
            String cmdstr = scanner.nextLine();
            manager.execute(System.out, cmdstr);
        }
    }

}
