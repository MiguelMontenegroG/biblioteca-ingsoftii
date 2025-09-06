package com.example.bibliotecaIngSoftII;

import com.example.bibliotecaIngSoftII.model.Book;
import com.example.bibliotecaIngSoftII.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class BibliotecaIngSoftIiApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testCreateBook() {
		Book book = new Book(
				"Clean Code",
				"Robert C. Martin",
				"978-0132350884",
				Arrays.asList(5, 4, 5)
		);

		Book savedBook = bookRepository.save(book);
		System.out.println("Libro guardado con ID: " + savedBook.getId());
	}
	@Test
	void contextLoads() {
	}

}
