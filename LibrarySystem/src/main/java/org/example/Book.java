package org.example;

import java.io.Serializable;

public class Book extends java.awt.print.Book implements Serializable {
    private String title, author;
    private int pages;
    private boolean read;

    public Book(){
        title = null;
        author = null;
        pages = 0;
        read = false;
    }
    public Book(String title, String author, int pages, boolean read){
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.read = read;
    }

    @Override
    public String toString() {
        return "org.example.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", read='" + read + '\'' +
                ", pages=" + pages +
                '}';
    }
}
