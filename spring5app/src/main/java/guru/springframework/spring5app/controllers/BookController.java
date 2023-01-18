package guru.springframework.spring5app.controllers;



import guru.springframework.spring5app.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 12/24/19.
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/book")
    public String getBook(Model model){

        model.addAttribute("book", bookRepository.findAll());

        return "book/list";
    }
}
