package com.example.bibliotecaIngSoftII.controller;

import com.example.bibliotecaIngSoftII.model.Book;
import com.example.bibliotecaIngSoftII.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Gestión de Libros", description = "Operaciones para buscar, filtrar y calificar libros en la biblioteca")

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Búsqueda simple de libros",
            description = "Busca libros en el título o autor usando una palabra o frase.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de libros encontrados")
    })
    @GetMapping("/search")
    public List<Book> simpleSearch(@RequestParam String query) {
        return bookService.searchSimple(query);
    }

    @Operation(summary = "Búsqueda avanzada de libros",
            description = "Permite buscar libros filtrando por autor, título o ISBN. "
                    + "Los parámetros son opcionales y se pueden combinar.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de libros que cumplen los criterios")
    })
    @GetMapping("/search/advanced")
    public List<Book> advancedSearch(@RequestParam(required = false) String author,
                                     @RequestParam(required = false) String title,
                                     @RequestParam(required = false) String isbn) {
        return bookService.searchAdvanced(author, title, isbn);
    }

    @Operation(summary = "Calificar un libro",
            description = "Permite asignar una calificación (1 a 5) a un libro. "
                    + "El libro no necesita haber sido comprado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libro actualizado con la calificación")
    })
    @PostMapping("/{bookId}/rate")
    public Book rateBook(@PathVariable String bookId, @RequestParam int rating) {
        return bookService.rateBook(bookId, rating);
    }
}
