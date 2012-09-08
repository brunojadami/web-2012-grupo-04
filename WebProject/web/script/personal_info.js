/**
 * Valida o formulário.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    return validate(form["generalName"].value, /.*\@.*\..{2,4}/i, "Nome inválido.")
        && validate(form["generalCitationName"].value, /.{6,30}/i, "Nome de citação inválido.")
        && validate(form["generalCountry"].value, /.{6,30}/i, "País inválido.")
        && validate(form["generalCpf"].value, /.{6,30}/i, "CPF inválido.")
        && validate(form["generalSex"].value, /.{6,30}/i, "Sexo inválido.")
        && validate(form["idNumber"].value, /.{6,30}/i, "Número da identidade inválido.")
        && validate(form["idEmissioner"].value, /.{6,30}/i, "Emissor da identidade inválido.")
        && validate(form["idState"].value, /.{6,30}/i, "Estado da identidade inválido.")
        && validate(form["idEmissionDate"].value, /.{6,30}/i, "Data de emissão da identidade inválida.")
        && validate(form["birthCountry"].value, /.{6,30}/i, "País de nascimento inválido.")
        && validate(form["birthState"].value, /.{6,30}/i, "Estado de nascimento inválido.")
        && validate(form["birthCity"].value, /.{6,30}/i, "Cidade de nascimento inválida.")
        && validate(form["birthDate"].value, /.{6,30}/i, "Data de nascimento inválida.")
        && validate(form["passportNumber"].value, /.{6,30}/i, "Número do passaporte inválido.")
        && validate(form["passportValidityDate"].value, /.{6,30}/i, "Data de validade do passaporte inválida.")
        && validate(form["passportEmissionDate"].value, /.{6,30}/i, "Data de emissão do passaporte inválido.")
        && validate(form["passportCountry"].value, /.{6,30}/i, "País do passaporte inválido.")
        && validate(form["filiationFatherName"].value, /.{6,30}/i, "Nome do pai inválido.")
        && validate(form["filiationMotherName"].value, /.{6,30}/i, "Nome da mãe inválido.")
        && validate(form["addressStreet"].value, /.{6,30}/i, "Rua do endereço inválida.")
        && validate(form["addressZipCode"].value, /.{6,30}/i, "CEP do endereço inválido.")
        && validate(form["addressCity"].value, /.{6,30}/i, "Cidade do endereço inválida.")
        && validate(form["addressCountry"].value, /.{6,30}/i, "País do endereço inválido.")
        && validate(form["addressDistrict"].value, /.{6,30}/i, "Bairro do endereço inválido.")
        && validate(form["addressState"].value, /.{6,30}/i, "Estado do endereço inválido.")
        && validate(form["addressPhone"].value, /.{6,30}/i, "Telefone do endereço inválido.")
        && validate(form["professionalAddressCompany"].value, /.{6,30}/i, "Empresa do endereço profissional inválido.")
        && validate(form["professionalAddressUnit"].value, /.{6,30}/i, "Unidade do endereço profissional inválido.")
        && validate(form["professionalAddressStreet"].value, /.{6,30}/i, "Rua do endereço profissional inválido.")
        && validate(form["professionalAddressZipCode"].value, /.{6,30}/i, "CEP do endereço profissional inválido.")
        && validate(form["professionalAddressCity"].value, /.{6,30}/i, "Cidade do endereço profissional inválido.")
        && validate(form["professionalAddressCountry"].value, /.{6,30}/i, "País do endereço profissional inválido.")
        && validate(form["professionalAddressDistrict"].value, /.{6,30}/i, "Bairro do endereço profissional inválido.")
        && validate(form["professionalAddressState"].value, /.{6,30}/i, "Estado do endereço profissional inválido.")
        && validate(form["professionalAddressPhone"].value, /.{6,30}/i, "Telefone do endereço profissional inválido.")
        && validate(form["miscEmail"].value, /.{6,30}/i, "Email inválido.");
}
