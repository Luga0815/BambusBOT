package de.DiscordBOT.Audio;

import java.awt.Color;
import java.util.LinkedList;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class SearchResultHandler implements AudioLoadResultHandler{
	
	private final AudioController controller;
	private TextChannel channel;
	private Queue queue;
	private boolean hasPriority;
	
	public SearchResultHandler(AudioController controller, Queue queue, TextChannel channel, boolean hasPriority) {
		this.controller = controller;
		this.queue = queue;
		this.channel = channel;
		this.hasPriority = hasPriority;
	}
	
	@Override
	public void trackLoaded(AudioTrack track) {
		//Normal track
		if(controller.getPlayer().getPlayingTrack() == null) {
			System.out.println("No songs in queue!");
			controller.getPlayer().playTrack(track);
			
			//Display Message
			EmbedBuilder builder  = new EmbedBuilder();
			builder.setDescription("Now Playing!");
			builder.setFooter(track.getInfo().title);
			builder.setAuthor("BambusBOT");
			builder.setColor(Color.green);
			channel.sendMessage(builder.build()).queue();
		}
		else {
			if(hasPriority) {
				queue.queueFirst(track);
			}
			else {
				queue.addToQueue(track);
			}
			//Display Message
			EmbedBuilder builder  = new EmbedBuilder();
			builder.setDescription("Title in queue!");
			builder.setFooter("Queue Position: " + queue.getQueueSize());
			builder.setAuthor("BambusBOT");
			builder.setColor(Color.yellow);
			channel.sendMessage(builder.build()).queue();
		}
	}

	@Override
	public void playlistLoaded(AudioPlaylist playlist) {
		//TODO playlist only import the first song not the complete playlist
		LinkedList<AudioTrack> trackList = new LinkedList<AudioTrack>();
		trackList.addAll(playlist.getTracks());
		
		AudioTrack track = trackList.remove();
		
		if(controller.getPlayer().getPlayingTrack() == null) {
			//We are not playing anything so we can start the new track instant
			controller.getPlayer().playTrack(track);
			
			//Display Message
			EmbedBuilder builder  = new EmbedBuilder();
			builder.setDescription("Now Playing!");
			builder.setFooter(track.getInfo().title);
			builder.setAuthor("BambusBOT");
			builder.setColor(Color.green);
			channel.sendMessage(builder.build()).queue();
		}
		else {
			//We are playing something so we add the new song to the queue
			queue.addToQueue(track);
			
			//Display Message
			EmbedBuilder builder  = new EmbedBuilder();
			builder.setDescription("Title in queue!");
			builder.setFooter("Queue Position: " + queue.getQueueSize());
			builder.setAuthor("BambusBOT");
			builder.setColor(Color.yellow);
			channel.sendMessage(builder.build()).queue();
		}
	}

	@Override
	public void noMatches() {
		//No Song with name or URL
		//Display Message
		EmbedBuilder builder  = new EmbedBuilder();
		builder.setDescription("Kein Song gefunden!");
		builder.setAuthor("BambusBOT");
		builder.setColor(Color.red);
		channel.sendMessage(builder.build()).queue();
	}

	@Override
	public void loadFailed(FriendlyException exception) {
		//Error loading song probably copyright or age restricted
		channel.sendMessage("Track fehler!").queue();
	}
}
