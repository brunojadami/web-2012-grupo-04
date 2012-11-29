package webproject.bean;

public class Accepted extends LoginDependant
{
    private String generalTitle;
    private String generalLanguage;
    private String generalYear;
    private String detailedTitle;
    private String detailedISSN;
    private String otherInfo;

    public Accepted()
    {
	attributes.put(new Bean.Attribute("generalTitle", 0+1, "Título"), "getGeneralTitle");
	attributes.put(new Bean.Attribute("generalLanguage", 1+1, "Idioma"), "getGeneralLanguage");
	attributes.put(new Bean.Attribute("generalYear", 2+1, "Ano previsto para publicação"), "getGeneralYear");
	attributes.put(new Bean.Attribute("detailedTitle", 3+1, "Título do periódico/revista em que o artigo será publicado"), "getDetailedTitle");
	attributes.put(new Bean.Attribute("detailedISSN", 4+1, "ISSN"), "getDetailedISSN");
	attributes.put(new Bean.Attribute("otherInfo", 5+1, "Outras informações"), "getOtherInfo");
    }

    public String getGeneralTitle()
    {
	return generalTitle;
    }

    public void setGeneralTitle(String generalTitle)
    {
	this.generalTitle = generalTitle;
    }

    public String getGeneralLanguage()
    {
	return generalLanguage;
    }

    public void setGeneralLanguage(String generalLanguage)
    {
	this.generalLanguage = generalLanguage;
    }

    public String getGeneralYear()
    {
	return generalYear;
    }

    public void setGeneralYear(String generalYear)
    {
	this.generalYear = generalYear;
    }

    public String getDetailedTitle()
    {
	return detailedTitle;
    }

    public void setDetailedTitle(String detailedTitle)
    {
	this.detailedTitle = detailedTitle;
    }

    public String getDetailedISSN()
    {
	return detailedISSN;
    }

    public void setDetailedISSN(String detailedISSN)
    {
	this.detailedISSN = detailedISSN;
    }

    public String getOtherInfo()
    {
	return otherInfo;
    }

    public void setOtherInfo(String otherInfo)
    {
	this.otherInfo = otherInfo;
    }

    
}
