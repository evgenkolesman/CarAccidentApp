package di.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//@Scope("prototype")
public class StartUI {

    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput consoleInput;

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        store.getAll().forEach(System.out :: println);
    }
    
    public void printConsole(String value) {
        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.print(value);
    }

    public List<String> getAll() {
        return new Store().getAll();
    }
}
