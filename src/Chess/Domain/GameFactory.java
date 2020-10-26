package Chess.Domain;

public class GameFactory 
{
    public GameFactory()
    {

    }    

    public Game CreateNewGame(long gameId)
    {
        return new Game(gameId);
    }
}
