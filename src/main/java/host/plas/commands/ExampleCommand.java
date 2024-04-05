package host.plas.commands;

import host.plas.ExampleModule;
import net.streamline.api.command.ModuleCommand;
import net.streamline.api.command.StreamlineCommand;
import net.streamline.api.command.context.CommandContext;
import net.streamline.api.data.console.StreamSender;
import net.streamline.api.modules.ModuleUtils;

import java.util.concurrent.ConcurrentSkipListSet;

public class ExampleCommand extends ModuleCommand {
    public ExampleCommand() {
        super(ExampleModule.getInstance(),
                "example",
                "streamline.command.example.default",
                "ex", "exmpl");
    }

    @Override
    public void run(CommandContext<StreamlineCommand> context) {
        StreamSender streamSender = context.getSender();

        streamSender.sendMessage(ModuleUtils.codedString("&bHello world!")); // Send a message to the user.
        streamSender.sendMessage(ModuleUtils.codedString(ModuleUtils.replacePlaceholders(streamSender, "&bPlaceholder 1: &a%example_arg1%"))); // Can also parse placeholders.
        streamSender.sendMessage(ModuleUtils.codedString(ModuleUtils.replacePlaceholders(streamSender, "&bPlaceholder 2: &a%example_arg2_anythingcangohere%"))); // Advanced placeholders.
    }

    @Override
    public ConcurrentSkipListSet<String> doTabComplete(CommandContext<StreamlineCommand> context) {
        return new ConcurrentSkipListSet<>(); // Return an empty set to disable tab completion.
    }
}
