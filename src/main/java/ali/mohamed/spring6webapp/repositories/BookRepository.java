package ali.mohamed.spring6webapp.repositories;

import ali.mohamed.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
