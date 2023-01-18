package guru.springframework.spring5app.repositories;

import guru.springframework.spring5app.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
