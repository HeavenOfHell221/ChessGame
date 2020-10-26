package Chess.Application;

public class ThreadCommand implements Runnable
{
    private final CommandsToExecute m_commandToExecute;

    public ThreadCommand(CommandsToExecute commandToExecute)
    {
        m_commandToExecute = commandToExecute;
    }

    @Override
    public void run() 
    {
        while(true)
        {
            CommandITF c = m_commandToExecute.pop();
            if(c != null)
            {
                c.exec(); // Execute la commande
            }
        }
    }
}
