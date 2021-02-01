package de.DiscordBOT.Audio;

import java.util.LinkedList;

import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

public class Queue {
	LinkedList<AudioTrack> queue;
	long serverID;
	
	public Queue(long serverID) {
		queue = new LinkedList<AudioTrack>();
		this.serverID = serverID;
	}
	
	public void queueFirst(AudioTrack track) {
		queue.addFirst(track);
	}
	
	public void addToQueue(AudioTrack track) {
		queue.add(track);
		System.out.println("Queue size: " + queue.size());
	}
	public AudioTrack getNextTrack() {
		if(queue.size() > 0) {
			return queue.remove();
		}
		return null;
	}
	
	public int getQueueSize() {
		return queue.size();
	}
	
	public void addPlaylist(AudioPlaylist list) {
		queue.addAll(list.getTracks());
		System.out.println(queue.size());
	}
	
	public void clearQueue() {
		queue.clear();
	}
	
	public LinkedList<AudioTrack> getQueue() {
		return queue;
	}
	
	public long getServerID() {
		return serverID;
	}
}