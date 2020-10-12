package com.main.controller;

import com.main.connector.Connector;
import com.main.operation.AddOperation;
import com.main.source.FileSource;
import com.main.source.RestSource;
import com.main.source.Source;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SumController {

    @GetMapping(path = "/connector")
    public int value() {
        List<Source> sources = Arrays.asList(new RestSource(), new FileSource());
        Connector connector = Connector.ConnectorBuilder.newInstance().setSources(sources).setOperation(new AddOperation()).build();
        return connector.getResult();
    }
}
