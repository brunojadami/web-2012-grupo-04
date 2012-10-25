/**
 * Valida o formulário dos artigos publicados.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    return validate(form["completeName"].value, /[a-z0-9 ]{4,40}$/i, 
	"DOI, ISSN ou parte do nome do periódico inválido.");
}
