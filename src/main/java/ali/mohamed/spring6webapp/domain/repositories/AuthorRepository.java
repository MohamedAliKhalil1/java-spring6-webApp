package ali.mohamed.spring6webapp.domain.repositories;

import ali.mohamed.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
