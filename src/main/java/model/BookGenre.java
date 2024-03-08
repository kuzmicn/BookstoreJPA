package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the book_genres database table.
 * 
 */
@Entity
@Table(name="book_genres")
@NamedQuery(name="BookGenre.findAll", query="SELECT b FROM BookGenre b")
public class BookGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="id_genre")
	private Genre genre;

	public BookGenre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}