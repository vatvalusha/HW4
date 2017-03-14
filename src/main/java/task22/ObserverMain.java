package task22;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valerii Artemenko on 12.03.2017.
 */
public class ObserverMain {
    public static void main(String[] args) throws IOException {
        PostOffice postOffice = new PostOffice();
        postOffice.addObserve(new ConsoleObserve());
        postOffice.addObserve(new FileWriteObserve());
        postOffice.setMeasurements(4, "Central street");
        postOffice.setMeasurements(10, "Maydan Nezalegnosty Street");
    }
}

interface Observable {
    void addObserve(Observer o);

    void removeObserve(Observer o);

    void notifyObserver() throws IOException;
}

class PostOffice implements Observable {

    int countNewEdition;
    String address;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int c, String a) throws IOException {
        countNewEdition = c;
        address = a;
        notifyObserver();
    }

    public void addObserve(Observer o) {
        observers.add(o);
    }

    public void removeObserve(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() throws IOException {
        for (Observer o : observers) {
            o.handleEvent(countNewEdition, address);
        }
    }
}

interface Observer {
    void handleEvent(int countNewEdition, String address) throws IOException;
}

class ConsoleObserve implements Observer {
    public void handleEvent(int countNewEdition, String address) {
        System.out.println("New post. Count " + countNewEdition + " Address Post Office: " + address);
    }
}

class FileWriteObserve implements Observer {
    public void handleEvent(int countNewEdition, String address) throws IOException {
        File file;
        file = File.createTempFile("New Post", "_txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print("New post. Count " + countNewEdition + " Address Post Office: " + address);
        writer.println();
        writer.close();
    }
}
