package model.Implementations;

import java.io.Serializable;

public class CellImpl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9167940013424894676L;
	
	private int id;
	private String position;
	private int capacity;
	private int CurrentPrisoners;
	
	public CellImpl(int id, String position, int capacity){
		this.id=id;
		this.position=position;
		this.capacity=capacity;
		this.CurrentPrisoners=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCurrentPrisoners() {
		return CurrentPrisoners;
	}

	public void setCurrentPrisoners(int currentPrisoners) {
		CurrentPrisoners = currentPrisoners;
	}

	@Override
	public String toString() {
		return "CellImpl [id=" + id + ", position=" + position + ", capacity=" + capacity + ", CurrentPrisoners="
				+ CurrentPrisoners + "]";
	}
	
	
}
