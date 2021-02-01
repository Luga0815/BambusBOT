package de.DiscordBOT.commands;

import java.util.Random;

import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class GayCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		
		
		int gayLevel = new Random().nextInt(10);
		channel.sendMessage("Gay Level: " + gayLevel + "/10").queue();
	}
}