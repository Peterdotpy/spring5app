package guru.springframework.spring5app.repositories;

import guru.springframework.spring5app.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
