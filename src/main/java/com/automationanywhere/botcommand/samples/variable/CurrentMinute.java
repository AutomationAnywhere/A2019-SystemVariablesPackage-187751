package com.automationanywhere.botcommand.samples.variable;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.SharedFunctions;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.VariableExecute;
import com.automationanywhere.commandsdk.model.DataType;

@BotCommand(commandType = BotCommand.CommandType.Variable)
@CommandPkg(description = "Returns current 2 digit minute", name = "CurrentMinute", label = "CurrentMinute", variable_return_type = DataType.STRING)

public class CurrentMinute {
    @VariableExecute
    public StringValue get() {
        return new StringValue(SharedFunctions.getCurrentMinute());
    }
}
