package by.htp.shop.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.shop.controller.command.impl.GoToAdminPage;
import by.htp.shop.controller.command.impl.GoToSignInError;
import by.htp.shop.controller.command.impl.GoToUserInfo;
import by.htp.shop.controller.command.impl.GoToUserPage;
import by.htp.shop.controller.command.impl.GoToUsersList;
import by.htp.shop.controller.command.impl.Localization;
import by.htp.shop.controller.command.impl.RegisterUser;
import by.htp.shop.controller.command.impl.RegistrationProcess;
import by.htp.shop.controller.command.impl.SignIn;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.SIGN_IN, new SignIn());
		commands.put(CommandName.LOCALIZATION, new Localization());
		commands.put(CommandName.GOTO_USER, new GoToUserPage());
		commands.put(CommandName.GOTO_USER_INFO, new GoToUserInfo());
		commands.put(CommandName.GOTO_ADMIN, new GoToAdminPage());
		commands.put(CommandName.GOTO_USERS_LIST, new GoToUsersList());
		commands.put(CommandName.GOTO_SIGNIN_ERROR, new GoToSignInError());
		commands.put(CommandName.REGISTER_USER, new RegisterUser());
		commands.put(CommandName.REG_PROCESS, new RegistrationProcess());
	}

	public Command getCommand(String name) {
		CommandName commandName = CommandName.valueOf(name.toUpperCase());

		return commands.get(commandName);

	}
}