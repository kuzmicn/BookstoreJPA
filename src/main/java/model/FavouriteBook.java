package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the favourite_books database table.
 * 
 */
@Entity
@Table(name="favourite_books")
@NamedQuery(name="FavouriteBook.findAll", query="SELECT f FROM FavouriteBook f")
public class FavouriteBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public FavouriteBook() {
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}