package de.DiscordBOT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.ShardManager;

public class ServerConsole implements Runnable {
	
	public ShardManager shardMan;
	
	@Override
	public void run() {
		shardMan = Main.INSTANCE.shardMan;
		System.out.println("Console Starting...");
		
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while((line = reader.readLine()) != null) {
				if(line.equalsIgnoreCase("exit")) {
					if(shardMan != null) {
						shardMan.setStatus(OnlineStatus.OFFLINE);
						shardMan.shutdown();
						System.out.println("BOT Offline!");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}