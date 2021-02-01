package de.DiscordBOT.Audio;

import java.util.LinkedList;

public class QueueHandler {
	static LinkedList<Queue> queues = new LinkedList<Queue>();
	public static void addQueue(Queue q) {
		queues.add(q);
	}
	public static void removeQueue(Queue q) {
		queues.remove(q);
	}
	public static Queue getQueuebyServerID(long serverID) {
		Queue hold = null;
		for(Queue q : queues) {
			if(q.getServerID() == serverID) {
				hold = q;
			}
		}
		return hold;
	}
}
