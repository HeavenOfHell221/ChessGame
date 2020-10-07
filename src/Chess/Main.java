package Chess;

import Chess.Domain.Game;
import Chess.Domain.IGameRepository;
import Chess.Infra.GameRepositoryInJSON;

public class Main 
{
    public static void main(String[] args) 
    {
        Game g = new Game();
        IGameRepository repo = new GameRepositoryInJSON();
        repo.save(g);
    }    
}
