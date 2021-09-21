package di;

import org.springframework.stereotype.Component;

@Component
public class ConsoleInput {

    public void print(String value) {
        System.out.println(value);
    }
}
