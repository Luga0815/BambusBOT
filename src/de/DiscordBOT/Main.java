package de.DiscordBOT;

import javax.security.auth.login.LoginException;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;

import de.DiscordBOT.Audio.PlayerManager;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class Main {
	
	//BOT
	public ShardManager shardMan;
	public static Main INSTANCE;
	
	//Commands
	private CommandManager cmdMan;
	
	//Audio
	public AudioPlayerManager audioPlayerManager;
	public PlayerManager manager;
	
	public static void main(String[] args) {
		try {
			new Main();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Main() throws LoginException, IllegalArgumentException {
		INSTANCE = this;
		
		//Create a new instance of BOT builder
		DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(TOKEN.TOKEN);
		
		//BOT Status
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setActivity(Activity.listening("Th� � la Menthe"));
		
		//Listeners
		builder.addEventListeners(new CommandListener());
		builder.addEventListeners(new GuildVoiceJoin());
		
		//Audio
		this.audioPlayerManager = new DefaultAudioPlayerManager();
		this.manager = new PlayerManager();
		
		//Commands
		this.cmdMan = new CommandManager();
		
		shardMan = builder.build();
		System.out.println("BOT Online!");
		
		//Audio Register
		AudioSourceManagers.registerRemoteSources(audioPlayerManager);
		audioPlayerManager.getConfiguration().setFilterHotSwapEnabled(true);
		
		//Setup Server Console : TODO
		Thread serverConsoleThread = new Thread(new ServerConsole());
		serverConsoleThread.start();
		
		//XML reader : TODO
		XMLReader reader = new XMLReader();
	}
	
	public CommandManager getCmdMan() {
		return cmdMan;
	}
}