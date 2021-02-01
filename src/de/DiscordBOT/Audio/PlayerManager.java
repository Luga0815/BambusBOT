package de.DiscordBOT.Audio;

import java.util.concurrent.ConcurrentHashMap;

import de.DiscordBOT.Main;

public class PlayerManager {
	
	public ConcurrentHashMap<Long, AudioController> controllers;
	
	public PlayerManager() {
		this.controllers = new ConcurrentHashMap<Long, AudioController>();
		
	}
	public AudioController getController(long serverID) {
		AudioController ac = null;
		
		if(this.controllers.containsKey(serverID)) {
			ac = this.controllers.get(serverID);
		}
		else {
			ac = new AudioController(Main.INSTANCE.shardMan.getGuildById(serverID));
			this.controllers.put(serverID, ac);
		}
		
		return ac;
	}
}
