package com.main.operation;

import com.main.source.Source;

import java.util.List;
import java.util.stream.Collectors;

public class AddOperation implements Operation {
    @Override
    public int action(List<Source> sources) {
        return sources.stream()
                .collect(Collectors.summingInt(Source::getValue));
    }
}
