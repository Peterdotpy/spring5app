package guru.springframework.spring5app.bootstrap;

import guru.springframework.spring5app.domain.Author;
import guru.springframework.spring5app.domain.Book;

import guru.springframework.spring5app.domain.Publisher;
import guru.springframework.spring5app.repositories.AuthorRepository;
import guru.springframework.spring5app.repositories.BookRepository;

import guru.springframework.spring5app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Publisher penguin = new Publisher();
        penguin.setName("penguin");
        penguin.setAddressLine1("Some place in greece");
        penguin.setState("Athens");
        penguin.setCity("Greece");
        penguin.setZip(98008);

        publisherRepository.save(penguin);
        System.out.println("Publisher count = " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd= new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);
        ddd.setPublisher(penguin);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        penguin.getBooks().add(ddd);
        publisherRepository.save(penguin);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123123134");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);
        noEJB.setPublisher(penguin);
        penguin.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(penguin);


        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Penguin number of books: " + penguin.getBooks().size());



    }
}
