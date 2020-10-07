package Chess;

import Chess.Domain.Game;
import Chess.Domain.GameRepositoryITF;
import Chess.Infra.GameRepositoryInJSON;

public class Main 
{
    public static void main(String[] args) 
    {
        Game g = new Game();
        GameRepositoryITF repo = new GameRepositoryInJSON();
        repo.save(g);
    }    
}
