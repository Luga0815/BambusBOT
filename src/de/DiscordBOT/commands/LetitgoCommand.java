package de.DiscordBOT.commands;

import de.DiscordBOT.Audio.PlayURL;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class LetitgoCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		PlayURL.PlayAudio("https://www.youtube.com/watch?v=L0MK7qz13bU", m, channel, false);
	}
}