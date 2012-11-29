package webproject.bean;

/**
 * Bean que representa os dados acadêmicos.
 */
public class Academic extends LoginDependant
{
    private String generalLevel;
    private String generalType;
    private String generalInstitute;
    private String generalCourse;
    private String generalStatus;
    private String periodStartDate;
    private String periodEndDate;
    private String scholarshipPresence;
    private String scholarshipAgency;
    private String miscInfo;

    public Academic()
    {
        attributes.put(new Bean.Attribute("generalLevel", 1, "Nível"), "getGeneralLevel");
        attributes.put(new Bean.Attribute("generalType", 2, "Tipo"), "getGeneralType");
        attributes.put(new Bean.Attribute("generalInstitute", 3, "Instituto"), "getGeneralInstitute");
        attributes.put(new Bean.Attribute("generalCourse", 4, "Curso"), "getGeneralCourse");
        attributes.put(new Bean.Attribute("generalStatus", 5, "Estado"), "getGeneralStatus");
        attributes.put(new Bean.Attribute("periodStartDate", 6, "Data de início"), "getPeriodStartDate");
        attributes.put(new Bean.Attribute("periodEndDate", 7, "Data de término"), "getPeriodEndDate");
        attributes.put(new Bean.Attribute("scholarshipPresence", 8, "Com bolsa?"), "getScholarshipPresence");
        attributes.put(new Bean.Attribute("scholarshipAgency", 9, "Agência"), "getScholarshipAgency");
        attributes.put(new Bean.Attribute("miscInfo", 10, "Outros"), "getMiscInfo");
    }
    
    public String getGeneralLevel()
    {
        return generalLevel;
    }

    public void setGeneralLevel(String generalLevel)
    {
        this.generalLevel = generalLevel;
    }

    public String getGeneralType()
    {
        return generalType;
    }

    public void setGeneralType(String generalType)
    {
        this.generalType = generalType;
    }

    public String getGeneralInstitute()
    {
        return generalInstitute;
    }

    public void setGeneralInstitute(String generalInstitute)
    {
        this.generalInstitute = generalInstitute;
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

    public String getPeriodStartDate()
    {
        return periodStartDate;
    }

    public void setPeriodStartDate(String periodStartDate)
    {
        this.periodStartDate = periodStartDate;
    }

    public String getPeriodEndDate()
    {
        return periodEndDate;
    }

    public void setPeriodEndDate(String periodEndDate)
    {
        this.periodEndDate = periodEndDate;
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

    public String getMiscInfo()
    {
        return miscInfo;
    }

    public void setMiscInfo(String miscInfo)
    {
        this.miscInfo = miscInfo;
    }
}
