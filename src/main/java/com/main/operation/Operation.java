package com.main.operation;

import com.main.source.Source;

import java.util.List;

public interface Operation<T> {
    T action(List<Source<T>> sources);

}
