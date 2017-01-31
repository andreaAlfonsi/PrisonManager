package model.Interfaces;

public interface Visitor extends Person{

	/**
	 * metodo che ritorna l'id del prigioniero che il visitatore è andato a trovare
	 * @return id of the prisoner visited
	 */
	public int getIdPrisoner();
}
