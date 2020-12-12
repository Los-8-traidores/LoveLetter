package server.models;

import java.util.ArrayList;
import java.util.List;

import model.Game;

public class RoomSynchronizer {
	private List<Game> games = new ArrayList<>();

    public synchronized List<Game> obtenerSalas() {
        return games;
    }

    public synchronized void agregarSala(Game game) {
    	games.add(game);
    }
}
