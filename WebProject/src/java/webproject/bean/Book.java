package webproject.bean;

public class Book extends Bean
{

    private String bookType;
    private String bookISSN;

    public Book()
    {
    }

    public String getBookType()
    {
	return bookType;
    }

    public void setBookType(String bookType)
    {
	this.bookType = bookType;
    }

    public String getBookISSN()
    {
	return bookISSN;
    }

    public void setBookISSN(String bookISSN)
    {
	this.bookISSN = bookISSN;
    }
}
