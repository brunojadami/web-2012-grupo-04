/**
 * Valida o formulário.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    return validate(form["email"].value, /.*\@.*\..{2,4}$/i, "Email e senha incorretos.")
        && validate(form["password"].value, /.{6,30}$/i, "Email e senha incorretos.");
}
