package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.SharedFunctions;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import static com.automationanywhere.commandsdk.model.AttributeType.SELECT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

//BotCommand makes a class eligible for being considered as an action.
@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "GetSystemVariables", label = "Get System Variables",
        node_label = "Get System Variables",  description = "Return Various System Values", icon = "pkg.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "Returned System Value", return_type = STRING, return_required = true)
public class GetSystemVariables {
    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory
            .getMessages("com.automationanywhere.botcommand.samples.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<String> action(
            @Idx(index = "1", type = SELECT, options = {
                    @Idx.Option(index ="1.1", pkg = @Pkg(label = "Get User Name", value = "GetUserName")),
                    @Idx.Option(index ="1.2", pkg = @Pkg(label = "Get User Home Dir", value = "GetUserHome")),
                    @Idx.Option(index ="1.3", pkg = @Pkg(label = "Get OS Name", value = "GetOSName")),
                    @Idx.Option(index ="1.4", pkg = @Pkg(label = "Get OS Version", value = "GetOSVersion")),
                    @Idx.Option(index ="1.5", pkg = @Pkg(label = "Get OS Architecture", value = "GetOSArch")),
                    @Idx.Option(index ="1.6", pkg = @Pkg(label = "Get Current Working Dir", value = "GetWorkingDir")),
                    @Idx.Option(index ="1.7", pkg = @Pkg(label = "Get User Downloads Dir", value = "GetDownloads")),
                    @Idx.Option(index ="1.8", pkg = @Pkg(label = "Get Host Name", value = "GetHostName")),
                    @Idx.Option(index ="1.9", pkg = @Pkg(label = "Get IP Address", value = "GetIPAddress")),
            })
            @Pkg(label = "Select Variable to Return")
                String select) {

        //Internal validation, to disallow empty strings. No null check needed as we have NotEmpty on firstString.
        String result = "";
        switch (select){
            case "GetUserName":
                result = SharedFunctions.getUser();
                break;
            case "GetUserHome":
                result = SharedFunctions.getHome();
                break;
            case "GetOSName":
                result = SharedFunctions.getOperatingSystem();
                break;
            case "GetOSVersion":
                result = SharedFunctions.getOperatingSystemVersion();
                break;
            case "GetOSArch":
                result = SharedFunctions.getOperatingSystemArchitecture();
                break;
            case "GetWorkingDir":
                result = SharedFunctions.getCurrentWorkingDir();
                break;
            case "GetDownloads":
                result = SharedFunctions.getDownloads();
                break;
            case "GetHostName":
                result = SharedFunctions.getHostName();
                break;
            case "GetIPAddress":
                result = SharedFunctions.getIPAddress();
                break;
        }

//        throw new BotCommandException(MESSAGES.getString("emptyInputString", "sourceString"));

        //Return StringValue.
        return new StringValue(result);
    }
}
