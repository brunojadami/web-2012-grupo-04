package webproject.validation;

/**
 * Tamanhos dos inputs.
 */
public enum Size
{
    /**
     * Email.
     */
    EMAIL(6, 30);
    
    /**
     * Tamanho mínimo.
     */
    private int minLength;
    
    /**
     * Tamanho máximo.
     */
    private int maxLength;
    
    /**
     * @param minLength Campo {@link #minLength}.
     * @param maxLength Campo {@link #maxLength}.
     */
    Size(int minLength, int maxLength)
    {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     * @return Campo {@link #minLength}.
     */
    public int getMinLength()
    {
        return minLength;
    }

    /**
     * @return Campo {@link #maxLength}.
     */
    public int getMaxLength()
    {
        return maxLength;
    }
}
