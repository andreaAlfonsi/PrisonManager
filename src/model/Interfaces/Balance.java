package model.Interfaces;

import java.util.List;

import model.Implementations.MovementImpl;

public interface Balance {

	/**
	 * metodo che aggiunge un nuovo movimento allo storico del bilancio 
	 * @param m un nuovo movimento
	 */
	public void add(MovementImpl m);
	
	/**
	 * ritorna lo storico del bilancio
	 * @return lo storico
	 */
	public List<MovementImpl> getPrint();
	
	/**
	 * rimuove un movimento dallo storico
	 * @param i indice del movimento
	 */
	public void remove(int i);

	/**
	 * ritorna il bilancio
	 * @return the balance
	 */
	public double getBilance();
	
	
}
