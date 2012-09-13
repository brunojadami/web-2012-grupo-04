/**
 * Valida o formulário dos artigos publicados.
 */
function validatePublishedForm()
{
    var form = document.forms["publishedForm"];
    
    return validate(form["completeName"].value, /[a-z0-9 ]{4,40}$/i, 
	"DOI, ISSN ou parte do nome do periódico inválido.");
}

/**
 * Valida o formulário dos artigos aceitos para publicação.
 */
function validateAcceptedForm()
{
    var form = document.forms["acceptedForm"];
    
    return validate(form["generalTitle"].value, /^[a-z ]{4,40}$/i, "Título inválido.")
	&& validate(form["generalLanguage"].value, null, "Idioma inválido.")
	&& validate(form["generalYear"].value, /^[0-9]{2,4}$/i, "Ano previsto para publicação inválido.")
	
	&& validate(form["detailedTitle"].value, /^[a-z ]{4,40}$/i, "Título do periódico/revista inválido.")
	&& validate(form["detailedISSN"].value, /^[a-z0-9 ]{4,40}$/i, "ISSN inválido.")
    
	&& validate(form["otherInfo"].value, /.{0,300}$/i, "Outras informações inválido.");
}

/**
 * Valida o formulário dos livros e capítulos.
 */
function validateBookForm()
{
    var form = document.forms["bookForm"];
    
    return validate(form["bookType"].value, null, "Tipo de produção inválido.")
	&& validate(form["bookISSN"].value, /[a-z0-9 ]{4,40}$/i, "DOI ou ISSN inválido.");
}