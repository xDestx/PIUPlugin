package com.xdestcb.piu;

import com.mdc.combot.ComBot;
import com.mdc.combot.plugin.BotPlugin;

public class PIUPlugin implements BotPlugin {

	@Override
	public void disable() {
		ComBot.getBot().getLogger().info("PIU ending...!");
	}

	@Override
	public void enable() {
		ComBot.getBot().getLogger().info("PIU starting...!");
	}

}
