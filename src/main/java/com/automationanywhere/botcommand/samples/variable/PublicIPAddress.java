package com.automationanywhere.botcommand.samples.variable;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.SharedFunctions;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.VariableExecute;
import com.automationanywhere.commandsdk.model.DataType;

@BotCommand(commandType = BotCommand.CommandType.Variable)
@CommandPkg(description = "Returns Public IP address of bot runner", name = "Public_IP_Address", label = "Public_IP_Address", variable_return_type = DataType.STRING)

public class PublicIPAddress {
    @VariableExecute
    public StringValue get() {
        return new StringValue(SharedFunctions.getPublicIP());
    }
}

