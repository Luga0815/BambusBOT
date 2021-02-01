package de.DiscordBOT.commands;

import java.util.LinkedList;
import java.util.Random;

import de.DiscordBOT.Audio.PlayURL;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class KaizitatCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		LinkedList<String> urls = new LinkedList<String>();
		urls.add("https://www.youtube.com/watch?v=yJMYgnYvMoc&feature=youtu.be");
		int RandomIndex = new Random().nextInt(urls.size());
		PlayURL.PlayAudio(urls.get(RandomIndex), m, channel, false);
	}	
}