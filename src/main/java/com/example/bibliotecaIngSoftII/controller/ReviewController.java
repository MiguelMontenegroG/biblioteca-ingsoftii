package com.example.bibliotecaIngSoftII.controller;

import com.example.bibliotecaIngSoftII.model.Review;
import com.example.bibliotecaIngSoftII.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Gestión de Reseñas", description = "Operaciones para previsualizar, enviar y consultar reseñas de libros")

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Operation(summary = "Previsualizar reseña",
            description = "Permite ver una reseña antes de enviarla. No se guarda en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseña generada en modo vista previa")
    })
    @PostMapping("/preview")
    public Review preview(@RequestBody Review review) {
        return reviewService.previewReview(review);
    }

    @Operation(summary = "Enviar reseña",
            description = "Guarda una reseña sobre un libro en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseña guardada exitosamente")
    })
    @PostMapping("/submit")
    public Review submit(@RequestBody Review review) {
        return reviewService.submitReview(review);
    }

    @Operation(summary = "Obtener reseñas de un libro",
            description = "Devuelve todas las reseñas asociadas a un libro específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reseñas encontradas")
    })
    @GetMapping("/book/{bookId}")
    public List<Review> getReviews(@PathVariable String bookId) {
        return reviewService.getReviewsByBook(bookId);
    }
}
