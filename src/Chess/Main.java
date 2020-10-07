package Chess;

import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;
import Chess.Infra.GameRepositoryInMemory;

public class Main 
{
    public static void main(String[] args) 
    {
        Game g = new Game(10);
        GameRepositoryITF repo = new GameRepositoryInMemory();
        repo.save(g);
        Game g2 = repo.load(10);
    }    
}
