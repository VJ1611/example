package com.cts.assignments.cts.assignments.util;

import java.io.*;

public class FileUtil {

    public static void closewriteObjects(FileOutputStream fileOut, ObjectOutputStream objectOut) {
        try {
            if(objectOut != null) {
                objectOut.close();
            }

            if(fileOut != null) {
                fileOut.close();
            }
        } catch (IOException e) {
            System.out.println("Exception occured while closing file" + e.getMessage());
        }
    }


    public static void closeReadObjects(FileInputStream fileIn, ObjectInputStream in) {
        try {
            if (fileIn != null)
                fileIn.close();

            if (in != null)
                in.close();
        } catch (IOException e) {
            System.out.println("Exception occured while closing file" + e.getMessage());
        }
    }
}
