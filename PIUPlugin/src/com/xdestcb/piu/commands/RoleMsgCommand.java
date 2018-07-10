package com.xdestcb.piu.commands;

import com.mdc.combot.ComBot;
import com.mdc.combot.command.Command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RoleMsgCommand implements Command {

	@Override
	public void called(ComBot arg0, MessageReceivedEvent arg1) {
		
	}

	@Override
	public String getLabel() {
		return "rolemsg";
	}

}
