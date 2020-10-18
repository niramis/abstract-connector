package com.main.source;

@FunctionalInterface
public interface Source<T> {
    T getValue();
}
