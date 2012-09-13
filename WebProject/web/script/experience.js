/**
 * Valida o formulário.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    // Nota: todos os campos do tipo 'select' possuem a validação null. Eles só são validados no servidor.
    return validate(form["profInstitution"].value, /^[a-z ]{4,40}$/i, "Instituição inválida.")
        
	&& validate(form["bondType"].value, /^[a-z ]{4,40}$/i, "Tipo de vínculo inválido.")
        && validate(form["bondEmployment"].value, null, "Vínculo empregatício inválido.")
        && validate(form["bondFunctional"].value, /^[a-z ]{4,40}$/i, "Enquadramento funcional inválido.")
	&& validate(form["bondTime"].value, /^[0-9]{1,2}$/i, "Carga horária inválida.")
	&& validate(form["bondExclusive"].value, null, "Dedicação exclusiva inválida.")
    
        && validate(form["periodMonth"].value, /^[0-9]{1,2}$/i, "Mês de início inválido.")
        && validate(form["periodYear"].value, /^[0-9]{2,4}$/i, "Ano de início inválido.")
        
        && validate(form["otherInfo"].value, /.{0,300}$/i, "Outras informações inválido.");
}
