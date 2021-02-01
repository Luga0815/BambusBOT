package de.DiscordBOT.commands;

import java.util.LinkedList;
import java.util.Random;

import de.DiscordBOT.Audio.PlayURL;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class KdaCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		//Play random kda song
		LinkedList<String> urls = new LinkedList<String>();
		urls.add("https://www.youtube.com/watch?v=UOxkGD8qRB4");
		urls.add("https://www.youtube.com/watch?v=3VTkBuxU4yk");
		urls.add("https://www.youtube.com/watch?v=RkID8_gnTxw");
		urls.add("https://www.youtube.com/watch?v=xoWxv2yZXLQ");
		urls.add("https://www.youtube.com/watch?v=WW1BpABbzHs");
		urls.add("https://www.youtube.com/watch?v=E_PbH5y70Tc");
		
		int RandomIndex = new Random().nextInt(urls.size());
		PlayURL.PlayAudio(urls.get(RandomIndex), m, channel, false);
		
	}
	
}
