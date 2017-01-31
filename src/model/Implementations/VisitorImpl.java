package model.Implementations;

import java.util.Date;

import model.Interfaces.Visitor;

public class VisitorImpl extends PersonImpl implements Visitor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5306827736761721189L;

	public int id_prisoner;
	
	public VisitorImpl(String name, String surname, Date birthDate, int id_prisoner) {
		super(name, surname, birthDate);
		this.id_prisoner=id_prisoner;
	}

	@Override
	public int getIdPrisoner() {
		return this.id_prisoner;
	}

	@Override
	public String toString() {
		return "VisitorImpl getName()=" + getName() + ", getSurname()="+ getSurname() + ", getBirthDate()=" + getBirthDate() + "[getIdPrisoner()=" + getIdPrisoner() + "]";
	}
	

}
