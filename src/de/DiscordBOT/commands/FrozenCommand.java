package de.DiscordBOT.commands;

import java.util.LinkedList;
import java.util.Random;

import de.DiscordBOT.Audio.PlayURL;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class FrozenCommand implements ServerCommand {

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		//Play random song from frozen!
		LinkedList<String> urls = new LinkedList<String>();
		urls.add("https://www.youtube.com/watch?v=a1HL26K1nL0"); //All is found
		urls.add("https://www.youtube.com/watch?v=_a0PscfuhGo"); //Some Things Never Change
		urls.add("https://www.youtube.com/watch?v=l1uoTMkhUiE"); //Into the Unknown
		urls.add("https://www.youtube.com/watch?v=MJV4vjlziNI"); //When i am older
		urls.add("https://www.youtube.com/watch?v=qiGcfay5jNY"); //Lost in the woods
		urls.add("https://www.youtube.com/watch?v=md7dK5-qvHc"); //Show yourself
		urls.add("https://www.youtube.com/watch?v=w6g1yQV0dIY"); //The next right thing =(
		urls.add("https://www.youtube.com/watch?v=BrtibLyqrdw"); //For the first time in forever
		urls.add("https://www.youtube.com/watch?v=L0MK7qz13bU"); //LET IT GOOOOOOOOOOOOOOOOOOOOOOOOOOOO LET IT GOOOOOOOOOOOOOOOOOO
		urls.add("https://www.youtube.com/watch?v=dzGxTj3WoAA"); //Do you want to build a snowman
		urls.add("https://www.youtube.com/watch?v=aYCmv0zgjf0"); //Vuelie (Intro)
		
		int RandomIndex = new Random().nextInt(urls.size());
		channel.sendMessage("Viel Spa�!").queue();
		PlayURL.PlayAudio(urls.get(RandomIndex), m, channel, false);
	}
}