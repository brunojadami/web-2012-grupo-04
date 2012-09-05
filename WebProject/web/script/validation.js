/**
 * @param value Valor a ser validado.
 * @param regex Expressão para usar no teste.
 * @param message Mensagem de erro.
 * @return True se a validação está correta.
 */
function validate(value, regex, message)
{
    if (!regex.test(value))
    {
        alert(message);
        return false;
    }
    return true;
}