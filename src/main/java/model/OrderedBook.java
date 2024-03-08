package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the ordered_books database table.
 * 
 */
@Entity
@Table(name="ordered_books")
@NamedQuery(name="OrderedBook.findAll", query="SELECT o FROM OrderedBook o")
public class OrderedBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int count;

	private int price;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="id_bill")
	private Bill bill;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;

	public OrderedBook() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}