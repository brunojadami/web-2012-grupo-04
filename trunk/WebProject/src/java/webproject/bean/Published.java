package webproject.bean;

public class Published extends LoginDependant
{

    private String completeName;

    public Published()
    {
	attributes.put(new Bean.Attribute("completeName",  1, "DOI, ISSN ou parte do nome do periódico"), "getProfInstitution");
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
