package com.main.connector;

import com.main.operation.Operation;
import com.main.source.Source;

import java.util.List;
import java.util.stream.Collectors;

public final class Connector<T> {

    private final List<Source<T>> sources;
    private final Operation<T> operation;

    public T getResult() {
        return operation.action(sources);
    }

    public Connector(ConnectorBuilder<T> builder) {
        this.sources = builder.sources.stream().collect(Collectors.toList());
        this.operation = builder.operation;
    }

    public static class ConnectorBuilder<T> {

        private List<Source<T>> sources;
        private Operation<T> operation;

        private ConnectorBuilder() {
        }

        public static ConnectorBuilder newInstance() {
            return new ConnectorBuilder();
        }

        public ConnectorBuilder setSources(List<Source<T>> sources) {
            this.sources = sources;
            return this;
        }

        public ConnectorBuilder setOperation(Operation<T> operation) {
            this.operation = operation;
            return this;
        }

        public Connector build() {
            return new Connector(this);
        }
    }

}
