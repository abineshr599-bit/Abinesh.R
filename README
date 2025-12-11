package library;

import java.io.*;
import java.util.*;

/**
 * Library class manages books and members and provides persistence via serialization.
 */
public class Library implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Map<Integer, Book> books = new LinkedHashMap<>();
    private final Map<Integer, Member> members = new LinkedHashMap<>();
    private int nextBookId = 1;
    private int nextMemberId = 1;

    // Add a new book and return the created Book
    public Book addBook(String title, String author) {
        Book book = new Book(nextBookId++, title, author);
        books.put(book.getId(), book);
        return book;
    }

    // Register a new member and return the created Member
    public Member registerMember(String name) {
        Member member = new Member(nextMemberId++, name);
        members.put(member.getId(), member);
        return member;
    }

    public List<Book> listAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Member> listAllMembers() {
        return new ArrayList<>(members.values());
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public Member getMember(int id) {
        return members.get(id);
    }

    public List<Book> searchBooks(String query) {
        String q = query.toLowerCase();
        List<Book> result = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(q) || b.getAuthor().toLowerCase().contains(q)) {
                result.add(b);
            }
        }
        return result;
    }

    public boolean issueBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book == null || member == null) {
            return false; // invalid ids
        }
        if (book.isIssued()) {
            return false; // already issued
        }
        book.issueTo(memberId);
        return true;
    }

    public boolean returnBook(int bookId) {
        Book book = books.get(bookId);
        if (book == null) return false;
        if (!book.isIssued()) return false;
        book.returned();
        return true;
    }

    // Persistence: save to file
    public void saveToFile(File file) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(this);
        }
    }

    // Load from file (static factory), returns null if load fails
    public static Library loadFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            if (obj instanceof Library) {
                return (Library) obj;
            } else {
                throw new IOException("Data in file is not a Library object");
            }
        }
    }
}
