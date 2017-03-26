package by.htp.shop.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.shop.dao.exception.DAOException;

public interface Command {
	void execute(HttpServletRequest request, HttpServletResponse response) throws DAOException, IOException, ServletException;

}
