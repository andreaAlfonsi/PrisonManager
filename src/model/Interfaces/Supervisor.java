package model.Interfaces;

import java.util.List;

import model.Implementations.VisitorImpl;

public interface Supervisor extends Person {

	/**
	 * metodo che stampa la lista dei visitatori
	 * @param v1 list of visitors
	 */
	public void stampaListVisitatori(List<VisitorImpl> v1);
}
