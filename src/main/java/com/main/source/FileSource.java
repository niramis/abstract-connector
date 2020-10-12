package com.main.source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSource implements Source {
    private int value;

    public FileSource() {
        this.value = loadNumber();
    }

    private int loadNumber() {
        int result;
        try {
            result = Integer.valueOf(new String(Files.readAllBytes(Paths.get("number.txt"))));
        } catch (IOException e) {
            result = 1;
        }
        return result;
    }

    @Override
    public int getValue() {
        return value;
    }
}
