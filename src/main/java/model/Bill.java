package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bills database table.
 * 
 */
@Entity
@Table(name="bills")
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="issue_date")
	private Date issueDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to OrderedBook
	@OneToMany(mappedBy="bill")
	private List<OrderedBook> orderedBooks;

	public Bill() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderedBook> getOrderedBooks() {
		return this.orderedBooks;
	}

	public void setOrderedBooks(List<OrderedBook> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}

	public OrderedBook addOrderedBook(OrderedBook orderedBook) {
		getOrderedBooks().add(orderedBook);
		orderedBook.setBill(this);

		return orderedBook;
	}

	public OrderedBook removeOrderedBook(OrderedBook orderedBook) {
		getOrderedBooks().remove(orderedBook);
		orderedBook.setBill(null);

		return orderedBook;
	}

}