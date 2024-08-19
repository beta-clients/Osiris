package io.github.qe7.features.commands.impl;

import io.github.qe7.Osiris;
import io.github.qe7.features.commands.api.Command;
import io.github.qe7.utils.local.ChatUtil;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("Help", "Displays a list of commands and their descriptions");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.addPrefixedMessage("Help", "Commands:");

        for (Command command : Osiris.getInstance().getCommandManager().getMap().values()) {
            ChatUtil.addMessage("§7§l" + command.getName() + " - " + command.getDescription());
        }
    }
}
