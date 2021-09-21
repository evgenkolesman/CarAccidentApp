package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartUI {

    private Store store;
    private ConsoleInput consoleInput;

    public StartUI(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }


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
