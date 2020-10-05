package Chess.Domain;

/* VALUE OBJECT */

public abstract class Piece 
{
    private final Color m_color;

    public Piece(Color color)
    {
        m_color = color;
    }

    public abstract boolean canMove(Cell from, Cell to);

    public final Color getColor()
    {
        return m_color;
    }
}
