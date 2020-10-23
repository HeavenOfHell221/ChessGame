package Chess.Application;

import java.util.ArrayDeque;

public class CommandToExecute 
{
    private ArrayDeque<CommandITF> m_commands;
    private boolean m_stopThreads = false;
    
    public CommandToExecute()
    {
        m_commands = new ArrayDeque<>();
    }

    public synchronized void addCommand(CommandITF c)
    {
        m_commands.addLast(c);
    }

    // Mot clé synchronized : Permet d'empêcher plusieurs threads d'executer cette méthode en même temps 
    // (un mutex en quelque sorte)
    public synchronized CommandITF getCommand()
    {
        return m_commands.pollFirst();
    }

    public void stopThreads()
    {
        m_stopThreads = true;
    }

    public boolean getStopThreads()
    {
        return m_stopThreads;
    }
}
