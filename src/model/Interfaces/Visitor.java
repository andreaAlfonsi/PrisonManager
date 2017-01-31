package model.Interfaces;

public interface Visitor extends Person{

	/**
	 * metodo che ritorna l'id del prigioniero che il visitatore � andato a trovare
	 * @return id of the prisoner visited
	 */
	public int getIdPrisoner();
}
