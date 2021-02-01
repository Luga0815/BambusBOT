package de.DiscordBOT;

import java.util.concurrent.ConcurrentHashMap;

import de.DiscordBOT.commands.Gen2TeamsCommand;
import de.DiscordBOT.commands.*;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class CommandManager {
	
	public ConcurrentHashMap<String, ServerCommand> commands;
	
	public CommandManager() {
		this.commands = new ConcurrentHashMap<>();
		
		//ALL COMMANDS
		this.commands.put("hi", new HiCommand());
		this.commands.put("2teams", new Gen2TeamsCommand());
		this.commands.put("play", new PlayCommand());
		this.commands.put("stop", new StopCommand());
		this.commands.put("test", new testCommand());
		this.commands.put("bhop", new BhopCommand());
		this.commands.put("kaitheme", new KaiThemeCommand());
		this.commands.put("kaizitat", new KaizitatCommand());
		this.commands.put("frozenistleben", new FrozenCommand());
		this.commands.put("help", new HelpCommand());
		this.commands.put("kda", new KdaCommand());
		this.commands.put("letitgo", new LetitgoCommand());
		this.commands.put("queue", new GetQueueCommand());
		this.commands.put("skip", new SkipCommand());
		this.commands.put("gaylevel", new GayCommand());
		this.commands.put("pause", new PauseCommand());
		this.commands.put("fuckitall", new FuckItAllCommand());
		this.commands.put("huehue", new HuehueCommand());
	}
	
	//Call command
	public boolean perform(String command, Member m, TextChannel channel, Message msg, int permission) {
		ServerCommand cmd;
		if((cmd = this.commands.get(command.toLowerCase())) != null) {
			System.out.println(m.getEffectiveName() + " | Run: " + command);
			cmd.performCommand(m, channel, msg, permission);
			return true;
		}
		return false;
	}
}