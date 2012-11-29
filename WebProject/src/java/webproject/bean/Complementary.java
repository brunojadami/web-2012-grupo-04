package webproject.bean;

public class Complementary extends LoginDependant
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
	attributes.put(new Bean.Attribute("generalLevel", 0+1, "Nível"), "getGeneralLevel");
	attributes.put(new Bean.Attribute("generalInstitution", 1+1, "Instituição"), "getGeneralInstitution");
	attributes.put(new Bean.Attribute("generalCourse", 2+1, "Curso"), "getGeneralCourse");
	attributes.put(new Bean.Attribute("generalStatus", 3+1, "Estado"), "getGeneralStatus");
	attributes.put(new Bean.Attribute("generalTime", 4+1, "Carga horária"), "getGeneralTime");
	attributes.put(new Bean.Attribute("periodBegin", 5+1, "Ano de início"), "getPeriodBegin");
	attributes.put(new Bean.Attribute("periodEnd", 6+1, "Ano de término"), "getPeriodEnd");
	attributes.put(new Bean.Attribute("scholarshipPresence", 7+1, "Com bolsa?"), "getScholarshipPresence");
	attributes.put(new Bean.Attribute("scholarshipAgency", 8+1, "Agência"), "getScholarshipAgency");
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
