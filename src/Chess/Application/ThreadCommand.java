package Chess.Application;

public class ThreadCommand implements Runnable
{
    private final CommandToExecute m_commandToExecute;

    public ThreadCommand(CommandToExecute commandToExecute)
    {
        m_commandToExecute = commandToExecute;
    }

    @Override
    public void run() 
    {
        while(!m_commandToExecute.getStopThreads())
        {
            CommandITF c = m_commandToExecute.getCommand();
            if(c != null)
            {
                c.exec(); // Execute la commande
            }
        }
    }
}
