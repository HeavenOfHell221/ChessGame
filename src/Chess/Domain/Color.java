package Chess.Domain;

public enum Color 
{
    White,
    Black; 

    public Color opposite() 
    {
        return (this == Black) ? White : Black;
    }
}
