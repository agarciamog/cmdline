package io.albertogarcia.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if( args.length == 0 ) {
            System.out.println("\nNo arguements were passed.");
            return;
        }

        String fileName = args[0];
        if(!Files.exists(Paths.get(fileName))) {
            System.out.println("\nNo file exist.");
            return;
        }
        printFileLines(fileName);
    }

    private static void printFileLines(String fileName) {
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String s;
            while((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getClass().getSimpleName() + " - " + ioe.getMessage());
        }
    }
}
