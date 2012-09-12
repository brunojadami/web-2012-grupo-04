/**
 * @param value Valor a ser validado.
 * @param regex Expressão para usar no teste.
 * @param message Mensagem de erro.
 * @return True se a validação está correta.
 */
function validate(value, regex, message)
{
    if (regex != null && !regex.test(value))
    {
        document.getElementById('errorLabel').innerHTML = message;
        window.scrollTo(0, 0);
        return false;
    }
    return true;
}
