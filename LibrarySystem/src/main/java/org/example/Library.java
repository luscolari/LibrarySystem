package org.example;
import java.awt.print.Book;
import java.util.*;
import java.io.Serializable;

public class Library implements Serializable {
    private final List <Book> collection;
    public Library(){
        collection = new ArrayList<Book>();
    }
    public void addBooks (Book book){
        collection.add(book);
    }
    public void removeBooks(Book book){
        collection.remove(book);
    }
    @Override
    public String toString(){
        String total = "\n";
        Iterator <Book> i = collection.iterator();
        while (i.hasNext()){
            Book b = (Book) i.next();
            total = total + b.toString();
        }
        return total;
    }

    public void addBooks(org.example.Book b) {
        collection.add(b);
    }
}
