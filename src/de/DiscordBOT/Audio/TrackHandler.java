package de.DiscordBOT.Audio;

import java.awt.Color;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class TrackHandler extends AudioEventAdapter{
	
	Queue queue;
	TextChannel channel;
	
	public TrackHandler(Queue queue, TextChannel channel) {
		this.queue = queue;
		this.channel = channel;
	}
	
	@Override
	public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
		AudioTrack nextTrack = queue.getNextTrack();
		//Check if we have a track in the queue
		if(nextTrack != null) {
			//play next track
			player.playTrack(nextTrack);
			
			//Display Message
			EmbedBuilder builder  = new EmbedBuilder();
			builder.setDescription("Now Playing!");
			builder.setFooter(nextTrack.getInfo().title);
			builder.setAuthor("BambusBOT");
			builder.setColor(Color.green);
			channel.sendMessage(builder.build()).queue();
		}
		else {
			//No song left =(
			//Display Message
			EmbedBuilder builder  = new EmbedBuilder();
			builder.setDescription("End of queue!");
			builder.setAuthor("BambusBOT");
			builder.setColor(Color.red);
			channel.sendMessage(builder.build()).queue();
		}
	}
}