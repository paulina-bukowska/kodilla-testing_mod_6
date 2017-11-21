package com.kodilla.testing.library;

import org.junit.*;
import java.util.*;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    @Test
    //czy lista książek spełniających warunek wyszukiwania jest poprawnie zwracana
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        // Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    //generowanie listy książek o dowolnej liczbie tytułów
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    //czy metoda listBooksWithCondition(String titleFragment) zachowuje się poprawnie
    //gdy ilość tytułów pasujących do wzorca jest większa niż 20 - w tej sytuacji zwracana powinna być pusta lista
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks")).thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    //czy zwracana lista książek jest pusta, w sytuacji gdy wyszukiwany fragment tytułu jest krótszy niż trzy znaki
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);
        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        // Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfNoBooksBorrowed() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("Monica", "Greenwood", "92100312998");

        List<Book> booksList = new ArrayList<Book>();

        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksList);
        //When
        int quantityOfBorrowedBooks = bookLibrary.returnBooks(user);
        //Then
        Assert.assertEquals(0, quantityOfBorrowedBooks);
    }


    @Test
    public void testListBooksInHandsOfOneBookBorrowed() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("Monica", "Greenwood", "92100312998");

        Book donQuixote = new Book("Don Quixote", "Miguel de Cervantes", 1605);
        List<Book> booksList = new ArrayList<Book>();
        booksList.add(donQuixote);

        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksList);
        //When
        int quantityOfBorrowedBooks = bookLibrary.returnBooks(user);
        //Then
        Assert.assertEquals(1, quantityOfBorrowedBooks);
    }

    @Test
    public void testListBooksInHandsOfFiveBooksBorrowed() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("Monica", "Greenwood", "92100312998");

        Book donQuixote = new Book("Don Quixote", "Miguel de Cervantes", 1605);
        Book taleOfTwoCities = new Book("A Tale of Two Cities", "Charles Dickens", 1859);
        Book littlePrince = new Book("The Little Prince", "Antoine de Saint-Exupéry", 1943);
        Book hobbit = new Book("The Hobbit", "J. R. R. Tolkien", 1937);
        Book catcherInRye = new Book("The Catcher in the Rye", "	J. D. Salinger", 1951);
        List<Book> booksList = new ArrayList<Book>();
        booksList.add(donQuixote);
        booksList.add(taleOfTwoCities);
        booksList.add(littlePrince);
        booksList.add(hobbit);
        booksList.add(catcherInRye);

        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(booksList);
        //When
        int quantityOfBorrowedBooks = bookLibrary.returnBooks(user);
        //Then
        Assert.assertEquals(5, quantityOfBorrowedBooks);
    }

}
