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
