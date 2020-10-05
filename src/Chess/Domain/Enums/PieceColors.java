package Chess.Domain.Enums;

public enum PieceColors 
{
    White,
    Black; 

    public PieceColors opposite() 
    {
        return (this == Black) ? White : Black;
    }
}
