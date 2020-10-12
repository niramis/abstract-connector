package com.main.connector;

import com.main.operation.Operation;
import com.main.source.Source;

import java.util.List;
import java.util.stream.Collectors;

final public class Connector {

    private final List<Source> sources;
    private final Operation operation;

    public int getResult() {
        return operation.action(sources);
    }

    public Connector(ConnectorBuilder builder) {
        this.sources = builder.sources.stream().collect(Collectors.toList());
        this.operation = builder.operation;
    }

    public static class ConnectorBuilder {

        private List<Source> sources;
        private Operation operation;

        private ConnectorBuilder() {
        }

        public static ConnectorBuilder newInstance() {
            return new ConnectorBuilder();
        }

        public ConnectorBuilder setSources(List<Source> sources) {
            this.sources = sources;
            return this;
        }

        public ConnectorBuilder setOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public Connector build() {
            return new Connector(this);
        }
    }

}
