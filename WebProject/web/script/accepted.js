
/**
 * Valida o formulário dos artigos aceitos para publicação.
 */
function validateForm()
{
    var form = document.forms["form"];
    
    // Nota: todos os campos do tipo 'select' possuem a validação null. Eles só são validados no servidor.
    return validate(form["generalTitle"].value, /^[a-z ]{4,40}$/i, "Título inválido.")
	&& validate(form["generalLanguage"].value, null, "Idioma inválido.")
	&& validate(form["generalYear"].value, /^[0-9]{2,4}$/i, "Ano previsto para publicação inválido.")
	
	&& validate(form["detailedTitle"].value, /^[a-z ]{4,40}$/i, "Título do periódico/revista inválido.")
	&& validate(form["detailedISSN"].value, /^[a-z0-9 ]{4,40}$/i, "ISSN inválido.")
    
	&& validate(form["otherInfo"].value, /.{0,300}$/i, "Outras informações inválido.");
}
