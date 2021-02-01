package de.DiscordBOT.commands;

import de.DiscordBOT.Audio.PlayURL;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HuehueCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		// TODO Auto-generated method stub
		PlayURL.PlayAudio("https://www.youtube.com/watch?v=c5kQLKs_dmI", m, channel, false);
	}
	
}
