package Chess.Domain;

/* VALUE OBJECT */

public class Movement 
{
    private final Cell m_origin;
    private final Cell m_destination;

    public Movement(Cell from, Cell to)
    {
        Debug.ASSERT(from != null && to != null, "Creation d'un mouvement ayant une cellule vide!");
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

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((m_destination == null) ? 0 : m_destination.hashCode());
        result = prime * result + ((m_origin == null) ? 0 : m_origin.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movement other = (Movement) obj;
        if (m_destination == null) {
            if (other.m_destination != null)
                return false;
        } else if (!m_destination.equals(other.m_destination))
            return false;
        if (m_origin == null) {
            if (other.m_origin != null)
                return false;
        } else if (!m_origin.equals(other.m_origin))
            return false;
        return true;
    }

    
}
