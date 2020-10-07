package Chess.Infra;

import Chess.Domain.Debug;
import Chess.Domain.Game;
import Chess.Domain.IGameRepository;

public class GameRepositoryInJSON implements IGameRepository
{
    public GameRepositoryInJSON()
    {

    }    

    public void save(Game g)
    {
        // On save en JSON
        Debug.log("Save en JSON.");
    }

    public Game load(int id)
    {
        // On lit du JSON
        return null;
    }
}
