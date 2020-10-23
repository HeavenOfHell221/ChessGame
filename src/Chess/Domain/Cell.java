package Chess.Domain;

/* VALUE OBJECT */

public class Cell
{
    private final CellLine m_line;
    private final CellColumn m_column;
    private final Color m_cellColor;

    public static Cell newFactory(CellColumn column, CellLine line)
    {
        Debug.ASSERT(line != null && column != null, "Un attribut de la classe Case est null.");
        return new Cell(column, line);
    }

    private Cell(CellColumn column, CellLine line) 
    {
        m_line = line;
        m_column = column;
        m_cellColor = (line.getValue() * column.getValue() % 2) == 0 ? Color.White : Color.Black;
    }

    public CellLine getLine() 
    {
        return m_line;
    }

    public CellColumn getColumn() 
    {
        return m_column;
    }

    public Color getColor() 
    {
        return m_cellColor;
    }

    @Override
    public int hashCode() 
    {
		return (m_column.getString() + m_line.getString()).hashCode();
	}

	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cell))
            return false;
        Cell other = (Cell) obj;
        return (m_column == other.m_column) && (m_line == other.m_line);
    }

    @Override
    public String toString() {
        return "Cell [" + m_column.getString() + ", " + m_line.getString() + "]";
    }

    
}
