package entities;

import java.util.ArrayList;
import java.util.List;

import abstracts.Entity;

public class Customer extends Entity {

	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private int dateOfBirth;
	private List<Game> gameLibrary;
	private float walletBalance;

	public Customer(int id, String firstName, String lastName, String nationalIdentity, int dateOfBirth) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.dateOfBirth = dateOfBirth;
		this.walletBalance = 0;
		this.gameLibrary = new ArrayList<Game>();
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public float getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(float walletBalance) {
		this.walletBalance = walletBalance;
	}
	
	public void addGameToLibrary(Game game) {
		gameLibrary.add(game);
	}
	
	public List<Game> getGameLibrary(){
		return gameLibrary;
	}

}
