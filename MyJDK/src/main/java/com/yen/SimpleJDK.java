package com.yen;

import javax.tools.*;
import java.io.*;
import java.util.*;

public class SimpleJDK {
    public static void main(String[] args) throws Exception {
        // Java source code to compile
//        String program = """
//            public class HelloWorld {
//                public static void main(String[] args) {
//                    System.out.println("Hello, World!");
//                }
//            }
//        """;

        String program = "some string program";

        // Save the code to a file
        String fileName = "HelloWorld.java";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(program);
        }

        // Compile the code
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, fileName);

        if (result == 0) {
            System.out.println("Compilation successful!");

            // Run the compiled program
            Process process = Runtime.getRuntime().exec("java HelloWorld");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } else {
            System.out.println("Compilation failed.");
        }
    }
}