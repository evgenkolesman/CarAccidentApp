package di;

import java.util.List;

public class StartUI {
    private Store store;
    private ConsoleInput consoleInput;

//    public StartUI(Store store) {
//        this.store = store;
//    }

    public StartUI(ConsoleInput consoleInput) {
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
