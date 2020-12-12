package server.models;

import java.util.ArrayList;
import java.util.List;

public class UserSynchronizer {
	private List<String> activeUsers = new ArrayList<String>();

	public synchronized boolean isActive(String nombre) {
		return activeUsers.contains(nombre);
	}

	public void addUser(String name) {
		activeUsers.add(name);
	}

	public void removeUser(String name) {
		activeUsers.remove(name);
	}
}
