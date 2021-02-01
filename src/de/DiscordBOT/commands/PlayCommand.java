package de.DiscordBOT.commands;

import java.awt.Color;

import de.DiscordBOT.Audio.PlayURL;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class PlayCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		String[] args = msg.getContentDisplay().split(" ");
		
		//Setup stuff
		if(args.length > 1) {
			GuildVoiceState vs;
			if((vs = m.getVoiceState()) != null) {
				@SuppressWarnings("unused")
				VoiceChannel vc;
				if((vc = vs.getChannel()) != null) {
					
					//Build the search quarry
					StringBuilder strBuilder = new StringBuilder();
					for(int i = 2; i<args.length; i++) strBuilder.append(args[i] + " ");
					
					String url = strBuilder.toString().trim();
					
					//add ytsearch: if the string is not an URL
					if(!url.startsWith("http")) {
						url = "ytsearch:" + url;
					}
					PlayURL.PlayAudio(url, m, channel, false);
				}
				else {
					EmbedBuilder builder = new EmbedBuilder();
					builder.setDescription("Du bist in keinem VoiceChannel!");
					builder.setColor(Color.red);
					channel.sendMessage(builder.build()).queue();
				}
			}
		}
		else {
			EmbedBuilder builder = new EmbedBuilder();
			builder.setDescription("Nutze !b play <URL/SUCHE> um einen song abzuspielen!");
			builder.setColor(Color.red);
			channel.sendMessage(builder.build()).queue();
		}
	}
}
