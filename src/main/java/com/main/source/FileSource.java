package com.main.source;

import com.main.source.Source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSource implements Source<Integer> {
    private Integer value;

    public FileSource() {
        this.value = loadNumber();
    }

    private Integer loadNumber() {
        int result;
        try {
            result = Integer.valueOf(new String(Files.readAllBytes(Paths.get("number.txt"))));
        } catch (IOException e) {
            result = 1;
        }
        return result;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
