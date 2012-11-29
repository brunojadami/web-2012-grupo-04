package webproject.bean;

public class Book extends LoginDependant
{
    private String bookType;
    private String bookISSN;

    public Book()
    {
	attributes.put(new Bean.Attribute("bookType", 0+1, "Tipo de produção"), "getBookType");
	attributes.put(new Bean.Attribute("bookISSN", 1+1, "DOI ou ISSN"), "getBookISSN");
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
