package gc_lab11;

public class Movie {

	// define fields
	private String title;
	private String category;
	
	// default constructor
	public Movie() {}; 
	
	// constructor with parameters
	public Movie(String title, String category) { 
		setTitle(title);
		setCategory(category);
	}
	
	// setter for title field 
	public void setTitle(String title) { 
		this.title = title;
	}
	
	// setter for category field 
	public void setCategory(String category) { 
		this.category = category;
	}
	
	// getter for title field
	public String getTitle() {  
		return title;
	}
	
	// getter for category field
	public String getCategory() { 
		return category;
	}
	
}


