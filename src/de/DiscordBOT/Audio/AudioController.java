package de.DiscordBOT.Audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;

import de.DiscordBOT.Main;
import net.dv8tion.jda.api.entities.Guild;

public class AudioController {
	
	private Guild server;
	private AudioPlayer player;
	
	public AudioController(Guild server) {
		this.server = server;
		this.player = Main.INSTANCE.audioPlayerManager.createPlayer();
		
		this.server.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(player));
	}
	
	public Guild getServer() {
		return server;
	}
	public AudioPlayer getPlayer() {
		return player;
	}
}