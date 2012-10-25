
/**
 * Valida o formulário dos livros e capítulos.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    // Nota: todos os campos do tipo 'select' possuem a validação null. Eles só são validados no servidor.
    return validate(form["bookType"].value, null, "Tipo de produção inválido.")
	&& validate(form["bookISSN"].value, /[a-z0-9 ]{4,40}$/i, "DOI ou ISSN inválido.");
}