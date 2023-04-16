package ali.mohamed.spring6webapp.bootstrap;

import ali.mohamed.spring6webapp.domain.Author;
import ali.mohamed.spring6webapp.domain.Book;
import ali.mohamed.spring6webapp.domain.Publisher;
import ali.mohamed.spring6webapp.repositories.AuthorRepository;
import ali.mohamed.spring6webapp.repositories.BookRepository;
import ali.mohamed.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("publisher1");
        publisher1.setAddress("123 abc St.");
        Publisher publisherSaved = publisherRepository.save(publisher1);

        book1Saved.setPublisher(publisherSaved);
        book2Saved.setPublisher(publisherSaved);

        publisherSaved.getBooks().add(book1Saved);
        publisherSaved.getBooks().add(book2Saved);

        authorRepository.save(mohamedSaved);
        authorRepository.save(yehiaSaved);
        bookRepository.save((book1Saved));
        bookRepository.save(book2Saved);
        publisherRepository.save(publisherSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Books Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
