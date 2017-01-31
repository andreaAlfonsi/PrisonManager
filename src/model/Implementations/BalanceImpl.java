package model.Implementations;

import java.util.ArrayList;
import java.util.List;

import model.Interfaces.Balance;

public class BalanceImpl implements Balance {

	private double balance;
	
	private List <MovementImpl> storico = new ArrayList<>();
	
	public BalanceImpl() {
		this.balance=0;
	}
	public BalanceImpl(int b){
		this.balance=b;
	}

	@Override
	public void add(MovementImpl m){
		getPrint().add(m);
		switch(m.getChar()){
		case '-' :
			this.balance-=m.getAmount();
			break;
		case '+' :
			this.balance+=m.getAmount();
			break;
		}
	}

	@Override
	public List<MovementImpl> getPrint() {
		return this.storico;
	}

	@Override
	public void remove(int i){
		getPrint().remove(i);
	}
	
	@Override
	public double getBilance(){
		return this.balance;
	}

}
