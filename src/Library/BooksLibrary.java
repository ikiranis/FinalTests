// Άσκηση 1, Επαναληπτικές 2020

package Library;

import java.util.ArrayList;

class Library {
    private ArrayList<Book> booksList = new ArrayList<>();

    public Library() {
    }

    public void addBook(Book book) {
        booksList.add(book);
    }

    public Book checkIfBookExists(int isbn) {
        for (Book book : booksList) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }

        return null;
    }

    public void borrowBook(int isbn) {
        Book book = checkIfBookExists(isbn);

        if (book != null) {
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
            }
        }
    }
}

class Book {
    private int isbn;
    private String title;
    private boolean borrowed;

    public Book(int isbn, String title, boolean borrowed) {
        this.isbn = isbn;
        this.title = title;
        this.borrowed = borrowed;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}


class BooksLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1,"title1", false));
        library.addBook(new Book(2,"title2", false));

        library.borrowBook(1);

    }
}
