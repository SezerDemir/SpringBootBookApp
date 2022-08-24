package com.sezer.book;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.sezer.BookRestAppApplication;
import com.sezer.user.User;
import com.sezer.user.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@Data
@RequestMapping(path = "api/book")
@AllArgsConstructor
public class BookController {

	private final BookService bookService;
	private final BookMapper bookMapper;
	private final UserRepository repo;
	@GetMapping(value="/get")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
	public List<BookDTO> getBooks(@RequestParam(name="index") int pageIndex) {
		return bookService.getBooks(pageIndex).stream().
				map(b -> bookMapper.bookToBookDTO(b)).
				collect(Collectors.toList());
	}
	
	@GetMapping(value="/getByTimeFilter/{date}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
	public List<Book> getBookByTimeFilter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return bookService.getBooksByTimeFilter(date);
	}
	
	@PostMapping(value="/add")
	@PreAuthorize("hasRole('ADMIN')")
	public BookDTO addNewBook(@RequestBody Book book) {
		return bookMapper.bookToBookDTO(bookService.addBook(book));
	}
	
	@DeleteMapping(path="/delete/{bookId}")
	@PreAuthorize("hasRole('CLIENT')")
	public void removeBook(@PathVariable("bookId") int id) {
		bookService.removeBook(id);
	}
	
	@PutMapping(value="/update")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<BookDTO> updateBook(@RequestBody @Valid Book book) {
		BookDTO dto = bookMapper.bookToBookDTO(bookService.updateBook(book));
		URI bookURI = URI.create("/books/" + dto.getId());
		return ResponseEntity.created(bookURI).body(dto);
	}
	
}
