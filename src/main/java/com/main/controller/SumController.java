package com.main.controller;

import com.main.operation.AddOperation;
import com.main.connector.Connector;
import com.main.source.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SumController {

    @GetMapping(path = "/connector")
    public Integer value() {
        List<Source<Integer>> sources = Arrays.asList(new RestSource(), new FileSource());
        Connector<Integer> connector = Connector.ConnectorBuilder.newInstance().setSources(sources).setOperation(new AddOperation()).build();
        return connector.getResult();
    }

}
