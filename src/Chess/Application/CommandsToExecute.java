package Chess.Application;

import java.util.ArrayDeque;

public class CommandsToExecute 
{
    private ArrayDeque<CommandITF> m_commands;

    public CommandsToExecute()
    {
        m_commands = new ArrayDeque<>();
    }

    public synchronized void push(CommandITF c)
    {
        m_commands.addLast(c);
    }

    public synchronized CommandITF pop()
    {
        return m_commands.pollFirst();
    }
}
