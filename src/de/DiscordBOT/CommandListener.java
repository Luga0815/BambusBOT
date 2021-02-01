package de.DiscordBOT;

import java.util.LinkedList;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.Permission;

public class CommandListener extends ListenerAdapter{
	
	
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String msg = event.getMessage().getContentDisplay();
		
		//event from private chat do nothing
		if(!event.isFromType(ChannelType.TEXT)) return;
		
		//Permission system
		Member mem = event.getMember();
		LinkedList<Permission> per = new LinkedList<Permission>();
		per.add(Permission.ADMINISTRATOR);
		int permission = 0;
		long id = event.getMember().getIdLong();
		
		//permission = 0 => Member
		//permission = 1 => Admin (or admin permission on the server)
		//permission = 2 => My Discord account =)
		
		if(mem.hasPermission(per)) permission = 1;
		if(id == TOKEN.LUGAID) permission = 2;
		
		//Run Commands
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			hidden(msg, channel);
			if(msg.startsWith("!b ")) {
				//msg starts with "!b" so we need to check the command
				String[] args = msg.substring(3).split(" ");
				if(args.length > 0) {
					if(!Main.INSTANCE.getCmdMan().perform(args[0], mem, channel, event.getMessage(), permission)) {
						//There is no command with the given arg
						channel.sendMessage("WAS WILLST DU VON MIR?!?!?!?!").queue();
					}
				}
			}
		}
	}
	
	//Some easter eggs
	public void hidden(String msg, TextChannel channel) {
		if(msg.trim().equalsIgnoreCase("doctor")) {
			channel.sendMessage("WHO?").queue();
		}
		else if(msg.trim().equalsIgnoreCase("pog")) {
			channel.sendMessage("poggers").queue();
		}
	}
}