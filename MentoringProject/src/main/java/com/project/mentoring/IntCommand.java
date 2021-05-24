package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IntCommand {
	
	public int execute(HttpServletRequest request,HttpServletResponse response);

}
