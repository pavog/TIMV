package com.evilcodes.timv.handlers;

import com.evilcodes.timv.TIMV;

public class MessagesHandler {
	
	public static String noPermission(String permission) {
		final String msg1 = TIMV.messages.getString("NoPermissions").replace("&", "§").replace("%permission%", permission);
		final String msg = TIMV.messages.getString("Prefix").replace("&", "§") + msg1;
		return msg;
	}

	public static String convert(String message) {
		final String msg1 = TIMV.messages.getString(message).replace("&", "§");
		final String msg = TIMV.messages.getString("Prefix").replace("&", "§") + msg1;
		return msg;
	}
	
	public static String noPlayer() {
		final String msg1 = TIMV.messages.getString("NoPlayer").replace("&", "§");
		final String msg = TIMV.messages.getString("Prefix").replace("&", "§") + msg1;
		return msg;
	}
	
}
