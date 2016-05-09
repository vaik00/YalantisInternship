package com.internship.yalantis.task2.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonManager {
    public JsonManager(){}
    private static JsonManager sInstance = new JsonManager();

    public static JsonManager getInstance() {
        return sInstance;
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return outputStream.toString();
    }
    
}
