package webproject.bean;

public class Published extends User
{

    private String completeName;

    public Published()
    {
	attributes.put("getProfInstitution", new Bean.Attribute("completeName",  1, "DOI, ISSN ou parte do nome do periódico"));
    }

    public String getCompleteName()
    {
	return completeName;
    }

    public void setCompleteName(String completeName)
    {
	this.completeName = completeName;
    }
}
