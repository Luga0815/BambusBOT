package de.DiscordBOT;

import de.DiscordBOT.Audio.PlayURL;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildVoiceJoin extends ListenerAdapter{

	@Override
	public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
		Member m = event.getMember();
		
		//THIS IS NOT A GOOD WAY TO DO THIS HEEEEEEELLPPPP
		if(event.getMember().getEffectiveName().equalsIgnoreCase("kai")) {
			PlayURL.PlayAudio("https://www.youtube.com/watch?v=K1CFySevifE", m, null, true);
		}
		else if(event.getMember().getEffectiveName().equalsIgnoreCase("thilos")) {
			PlayURL.PlayAudio("https://www.youtube.com/watch?v=5LU8PdyWslM", m, null, true);
		}
		else if(event.getMember().getEffectiveName().equalsIgnoreCase("puya")) {
			PlayURL.PlayAudio("https://www.youtube.com/watch?v=AHv4XuonFOY", m, null, true);
		}
		else if(event.getMember().getEffectiveName().equalsIgnoreCase("boomger")) {
			PlayURL.PlayAudio("https://www.youtube.com/watch?v=-15VC4Yxzys", m, null, true);
		}
		else if(event.getMember().getEffectiveName().equalsIgnoreCase("luga")) {
			PlayURL.PlayAudio("https://www.youtube.com/watch?v=hUuSezKRTx4", m, null, true);
		}
		else if(event.getMember().getEffectiveName().equalsIgnoreCase("derservy")) {
			PlayURL.PlayAudio("https://www.youtube.com/watch?v=Uo2SNtFofWI", m, null, true);
		}
		else if(event.getMember().getEffectiveName().equalsIgnoreCase("cookie")) {
			PlayURL.PlayAudio("https://www.youtube.com/watch?v=tLyRpGKWXRs", m, null, true);
		}
	}
}