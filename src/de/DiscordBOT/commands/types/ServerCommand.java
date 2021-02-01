package de.DiscordBOT.commands.types;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

//Template for all commands
public interface ServerCommand {
	public void performCommand(Member m, TextChannel channel, Message msg, int permission);
}
