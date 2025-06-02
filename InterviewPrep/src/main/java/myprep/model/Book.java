package myprep.model;

public class Book {
	private String title;
	private String author;
	private Integer releaseYear;
	private Integer soldCopies;

	public Book(String title, String author, int releaseYear, int soldCopies) {
		super();
		this.title = title;
		this.author = author;
		this.releaseYear = releaseYear;
		this.soldCopies = soldCopies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getSoldCopies() {
		return soldCopies;
	}

	public void setSoldCopies(int soldCopies) {
		this.soldCopies = soldCopies;
	}

}