package webproject.bean;

public class Accepted extends Bean
{

    private String generalTitle;
    private String generalLanguage;
    private String generalYear;
    private String detailedTitle;
    private String detailedISSN;
    private String otherInfo;

    public Accepted()
    {
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
