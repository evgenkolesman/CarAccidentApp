package di;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<String> data = new ArrayList<>();


    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
