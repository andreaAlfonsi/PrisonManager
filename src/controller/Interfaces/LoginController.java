package controller.Interfaces;

import java.io.IOException;
import java.util.List;

import model.Interfaces.Guard;

public interface LoginController {

	
	/**
	 * 
	 * @return list of all guards
	 * @throws IOException error in input
	 * @throws ClassNotFoundException class not found
	 */
	public List<Guard> getGuards() throws IOException, ClassNotFoundException;
}
