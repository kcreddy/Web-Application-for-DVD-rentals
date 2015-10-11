package film_search;

public class film_add_Beans {
	
	
	private String title;
	private String rating;
	private int release_year;
	private int rental_duration;
	private int price;
	private int replacement_cost;
	public void settitle(String title) {
		this.title = title;
	}
	public String gettitle() {
		return title;
	}
	public void setrating(String rating) {
		this.rating = rating;
	}
	public String getrating() {
		return rating;
	}
	public void setrelease_year(int release_year) {
		this.release_year = release_year;
	}
	public int getrelease_year() {
		return release_year;
	}
	public void setrental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	public int getrental_duration() {
		return rental_duration;
	}
	public void setprice(int price) {
		this.price = price;
	}
	public int getprice() {
		return price;
	}
	public void setreplacement_cost(int replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public int getreplacement_cost() {
		return replacement_cost;
	}
	
}
