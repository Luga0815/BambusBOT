package de.DiscordBOT.commands;

import java.awt.Color;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import de.DiscordBOT.Main;
import de.DiscordBOT.Audio.Queue;
import de.DiscordBOT.Audio.QueueHandler;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class GetQueueCommand implements ServerCommand {

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		// TODO Auto-generated method stub
		GuildVoiceState vs;
		if((vs = m.getVoiceState()) != null) {
			VoiceChannel vc;
			if((vc = vs.getChannel()) != null) {
				Queue q = QueueHandler.getQueuebyServerID(vc.getGuild().getIdLong());
				if(q != null) {
					
					
					int count = 0;
					String output = "";
					output += "Now: " + Main.INSTANCE.manager.getController(vc.getGuild().getIdLong()).getPlayer().getPlayingTrack().getInfo().title + "\n";
					
					if(q.getQueueSize() >= 1) {
						for(AudioTrack track : q.getQueue()) {
							count++;
							output += count + ": " + track.getInfo().title + "\n";
						}
					}
					EmbedBuilder builder  = new EmbedBuilder();
					builder.setDescription("Queue");
					builder.setFooter(output);
					builder.setAuthor("BambusBOT");
					builder.setColor(Color.blue);
					channel.sendMessage(builder.build()).queue();
				}
				else {
					EmbedBuilder builder  = new EmbedBuilder();
					builder.setDescription("Queue is empty!");
					builder.setAuthor("BambusBOT");
					builder.setColor(Color.red);
					channel.sendMessage(builder.build()).queue();
				}
			}
		}
	}
}