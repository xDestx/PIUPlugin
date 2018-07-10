package com.xdestcb.piu.commands;

import com.mdc.combot.ComBot;
import com.mdc.combot.command.Command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RoleMsgCommand implements Command {

	@Override
	public void called(ComBot bot, MessageReceivedEvent e) {
		//check subcommand first
		String msg = e.getMessage().getContentRaw();
		String cmd = msg.replace(bot.getCommandPrefix(e.getGuild())+getLabel() + " ", "");
		String subCommand = cmd.split(" ")[0];
		switch(subCommand.toLowerCase()) {
		case "create":
			if(bot.memberHasPerm("piu.rolemsg.create", e.getMember())) {
				//format is as follows:
				/*
				 * ~rolemsg create [@role~:emoji:],[],[]...
				 */
				String[] roles = cmd.split(" ")[1].split(",");
				String finalMsg = "";
				for(String s : roles) {
					s = s.trim();
					if(s.startsWith("[") && s.endsWith("]")) {
						s = s.substring(1,s.length()-1);
						String[] args = s.split("~");
						String roleTag = args[0];
						String reactEmoji = args[1];
						finalMsg+="React with " + reactEmoji + " to assign the role **" + bot.getJDA().getRoleById(roleTag.replace("<","").replace(">","").replace("&","")).getName() + "**\n";
					} else {
						continue;
					}
				}
			} else {
				e.getTextChannel().sendMessage("Can't do that, sorry. Message xDest if this shouldn't've happened").queue();
			}
			break;
		default:
			e.getTextChannel().sendMessage("`" + subCommand + "`...? " + e.getAuthor().getAsMention()).queue();
			break;
		}
	}

	@Override
	public String getLabel() {
		return "rolemsg";
	}

}
