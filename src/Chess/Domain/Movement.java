package Chess.Domain;

/* VALUE OBJECT */

public class Movement 
{
    private final Cell m_origin;
    private final Cell m_destination;

    public Movement(Cell from, Cell to)
    {
        m_origin = from;
        m_destination = to;
    }

    public Cell getOrigin()
    {
        return m_origin;
    }

    public Cell getDestination()
    {
        return m_destination;
    }
}
