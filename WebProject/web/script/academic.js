/**
 * Valida o formulário.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    return validate(form["generalLevel"].value, /.*\@.*\..{2,4}/i, "Nível inválido.")
        && validate(form["generalType"].value, /.{6,30}/i, "Tipo inválido.")
        && validate(form["generalInstitute"].value, /.{6,30}/i, "Instituto inválido.")
        && validate(form["generalCourse"].value, /.{6,30}/i, "Curso inválido.")
        && validate(form["generalStatus"].value, /.{6,30}/i, "Estado inválido.")
        && validate(form["periodStartDate"].value, /.{6,30}/i, "Data de início inválida.")
        && validate(form["periodEndDate"].value, /.{6,30}/i, "Data de término inválida.")
        && validate(form["scholarshipPresence"].value, /.{6,30}/i, "Com bolsa? inválida.")
        && validate(form["scholarshipAgency"].value, /.{6,30}/i, "Agência inválida.")
        && validate(form["miscInfo"].value, /.{6,30}/i, "Informações adicionais inválidas.");
}
