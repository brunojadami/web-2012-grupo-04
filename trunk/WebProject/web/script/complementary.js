/**
 * Valida o formulário.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    // Nota: todos os campos do tipo 'select' possuem a validação /(*)$/i. Eles só são validados no servidor.
    return validate(form["generalLevel"].value, null, "Nível inválido.")
        && validate(form["generalInstitution"].value, /[a-z ]{4,40}$$/i, "Instituição inválida.")
        && validate(form["generalCourse"].value, /[a-z ]{4,40}$/i, "Curso inválido.")
        && validate(form["generalStatus"].value, null, "Estado inválido.")
        && validate(form["generalTime"].value, /[0-9]{1,2}$/i, "Carga horária inválida.")
    
        && validate(form["periodBegin"].value, /[0-9]{2,4}$/i, "Ano de início inválido.")
        && validate(form["periodEnd"].value, /[0-9]{2,4}$/i, "Ano de término inválido.")
        
        && validate(form["scholarshipPresence"].value, null, "Com bolsa? inválido.")
        && validate(form["scholarshipAgency"].value, /[a-z ]{4,40}$/i, "Agência inválida.");
}
