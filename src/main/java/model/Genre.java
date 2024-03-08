package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the genres database table.
 * 
 */
@Entity
@Table(name="genres")
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to BookGenre
	@OneToMany(mappedBy="genre")
	private List<BookGenre> bookGenres;

	public Genre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookGenre> getBookGenres() {
		return this.bookGenres;
	}

	public void setBookGenres(List<BookGenre> bookGenres) {
		this.bookGenres = bookGenres;
	}

	public BookGenre addBookGenre(BookGenre bookGenre) {
		getBookGenres().add(bookGenre);
		bookGenre.setGenre(this);

		return bookGenre;
	}

	public BookGenre removeBookGenre(BookGenre bookGenre) {
		getBookGenres().remove(bookGenre);
		bookGenre.setGenre(null);

		return bookGenre;
	}

}