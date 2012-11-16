package webproject.bean;

/**
 * Bean que representa os dados acadêmicos.
 */
public class Academic extends Bean
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
        attributes.put("getGeneralLevel", new Bean.Attribute("generalLevel", 1, "Nível"));
        attributes.put("getGeneralType", new Bean.Attribute("generalType", 2, "Tipo"));
        attributes.put("getGeneralInstitute", new Bean.Attribute("generalInstitute", 3, "Instituto"));
        attributes.put("getGeneralCourse", new Bean.Attribute("generalCourse", 4, "Curso"));
        attributes.put("getGeneralStatus", new Bean.Attribute("generalStatus", 5, "Estado"));
        attributes.put("getPeriodStartDate", new Bean.Attribute("periodStartDate", 6, "Data de início"));
        attributes.put("getPeriodEndDate", new Bean.Attribute("periodEndDate", 7, "Data de término"));
        attributes.put("getScholarshipPresence", new Bean.Attribute("scholarshipPresence", 8, "Com bolsa?"));
        attributes.put("getScholarshipAgency", new Bean.Attribute("scholarshipAgency", 9, "Agência"));
        attributes.put("getMiscInfo", new Bean.Attribute("miscInfo", 10, "Outros"));
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
