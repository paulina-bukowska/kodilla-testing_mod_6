package com.kodilla.testing.library;

import java.util.*;

public class BookLibrary {
    LibraryDatabase libraryDatabase;
    Book book;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

//    założenia:
//    - Jeżeli liczba zwróconych wyników będzie większa niż 20, wówczas metoda ma zwracać pustą listę
//    - Jeżeli ilość znaków w ciągu titleFragment będzie mniejsza niż trzy, również ma zwrócić pustą listę
//    - W pozostałych przypadkach ma zwrócić listę obiektów typu Book spełniających kryteria wyszukiwania
    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3)
            return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20)
            return bookList;
        bookList = resultList;
        return bookList;
    }

    public boolean rentABook(LibraryUser libraryUser, Book book) {
        Map<LibraryUser, List<Book>> borrowedBooks = new HashMap<LibraryUser, List<Book>>();

        boolean available = true;
        if(libraryDatabase.listBooksInHandsOf(libraryUser).contains(book)) {
            available = false;
        }
        return available;
    }

    // list books borrowed by libraryUser
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> bookList = libraryDatabase.listBooksInHandsOf(libraryUser);
        return bookList;
    }

    public int returnBooks(LibraryUser libraryUser) {
        return libraryDatabase.listBooksInHandsOf(libraryUser).size();
    }
}
