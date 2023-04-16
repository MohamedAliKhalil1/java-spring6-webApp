package ali.mohamed.spring6webapp.repositories;

import ali.mohamed.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
