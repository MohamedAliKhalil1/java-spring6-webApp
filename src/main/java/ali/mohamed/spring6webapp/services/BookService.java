package ali.mohamed.spring6webapp.services;

import ali.mohamed.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
