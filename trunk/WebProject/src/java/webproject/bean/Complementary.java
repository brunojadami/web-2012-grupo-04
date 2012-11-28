package webproject.bean;

public class Complementary extends User
{

    private String generalLevel;
    private String generalInstitution;
    private String generalCourse;
    private String generalStatus;
    private String generalTime;
    private String periodBegin;
    private String periodEnd;
    private String scholarshipPresence;
    private String scholarshipAgency;

    public Complementary()
    {
	attributes.put("getGeneralLevel", new Bean.Attribute("generalLevel", 0+1, "Nível"));
	attributes.put("getGeneralInstitution", new Bean.Attribute("generalInstitution", 1+1, "Instituição"));
	attributes.put("getGeneralCourse", new Bean.Attribute("generalCourse", 2+1, "Curso"));
	attributes.put("getGeneralStatus", new Bean.Attribute("generalStatus", 3+1, "Estado"));
	attributes.put("getGeneralTime", new Bean.Attribute("generalTime", 4+1, "Carga horária"));
	attributes.put("getPeriodBegin", new Bean.Attribute("periodBegin", 5+1, "Ano de início"));
	attributes.put("getPeriodEnd", new Bean.Attribute("periodEnd", 6+1, "Ano de término"));
	attributes.put("getScholarshipPresence", new Bean.Attribute("scholarshipPresence", 7+1, "Com bolsa?"));
	attributes.put("getScholarshipAgency", new Bean.Attribute("scholarshipAgency", 8+1, "Agência"));
    }

    public String getGeneralLevel()
    {
	return generalLevel;
    }

    public void setGeneralLevel(String generalLevel)
    {
	this.generalLevel = generalLevel;
    }

    public String getGeneralInstitution()
    {
	return generalInstitution;
    }

    public void setGeneralInstitution(String generalInstitution)
    {
	this.generalInstitution = generalInstitution;
    }

    public String getGeneralCourse()
    {
	return generalCourse;
    }

    public void setGeneralCourse(String generalCourse)
    {
	this.generalCourse = generalCourse;
    }

    public String getGeneralStatus()
    {
	return generalStatus;
    }

    public void setGeneralStatus(String generalStatus)
    {
	this.generalStatus = generalStatus;
    }

    public String getGeneralTime()
    {
	return generalTime;
    }

    public void setGeneralTime(String generalTime)
    {
	this.generalTime = generalTime;
    }

    public String getPeriodBegin()
    {
	return periodBegin;
    }

    public void setPeriodBegin(String periodBegin)
    {
	this.periodBegin = periodBegin;
    }

    public String getPeriodEnd()
    {
	return periodEnd;
    }

    public void setPeriodEnd(String periodEnd)
    {
	this.periodEnd = periodEnd;
    }

    public String getScholarshipPresence()
    {
	return scholarshipPresence;
    }

    public void setScholarshipPresence(String scholarshipPresence)
    {
	this.scholarshipPresence = scholarshipPresence;
    }

    public String getScholarshipAgency()
    {
	return scholarshipAgency;
    }

    public void setScholarshipAgency(String scholarshipAgency)
    {
	this.scholarshipAgency = scholarshipAgency;
    }
}
