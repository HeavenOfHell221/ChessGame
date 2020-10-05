package Chess.Domain;

public class Debug 
{
    private static boolean DisplayDebug = true;

    public static void log(String message)
    {
        if(DisplayDebug)
            System.out.println("Log : " + message);
    }
    
    public static void logError(String message)
    {
        System.out.println(ConsoleColors.RED + "ERROR : " + message + ConsoleColors.RESET);
    }

    public static void ASSERT(boolean test, String message)
    {
        if(test == false)
        {
            throw new RuntimeException(ConsoleColors.RED + message + ConsoleColors.RESET);
        }
    }
}
