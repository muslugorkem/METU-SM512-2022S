package edu.metu.courses.sm512.cmdexecutor.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandLoader {

    public static final Comparator<Command> COMMAND_BY_NAME_COMPARATOR = new Comparator<>() {
        @Override
        public int compare(Command o1, Command o2) {
            return o1.getCommandName().compareTo(o2.getCommandName());
        }
    };

    public Iterable<Command> getAvailableCommands(String packageName, boolean sortedByName) {
        List<Command> commands = new ArrayList<>();
        try {
            Class[] classes = getClasses(packageName);
            for (Class c : classes) {
                if (Modifier.isAbstract(c.getModifiers())) {
                    continue;
                }
                if (Command.class.isAssignableFrom(c)) {
                    Command d = (Command) c.getDeclaredConstructor().newInstance();
                    if (d != null) {
                        commands.add(d);
                    }
                }
            }
        } catch (InvocationTargetException | NoSuchMethodException | ClassNotFoundException | IOException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(CommandLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sortedByName) {
            commands.sort(COMMAND_BY_NAME_COMPARATOR);
        }
        return commands;
    }

    /**
     * Scans all classes accessible from the context class loader which belong
     * to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * Recursive method used to find all classes in a given directory and
     * subdirs.
     *
     * @param directory The base directory
     * @param packageName The package name for classes found inside the base
     * directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List findClasses(File directory, String packageName) throws ClassNotFoundException {
        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
