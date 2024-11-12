package org.example.controller;
import org.example.models.CourseDAOImpl;
import org.example.view.ConsoleView;
import org.example.view.View;


public class App {
    Presenter p;
    View ui;
    CourseDAOImpl model;

    public App() {
        ui = new ConsoleView();
        model = new CourseDAOImpl();
        p = new Presenter(ui, model);
    }

    public void start() {
        StringBuilder sb = new StringBuilder()
                .append("\n ==MENU== \n")
                .append("1 - add Course\n")
                .append("2 - show all Courses\n")
                .append("3 - change Course\n")
                .append("4 - delete Course\n")
                .append("0 - exit\n");


        while (true) {
            ui.set(sb.toString());
            switch (ui.get()) {
                case "1":
                    p.append();
                    break;
                case "2":
                    p.show();
                    break;
                case "3":
                    p.change();
                    break;
                case "4":
                    p.delete();
                    break;
                case "0":
                    return;
            }
        }
    }
}
