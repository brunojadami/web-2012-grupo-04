package webproject.bean;

public class Book extends User
{

    private String bookType;
    private String bookISSN;

    public Book()
    {
	attributes.put("getBookType", new Bean.Attribute("bookType", 0+1, "Tipo de produção"));
	attributes.put("getBookISSN", new Bean.Attribute("bookISSN", 1+1, "DOI ou ISSN"));
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
