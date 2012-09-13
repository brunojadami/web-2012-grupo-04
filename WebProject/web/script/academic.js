/**
 * Valida o formulário.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    // Nota: todos os campos do tipo 'select' possuem a validação null. Eles só são validados no servidor.
    return validate(form["generalLevel"].value, null, "Nível inválido.")
        && validate(form["generalType"].value, /^[a-z ]{5,50}$/i, "Tipo inválido.")
        && validate(form["generalInstitute"].value, /^[a-z ]{2,30}$/i, "Instituto inválido.")
        && validate(form["generalCourse"].value, /^[a-z ]{4,40}$/i, "Curso inválido.")
        && validate(form["generalStatus"].value, null, "Estado inválido.")
        && validate(form["periodStartDate"].value, /^[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{2,4}$/i, "Data de início inválida.")
        && validate(form["periodEndDate"].value, /^[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{2,4}$/i, "Data de término inválida.")
        && validate(form["scholarshipPresence"].value, null, "Com bolsa? inválida.")
        && validate(form["scholarshipAgency"].value, /^[a-z ]{2,30}$/i, "Agência inválida.")
        && validate(form["miscInfo"].value, /^.{0,300}$/i, "Informações adicionais inválidas.");
}
