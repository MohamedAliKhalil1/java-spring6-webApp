package ali.mohamed.spring6webapp.services;

import ali.mohamed.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
