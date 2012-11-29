package webproject.bean;

/**
 * Bean que representa a página de informações pessoais.
 */
public class PersonalInfo extends LoginDependant
{
    private String generalName;
    private String generalCitationName;
    private String generalCountry;
    private String generalCpf;
    private String generalSex;
    private String idNumber;
    private String idEmissioner;
    private String idState;
    private String idEmissionDate;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private String birthDate;
    private String passportNumber;
    private String passportValidityDate;
    private String passportEmissionDate;
    private String passportCountry;
    private String filiationFatherName;
    private String filiationMotherName;
    private String addressStreet;
    private String addressZipCode;
    private String addressCity;
    private String addressCountry;
    private String addressDistrict;
    private String addressState;
    private String addressPhone;
    private String professionalAddressCompany;
    private String professionalAddressUnit;
    private String professionalAddressStreet;
    private String professionalAddressZipCode;
    private String professionalAddressCity;
    private String professionalAddressCountry;
    private String professionalAddressDistrict;
    private String professionalAddressState;
    private String professionalAddressPhone;
    private String miscEmail;
    
    public PersonalInfo()
    {
        attributes.put(new Bean.Attribute("generalName", 1, "Nome"), "getGeneralName");
        attributes.put(new Bean.Attribute("generalCitationName", 2, "Nome de citação"), "getGeneralCitationName");
        attributes.put(new Bean.Attribute("generalCountry", 3, "País"), "getGeneralCountry");
        attributes.put(new Bean.Attribute("generalCpf", 4, "CPF"), "getGeneralCpf");
        attributes.put(new Bean.Attribute("generalSex", 5, "Sexo"), "getGeneralSex");
        attributes.put(new Bean.Attribute("idNumber", 6, "Número da identidade"), "getIdNumber");
        attributes.put(new Bean.Attribute("idEmissioner", 7, "Emissor da identidade"), "getIdEmissioner");
        attributes.put(new Bean.Attribute("idState", 8, "Estado identidade"), "getIdState");
        attributes.put(new Bean.Attribute("idEmissionDate", 9, "Data de emissão da identidade"), "getIdEmissionDate");
        attributes.put(new Bean.Attribute("birthCountry", 10, "País de nascimento"), "getBirthCountry");
        attributes.put(new Bean.Attribute("birthState", 11, "Estado de nascimento"), "getBirthState");
        attributes.put(new Bean.Attribute("birthCity", 12, "Cidade de nascimento"), "getBirthCity");
        attributes.put(new Bean.Attribute("birthDate", 13, "Data de nascimento"), "getBirthDate");
        attributes.put(new Bean.Attribute("passportNumber", 14, "Número do passaporte"), "getPassportNumber");
        attributes.put(new Bean.Attribute("passportValidityDate", 15, "Data de validade do passaporte"), "getPassportValidityDate");
        attributes.put(new Bean.Attribute("passportEmissionDate", 16, "Data de emissão do passaporte"), "getPassportEmissionDate");
        attributes.put(new Bean.Attribute("filiationFatherName", 17, "Pai"), "getFiliationFatherName");
        attributes.put(new Bean.Attribute("filiationMotherName", 18, "Mãe"), "getFiliationMotherName");
        attributes.put(new Bean.Attribute("addressStreet", 19, "Rua"), "getAddressStreet");
        attributes.put(new Bean.Attribute("addressZipCode", 20, "CEP"), "getAddressZipCode");
        attributes.put(new Bean.Attribute("addressCity", 21, "Cidade"), "getAddressCity");
        attributes.put(new Bean.Attribute("addressCountry", 22, "País"), "getAddressCountry");
        attributes.put(new Bean.Attribute("addressDistrict", 23, "Bairro"), "getAddressDistrict");
        attributes.put(new Bean.Attribute("addressState", 24, "Estado"), "getAddressState");
        attributes.put(new Bean.Attribute("addressPhone", 25, "Telefone"), "getAddressPhone");
        attributes.put(new Bean.Attribute("professionalAddressCompany", 26, "Trabalho"), "getProfessionalAddressCompany");
        attributes.put(new Bean.Attribute("professionalAddressUnit", 27, "Unidade"), "getProfessionalAddressUnit");
        attributes.put(new Bean.Attribute("professionalAddressStreet", 28, "Rua"), "getProfessionalAddressStreet");
        attributes.put(new Bean.Attribute("professionalAddressZipCode", 29, "CEP"), "getProfessionalAddressZipCode");
        attributes.put(new Bean.Attribute("professionalAddressCity", 30, "Cidade"), "getProfessionalAddressCity");
        attributes.put(new Bean.Attribute("professionalAddressCountry", 31, "País"), "getProfessionalAddressCountry");
        attributes.put(new Bean.Attribute("professionalAddressDistrict", 32, "Bairro"), "getProfessionalAddressDistrict");
        attributes.put(new Bean.Attribute("professionalAddressState", 33, "Estado"), "getProfessionalAddressState");
        attributes.put(new Bean.Attribute("professionalAddressPhone", 34, "Telefone"), "getProfessionalAddressPhone");
        attributes.put(new Bean.Attribute("miscEmail", 35, "Email"), "getMiscEmail");
    }

    public String getGeneralName()
    {
        return generalName;
    }

    public void setGeneralName(String generalName)
    {
        this.generalName = generalName;
    }

    public String getGeneralCitationName()
    {
        return generalCitationName;
    }

    public void setGeneralCitationName(String generalCitationName)
    {
        this.generalCitationName = generalCitationName;
    }

    public String getGeneralCountry()
    {
        return generalCountry;
    }

    public void setGeneralCountry(String generalCountry)
    {
        this.generalCountry = generalCountry;
    }

    public String getGeneralCpf()
    {
        return generalCpf;
    }

    public void setGeneralCpf(String generalCpf)
    {
        this.generalCpf = generalCpf;
    }

    public String getGeneralSex()
    {
        return generalSex;
    }

    public void setGeneralSex(String generalSex)
    {
        this.generalSex = generalSex;
    }

    public String getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getIdEmissioner()
    {
        return idEmissioner;
    }

    public void setIdEmissioner(String idEmissioner)
    {
        this.idEmissioner = idEmissioner;
    }

    public String getIdState()
    {
        return idState;
    }

    public void setIdState(String idState)
    {
        this.idState = idState;
    }

    public String getIdEmissionDate()
    {
        return idEmissionDate;
    }

    public void setIdEmissionDate(String idEmissionDate)
    {
        this.idEmissionDate = idEmissionDate;
    }

    public String getBirthCountry()
    {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry)
    {
        this.birthCountry = birthCountry;
    }

    public String getBirthState()
    {
        return birthState;
    }

    public void setBirthState(String birthState)
    {
        this.birthState = birthState;
    }

    public String getBirthCity()
    {
        return birthCity;
    }

    public void setBirthCity(String birthCity)
    {
        this.birthCity = birthCity;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getPassportNumber()
    {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber)
    {
        this.passportNumber = passportNumber;
    }

    public String getPassportValidityDate()
    {
        return passportValidityDate;
    }

    public void setPassportValidityDate(String passportValidityDate)
    {
        this.passportValidityDate = passportValidityDate;
    }

    public String getPassportEmissionDate()
    {
        return passportEmissionDate;
    }

    public void setPassportEmissionDate(String passportEmissionDate)
    {
        this.passportEmissionDate = passportEmissionDate;
    }

    public String getPassportCountry()
    {
        return passportCountry;
    }

    public void setPassportCountry(String passportCountry)
    {
        this.passportCountry = passportCountry;
    }

    public String getFiliationFatherName()
    {
        return filiationFatherName;
    }

    public void setFiliationFatherName(String filiationFatherName)
    {
        this.filiationFatherName = filiationFatherName;
    }

    public String getFiliationMotherName()
    {
        return filiationMotherName;
    }

    public void setFiliationMotherName(String filiationMotherName)
    {
        this.filiationMotherName = filiationMotherName;
    }

    public String getAddressStreet()
    {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet)
    {
        this.addressStreet = addressStreet;
    }

    public String getAddressZipCode()
    {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode)
    {
        this.addressZipCode = addressZipCode;
    }

    public String getAddressCity()
    {
        return addressCity;
    }

    public void setAddressCity(String addressCity)
    {
        this.addressCity = addressCity;
    }

    public String getAddressCountry()
    {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry)
    {
        this.addressCountry = addressCountry;
    }

    public String getAddressDistrict()
    {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict)
    {
        this.addressDistrict = addressDistrict;
    }

    public String getAddressState()
    {
        return addressState;
    }

    public void setAddressState(String addressState)
    {
        this.addressState = addressState;
    }

    public String getAddressPhone()
    {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone)
    {
        this.addressPhone = addressPhone;
    }

    public String getProfessionalAddressCompany()
    {
        return professionalAddressCompany;
    }

    public void setProfessionalAddressCompany(String professionalAddressCompany)
    {
        this.professionalAddressCompany = professionalAddressCompany;
    }

    public String getProfessionalAddressUnit()
    {
        return professionalAddressUnit;
    }

    public void setProfessionalAddressUnit(String professionalAddressUnit)
    {
        this.professionalAddressUnit = professionalAddressUnit;
    }

    public String getProfessionalAddressStreet()
    {
        return professionalAddressStreet;
    }

    public void setProfessionalAddressStreet(String professionalAddressStreet)
    {
        this.professionalAddressStreet = professionalAddressStreet;
    }

    public String getProfessionalAddressZipCode()
    {
        return professionalAddressZipCode;
    }

    public void setProfessionalAddressZipCode(String professionalAddressZipCode)
    {
        this.professionalAddressZipCode = professionalAddressZipCode;
    }

    public String getProfessionalAddressCity()
    {
        return professionalAddressCity;
    }

    public void setProfessionalAddressCity(String professionalAddressCity)
    {
        this.professionalAddressCity = professionalAddressCity;
    }

    public String getProfessionalAddressCountry()
    {
        return professionalAddressCountry;
    }

    public void setProfessionalAddressCountry(String professionalAddressCountry)
    {
        this.professionalAddressCountry = professionalAddressCountry;
    }

    public String getProfessionalAddressDistrict()
    {
        return professionalAddressDistrict;
    }

    public void setProfessionalAddressDistrict(String professionalAddressDistrict)
    {
        this.professionalAddressDistrict = professionalAddressDistrict;
    }

    public String getProfessionalAddressState()
    {
        return professionalAddressState;
    }

    public void setProfessionalAddressState(String professionalAddressState)
    {
        this.professionalAddressState = professionalAddressState;
    }

    public String getProfessionalAddressPhone()
    {
        return professionalAddressPhone;
    }

    public void setProfessionalAddressPhone(String professionalAddressPhone)
    {
        this.professionalAddressPhone = professionalAddressPhone;
    }

    public String getMiscEmail()
    {
        return miscEmail;
    }

    public void setMiscEmail(String miscEmail)
    {
        this.miscEmail = miscEmail;
    }
}
