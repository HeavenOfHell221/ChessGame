package Chess.Infra;

import Chess.Domain.Debug;
import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;

public class GameRepositoryInJSON implements GameRepositoryITF
{
    public GameRepositoryInJSON()
    {

    }    

    public void save(Game g)
    {
        // On save en JSON
        Debug.log("Save en JSON.");
    }

    public Game load(long id)
    {
        // On lit du JSON
        return null;
    }
}
