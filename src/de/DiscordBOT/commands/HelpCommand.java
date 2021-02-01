package de.DiscordBOT.commands;

import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		EmbedBuilder builder  = new EmbedBuilder();
		builder.setDescription("Alle Befehle");
		//There is a better way to do this but hey
		builder.setFooter("!b Hi \n!b bhop \n!b 2teams \n!b kaitheme \n!b kaizitat \n!b play <URL> \n!b stop");
		builder.setAuthor("BambusBOT");
		channel.sendMessage(builder.build()).queue();
	}
}
