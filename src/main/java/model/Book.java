package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the books database table.
 * 
 */
@Entity
@Table(name="books")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="issue_date")
	private Date issueDate;

	@Lob
	private byte[] picture;

	private int price;

	private String title;

	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="id_author")
	private Author author;

	//bi-directional many-to-one association to FavouriteBook
	@OneToMany(mappedBy="book")
	private List<FavouriteBook> favouriteBooks;

	//bi-directional many-to-one association to OrderedBook
	@OneToMany(mappedBy="book")
	private List<OrderedBook> orderedBooks;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="book")
	private List<Review> reviews;

	//bi-directional many-to-one association to BookGenre
	@OneToMany(mappedBy="book", fetch = FetchType.EAGER)
	private List<BookGenre> bookGenres;

	public Book() {
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Book other=(Book)o;
		
		return other.id==this.id;
	}
	@Override
	public int hashCode() {
		return id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<FavouriteBook> getFavouriteBooks() {
		return this.favouriteBooks;
	}

	public void setFavouriteBooks(List<FavouriteBook> favouriteBooks) {
		this.favouriteBooks = favouriteBooks;
	}

	public FavouriteBook addFavouriteBook(FavouriteBook favouriteBook) {
		getFavouriteBooks().add(favouriteBook);
		favouriteBook.setBook(this);

		return favouriteBook;
	}

	public FavouriteBook removeFavouriteBook(FavouriteBook favouriteBook) {
		getFavouriteBooks().remove(favouriteBook);
		favouriteBook.setBook(null);

		return favouriteBook;
	}

	public List<OrderedBook> getOrderedBooks() {
		return this.orderedBooks;
	}

	public void setOrderedBooks(List<OrderedBook> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}

	public OrderedBook addOrderedBook(OrderedBook orderedBook) {
		getOrderedBooks().add(orderedBook);
		orderedBook.setBook(this);

		return orderedBook;
	}

	public OrderedBook removeOrderedBook(OrderedBook orderedBook) {
		getOrderedBooks().remove(orderedBook);
		orderedBook.setBook(null);

		return orderedBook;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setBook(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setBook(null);

		return review;
	}

	public List<BookGenre> getBookGenres() {
		return this.bookGenres;
	}

	public void setBookGenres(List<BookGenre> bookGenres) {
		this.bookGenres = bookGenres;
	}

	public BookGenre addBookGenre(BookGenre bookGenre) {
		getBookGenres().add(bookGenre);
		bookGenre.setBook(this);

		return bookGenre;
	}

	public BookGenre removeBookGenre(BookGenre bookGenre) {
		getBookGenres().remove(bookGenre);
		bookGenre.setBook(null);

		return bookGenre;
	}

}