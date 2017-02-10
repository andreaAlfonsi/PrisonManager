package model.Interfaces;

import java.util.Date;
import java.util.List;

public interface Prisoner extends Person{

	/**
	 * Metodo che aggiunge un crimine alla lista dei crimini
	 * @return
	*/
	public void addCrime(String crimine);

	/**
	 * Metodo che ritrna la lista dei crimini commessi da un criminale
	 * @return la lista dei crimini
	*/
	public List<String> getCrimini();
	
	/**
	 * Metodo che ritorna l'id del prigioniero
	 * @return id del prigioniero
	*/
	public int getIdPrigioniero();

	/**
	 * Metodo che setta l'id del prigioniero
	 * @return
	*/
	public void setIdPrigioniero(int idPrigioniero);

	/**
	 * Metodo che ritorna la data di inizio della reclusione
	 * @return data di inizio della reclusione
	*/
	public Date getInizio();

	/**
	 * Metodo che setta la data di inizio della reclusione
	 * @return
	*/
	public void setInizio(Date inizio);

	/**
	 * Metodo che ritorna la data di fine della reclusione
	 * @return data di fine della reclusione
	*/
	public Date getFine();

	/**
	 * Metodo che setta la data di fine della reclusione
	 * @return
	*/
	public void setFine(Date fine);
	
	public int getCellID();
	
}