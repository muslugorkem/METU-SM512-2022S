/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.java_essentials;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Serkan
 */
public class JavaEssentialsStreamTrials {

    public static class HexOutputStream extends OutputStream {

        private final PrintStream stream;

        public HexOutputStream(PrintStream stream) {
            this.stream = stream;
        }

        @Override
        public void write(int b) throws IOException {
            if (b < 0) {
                b += 256;
            }
            stream.format("%02x ", b);
        }

        public void newLine() {
            stream.println();
        }

    }

    public JavaEssentialsStreamTrials() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void tryDataOutputStream() throws IOException {
        HexOutputStream stHex = new HexOutputStream(System.out);
        DataOutputStream stData = new DataOutputStream(stHex);
        stData.writeInt(1);
        stHex.newLine();
        stData.writeDouble(3.0);
        stHex.newLine();
        stData.writeChars("A");
        stHex.newLine();
        stData.writeUTF("hello world");
        stHex.newLine();
        stData.write("hello world".getBytes("utf-8"));
        stHex.newLine();
        stData.write("hello world".getBytes("US-ASCII"));
        stHex.newLine();
        stData.write("hello world".getBytes("UTF-16"));
        stHex.newLine();
    }

    @Test
    public void tryPrintWriter() throws IOException {
        HexOutputStream stHex = new HexOutputStream(System.out);

        PrintWriter p = new PrintWriter(stHex);

        p.print("hello world");
        p.flush();
        stHex.newLine();
        p.println("hello world");
        p.flush();
        stHex.newLine();
        p.print(1234);
        p.flush();
        stHex.newLine();
    }

    @Test
    public void tryObjectOutputStream() throws IOException {
        HexOutputStream stHex = new HexOutputStream(System.out);
        ObjectOutputStream stObj = new ObjectOutputStream(stHex);

        stObj.writeObject("hello world");
        stHex.newLine();
        stObj.writeObject(new int[]{1, 2, 3});
        stHex.newLine();
    }
}
