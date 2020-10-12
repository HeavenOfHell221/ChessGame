package Chess.Domain;

public enum CellColumn 
{
    
    Column_a(0, "a"),
    Column_b(1, "b"),
    Column_c(2, "c"),
    Column_d(3, "d"),
    Column_e(4, "e"),
    Column_f(5, "f"),
    Column_g(6, "g"),
    Column_h(7, "h");

    private int m_value;
    private String m_string;

    private CellColumn(int value, String string)
    {
        m_value = value;
        m_string = string;
    }

    public int getValue()
    {
        return m_value;
    }

    public String getString()
    {
        return m_string;
    }

    public static int getAbsDistance(CellColumn from, CellColumn to)
    {
        return Math.abs(to.m_value - from.m_value);
    }
}