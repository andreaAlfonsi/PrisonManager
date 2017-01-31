package model.Implementations;

import java.util.Date;
import java.util.List;

import model.Interfaces.Supervisor;

public class SupervisorImpl extends GuardImpl implements Supervisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4240266686877622741L;

	public SupervisorImpl(String name, String surname, Date birthDate, int rank, String telephoneNumber,
			int idGuardia, String password) {
		super(name, surname, birthDate, rank, telephoneNumber, idGuardia, password);
		
	}

	@Override
	public void stampaListVisitatori(List<VisitorImpl> v1) {

		System.out.println(v1.toString());
	}

}
