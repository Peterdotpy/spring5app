package guru.springframework.spring5app.repositories;

import guru.springframework.spring5app.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
