package NguyenNhatKhang.bai36.controller;

import NguyenNhatKhang.bai36.entity.Book;
import NguyenNhatKhang.bai36.services.BookService;
import NguyenNhatKhang.bai36.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }


    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "redirect:/books";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")

    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}