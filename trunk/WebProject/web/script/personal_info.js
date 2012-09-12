/**
 * Valida o formulário.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    // Nota: todos os campos do tipo 'select' possuem a validação null. Eles só são validados no servidor.
    return validate(form["generalName"].value, /[a-z ]{2,30}/i, "Nome inválido.")
        && validate(form["generalCitationName"].value, /[a-z. ]{2,30}/i, "Nome de citação inválido.")
        && validate(form["generalCountry"].value, null, "País inválido.")
        && validate(form["generalCpf"].value, /[0-9]{3}\.[0-9]{3}\.[0-9]{3}-[0-9]{2}/i, "CPF inválido.")
        && validate(form["generalSex"].value, null, "Sexo inválido.")
        && validate(form["idNumber"].value, /[0-9]{8,9}/i, "Número da identidade inválido.")
        && validate(form["idEmissioner"].value, /[a-z ]{2,10}/i, "Emissor da identidade inválido.")
        && validate(form["idState"].value, null, "Estado da identidade inválido.")
        && validate(form["idEmissionDate"].value, /[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{2,4}/i, "Data de emissão da identidade inválida.")
        && validate(form["birthCountry"].value, null, "País de nascimento inválido.")
        && validate(form["birthState"].value, null, "Estado de nascimento inválido.")
        && validate(form["birthCity"].value, /[a-z ]{2,40}/i, "Cidade de nascimento inválida.")
        && validate(form["birthDate"].value, /[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{2,4}/i, "Data de nascimento inválida.")
        && validate(form["passportNumber"].value, /[a-z]{2}[0-9]{6}/i, "Número do passaporte inválido.")
        && validate(form["passportValidityDate"].value, /[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{2,4}/i, "Data de validade do passaporte inválida.")
        && validate(form["passportEmissionDate"].value, /[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{2,4}/i, "Data de emissão do passaporte inválido.")
        && validate(form["passportCountry"].value, null, "País do passaporte inválido.")
        && validate(form["filiationFatherName"].value, /[a-z ]{2,30}/i, "Nome do pai inválido.")
        && validate(form["filiationMotherName"].value, /[a-z ]{2,30}/i, "Nome da mãe inválido.")
        && validate(form["addressStreet"].value, /[a-z0-9 ]{4,50}/i, "Rua do endereço inválida.")
        && validate(form["addressZipCode"].value, /[0-9]{6,30}/i, "CEP do endereço inválido.")
        && validate(form["addressCity"].value, /[a-z ]{2,40}/i, "Cidade do endereço inválida.")
        && validate(form["addressCountry"].value, null, "País do endereço inválido.")
        && validate(form["addressDistrict"].value, /[a-z ]{2,40}/i, "Bairro do endereço inválido.")
        && validate(form["addressState"].value, null, "Estado do endereço inválido.")
        && validate(form["addressPhone"].value, /[0-9]{6,30}/i, "Telefone do endereço inválido.")
        && validate(form["professionalAddressCompany"].value, /[a-z ]{2,40}/i, "Empresa do endereço profissional inválido.")
        && validate(form["professionalAddressUnit"].value, /[a-z0-9 ]{2,30}/i, "Unidade do endereço profissional inválido.")
        && validate(form["professionalAddressStreet"].value, /[a-z0-9 ]{4,50}/i, "Rua do endereço profissional inválido.")
        && validate(form["professionalAddressZipCode"].value, /[0-9]{6,30}/i, "CEP do endereço profissional inválido.")
        && validate(form["professionalAddressCity"].value, /[a-z ]{2,40}/i, "Cidade do endereço profissional inválido.")
        && validate(form["professionalAddressCountry"].value, null, "País do endereço profissional inválido.")
        && validate(form["professionalAddressDistrict"].value, /[a-z ]{2,40}/i, "Bairro do endereço profissional inválido.")
        && validate(form["professionalAddressState"].value, null, "Estado do endereço profissional inválido.")
        && validate(form["professionalAddressPhone"].value, /[0-9]{6,30}/i, "Telefone do endereço profissional inválido.")
        && validate(form["miscEmail"].value, /.*\@.*\..{2,4}/i, "Email inválido.");
}
