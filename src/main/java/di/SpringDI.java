package di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("di");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Evgen Koles");
        ui.print();
        Store another = context.getBean(Store.class);
        another.add("Ivan ivanov");
        another.add("Alex Alexov");
        another.getAll().forEach(System.out::println);
        ui.printConsole("Sergey Gavrilov");

    }
}
