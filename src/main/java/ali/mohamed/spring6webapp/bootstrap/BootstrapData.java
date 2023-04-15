package ali.mohamed.spring6webapp.bootstrap;

import ali.mohamed.spring6webapp.domain.Author;
import ali.mohamed.spring6webapp.domain.Book;
import ali.mohamed.spring6webapp.repositories.AuthorRepository;
import ali.mohamed.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author mohamed = new Author();
        mohamed.setFirstName("Mohamed");
        mohamed.setLastName("Ali");

        Book book1 = new Book();
        book1.setTitle("book1_title");
        book1.setIsbn("123456");

        Author mohamedSaved = authorRepository.save(mohamed);
        Book book1Saved = bookRepository.save(book1);

        Author yehia = new Author();
        yehia.setFirstName("yehia");
        yehia.setLastName("Khalil");

        Book book2 = new Book();
        book2.setTitle("book2");
        book2.setIsbn("7890");

        Author yehiaSaved = authorRepository.save(yehia);
        Book book2Saved = bookRepository.save(book2);

        mohamedSaved.getBooks().add(book1Saved);
        yehiaSaved.getBooks().add(book2Saved);

        authorRepository.save(mohamedSaved);
        authorRepository.save(yehiaSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Books Count: " + bookRepository.count());
    }
}
