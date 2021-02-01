package de.DiscordBOT.commands;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;

import de.DiscordBOT.Main;
import de.DiscordBOT.Audio.AudioController;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class PauseCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		GuildVoiceState vs;
		if((vs = m.getVoiceState()) != null) {
			VoiceChannel vc;
			if((vc = vs.getChannel()) != null) {
				AudioController controller = Main.INSTANCE.manager.getController(vc.getGuild().getIdLong());
				AudioPlayer player = controller.getPlayer();
				
				if(player.isPaused()) {
					player.setPaused(false);
				}
				else {
					player.setPaused(true);
				}
			}
		}
	}
}