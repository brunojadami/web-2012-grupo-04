package webproject.bean;

public class Experience extends User
{

    private String profInstitution;
    private String bondType;
    private String bondEmployment;
    private String bondFunctional;
    private String bondTime;
    private String bondExclusive;
    private String periodMonth;
    private String periodFinished;
    private String periodYear;
    private String otherInfo;

    public Experience()
    {
	attributes.put("getProfInstitution", new Bean.Attribute("profInstitution",  0+1, "Instituição"));
	attributes.put("getBondType", new Bean.Attribute("bondType",  1+1, "Tipo do vínculo"));
	attributes.put("getBondEmployment", new Bean.Attribute("bondEmployment",  2+1, "Vínculo empregatício?"));
	attributes.put("getBondFunctional", new Bean.Attribute("bondFunctional",  3+1, "Enquadramento funcional"));
	attributes.put("getBondTime", new Bean.Attribute("bondTime",  4+1, "Carga horária"));
	attributes.put("getBondExclusive", new Bean.Attribute("bondExclusive",  5+1, "Dedicação exclusiva?"));
	attributes.put("getPeriodMonth", new Bean.Attribute("periodMonth",  6+1, "Mês de início"));
	attributes.put("getPeriodYear", new Bean.Attribute("periodYear",  7+1, "Ano de início"));
	attributes.put("getPeriodFinished", new Bean.Attribute("periodFinished",  8+1, "Finalizado?"));
	attributes.put("getOtherInfo", new Bean.Attribute("otherInfo",  9+1, "Outras informações"));
    }

    public String getProfInstitution()
    {
	return profInstitution;
    }

    public void setProfInstitution(String profInstitution)
    {
	this.profInstitution = profInstitution;
    }

    public String getBondType()
    {
	return bondType;
    }

    public void setBondType(String bondType)
    {
	this.bondType = bondType;
    }

    public String getBondEmployment()
    {
	return bondEmployment;
    }

    public void setBondEmployment(String bondEmployment)
    {
	this.bondEmployment = bondEmployment;
    }

    public String getBondFunctional()
    {
	return bondFunctional;
    }

    public void setBondFunctional(String bondFunctional)
    {
	this.bondFunctional = bondFunctional;
    }

    public String getBondTime()
    {
	return bondTime;
    }

    public void setBondTime(String bondTime)
    {
	this.bondTime = bondTime;
    }

    public String getBondExclusive()
    {
	return bondExclusive;
    }

    public void setBondExclusive(String bondExclusive)
    {
	this.bondExclusive = bondExclusive;
    }

    public String getPeriodMonth()
    {
	return periodMonth;
    }

    public void setPeriodMonth(String periodMonth)
    {
	this.periodMonth = periodMonth;
    }

    public String getPeriodFinished()
    {
	return periodFinished;
    }

    public void setPeriodFinished(String periodFinished)
    {
	this.periodFinished = periodFinished;
    }

    public String getPeriodYear()
    {
	return periodYear;
    }

    public void setPeriodYear(String periodYear)
    {
	this.periodYear = periodYear;
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
