package com.main.source;

import com.main.source.Source;
import org.springframework.web.client.RestTemplate;

public class RestSource implements Source<Integer> {

    private Integer value;
    private final String url = "https://www.random.org/integers/?num=1&min=10&max=20&col=1&base=10&format=plain&rnd=new";

    public RestSource() {
        this.value = loadValue();
    }

    private Integer loadValue() {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = Integer.valueOf(restTemplate.getForObject(url, String.class).replace("\n", ""));
        return result;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
