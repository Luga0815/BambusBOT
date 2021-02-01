package de.DiscordBOT.commands;

import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HiCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		//
		channel.sendMessage("Hallo " + m.getEffectiveName()).queue();
	}
}
