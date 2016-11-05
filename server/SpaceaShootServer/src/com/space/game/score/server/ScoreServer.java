package com.space.game.score.server;


public class ScoreServer {
	
	
	
	
	
	
	private ScoreServer()
    {
    }
    
    public static ScoreServer getInstance()
    {
        return Singleton.INSTANCE.getServer();
    }

    private enum Singleton
    {
        INSTANCE;

    	ScoreServer server;

        Singleton()
        {
            this.server = new ScoreServer();
        }

        ScoreServer getServer()
        {
            return server;
        }
    }
	
	
}
