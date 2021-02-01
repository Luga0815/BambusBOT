package de.DiscordBOT.commands;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class Gen2TeamsCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		//OH NO
		String[] args = msg.getContentDisplay().substring(3).split(" ");
		boolean am = false;
		boolean hasPerm = false;
		
		//Set auto move flag
		if(args.length > 1) if(args[1].equalsIgnoreCase("am")) am = true;
		//Check if we have admin permission
		if(permission >= 1) hasPerm = true;
		
		VoiceChannel userChannel = m.getVoiceState().getChannel();
		
		if(userChannel == null) {
			channel.sendMessage("Du bist in keinem VoiceChannel!").queue();
			return;
		}
		
		LinkedList<Member> membersOnUserChannel = new LinkedList<Member>();
		for(Member mem : userChannel.getMembers()) {
			membersOnUserChannel.add(mem);
		}
		
		LinkedList<Member> team1List = new LinkedList<Member>();
		LinkedList<Member> team2List = new LinkedList<Member>();
		
		//Auto Move stuff
		Guild server = channel.getGuild();
		List<VoiceChannel> allVoiceChannels = server.getVoiceChannels();
		VoiceChannel team1VC = null;
		VoiceChannel team2VC = null;
		
		if(am) {
			if(hasPerm) {
				channel.sendMessage("Teams werden erstellt und leute werden gemoved!").queue();
				for(VoiceChannel room : allVoiceChannels) {
					if(room.getName().equals("Team 1")) {
						team1VC = room;
					}
					if(room.getName().equals("Team 2")) {
						team2VC = room;
					}
				}
			}
			else {
				channel.sendMessage("Du hast keine berechtigung daf�r!").queue();
				return;
			}
			
		}
		else {
			channel.sendMessage("Teams werden erstellt!").queue();
		}
		
		//NO FUCKING CLUE WHAT THIS IS something with teams and auto move shit
		int count = 0;
		while (!membersOnUserChannel.isEmpty()) {
			count++;
			int randomIndex = new Random().nextInt(membersOnUserChannel.size());
			Member hold = membersOnUserChannel.remove(randomIndex);
			if(count % 2 == 0) {
				team1List.add(hold);
			}
			else {
				team2List.add(hold);
			}
		}
		
		String output = "Team 1:\n";
		for(Member mem : team1List) {
			output += mem.getEffectiveName() + "\n";
			if(am && hasPerm) {
				server.moveVoiceMember(mem, team1VC).complete();
			}
		}
		output += "\nTeam 2: \n";
		for(Member mem : team2List) {
			output += mem.getEffectiveName() + "\n";
			if(am && hasPerm) {
				server.moveVoiceMember(mem, team2VC).complete();
			}
		}
		channel.sendMessage(output).queue();
	}
}
