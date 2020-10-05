package Chess.Domain.Enums;

public enum CellLine 
{
    Line_1(0, "0"),
    Line_2(1, "1"),
    Line_3(2, "2"),
    Line_4(3, "3"),
    Line_5(4, "4"),
    Line_6(5, "5"),
    Line_7(6, "6"),
    Line_8(7, "7");

    private int m_value; 
    private String m_string;

    private CellLine(int value, String string)
    {
        m_value = value;
        m_string = string;
    }

    public int value()
    {
        return m_value;
    }

    public String string()
    {
        return m_string;
    }
}
