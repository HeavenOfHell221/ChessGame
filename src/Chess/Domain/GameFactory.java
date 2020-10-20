package Chess.Domain;

public class GameFactory 
{
    public GameFactory()
    {

    }    

    public Game gameFactory(long gameId)
    {
        return new Game(gameId);
    }
}
