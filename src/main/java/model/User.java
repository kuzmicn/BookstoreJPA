package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	private String surname;

	private String username;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="user")
	private List<Bill> bills;

	//bi-directional many-to-one association to FavouriteBook
	@OneToMany(mappedBy="user")
	private List<FavouriteBook> favouriteBooks;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="user")
	private List<Review> reviews;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setUser(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setUser(null);

		return bill;
	}

	public List<FavouriteBook> getFavouriteBooks() {
		return this.favouriteBooks;
	}

	public void setFavouriteBooks(List<FavouriteBook> favouriteBooks) {
		this.favouriteBooks = favouriteBooks;
	}

	public FavouriteBook addFavouriteBook(FavouriteBook favouriteBook) {
		getFavouriteBooks().add(favouriteBook);
		favouriteBook.setUser(this);

		return favouriteBook;
	}

	public FavouriteBook removeFavouriteBook(FavouriteBook favouriteBook) {
		getFavouriteBooks().remove(favouriteBook);
		favouriteBook.setUser(null);

		return favouriteBook;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setUser(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setUser(null);

		return review;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}