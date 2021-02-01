package de.DiscordBOT.Audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

import de.DiscordBOT.Main;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

//TODO Rename this function PlayURL is not the best name
public class PlayURL {
	public static void PlayAudio(String url, Member m, TextChannel channel, boolean hasPriority) {
		GuildVoiceState vs;
		if((vs = m.getVoiceState()) != null) {
			VoiceChannel vc;
			if((vc = vs.getChannel()) != null) {
				
				//Setup for audio controller stuff
				AudioController controller = Main.INSTANCE.manager.getController(vc.getGuild().getIdLong());
				AudioPlayerManager apm = Main.INSTANCE.audioPlayerManager;
				AudioManager manager = vc.getGuild().getAudioManager();
				
				Queue q = null;

				if(manager.isConnected()) {
					//We are in a voice channel so we already have a queue
					q = QueueHandler.getQueuebyServerID(vc.getGuild().getIdLong());
					
					if(q == null) {
						//THIS SHOULD NEVER RUN BUT IF WE HAVE NO QUEUE AT THIS POINT WE CREATE A NEW QUEUE
						q = new Queue(vc.getGuild().getIdLong());
						QueueHandler.addQueue(q);
					}
				}
				else {
					//We are not in a voice channel so we create a new queue
					manager.openAudioConnection(vc);
					q = new Queue(vc.getGuild().getIdLong());
					QueueHandler.addQueue(q);
					controller.getPlayer().addListener(new TrackHandler(q, channel));
				}
				
				//load the URL or search quarry
				//URL must be a final string for some fucking reason
				final String finalURL = url;
				apm.loadItem(finalURL, new SearchResultHandler(controller, q, channel, hasPriority));
			}
		}
	}
}