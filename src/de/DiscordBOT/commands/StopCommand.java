package de.DiscordBOT.commands;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;

import de.DiscordBOT.Main;
import de.DiscordBOT.Audio.AudioController;
import de.DiscordBOT.Audio.Queue;
import de.DiscordBOT.Audio.QueueHandler;
import de.DiscordBOT.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public class StopCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message msg, int permission) {
		GuildVoiceState vs;
		if((vs = m.getVoiceState()) != null) {
			VoiceChannel vc;
			if((vc = vs.getChannel()) != null) {
				
				//get audio controller
				AudioController controller = Main.INSTANCE.manager.getController(vc.getGuild().getIdLong());
				AudioManager manager = vc.getGuild().getAudioManager();
				AudioPlayer player = controller.getPlayer();
				
				Queue q = QueueHandler.getQueuebyServerID(vc.getGuild().getIdLong());
				q.clearQueue();
				QueueHandler.removeQueue(q);
				
				//Stop
				player.stopTrack();
				manager.closeAudioConnection();
				
				//We never delete the queue this is not good!
			}
		}
	}
}