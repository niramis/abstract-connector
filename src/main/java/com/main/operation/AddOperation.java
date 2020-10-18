package com.main.operation;

import com.main.source.Source;

import java.util.List;
import java.util.stream.Collectors;

public class AddOperation implements Operation<Integer> {
    @Override
    public Integer action(List<Source<Integer>> sources) {
        return sources.stream()
                .collect(Collectors.summingInt(Source<Integer>::getValue));
    }
}
