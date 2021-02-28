package fr.formation.exception;

import fr.formation.SommeArgent;

public class UniteDistincteException extends Exception {
	private static final long serialVersionUID = 1L;

	private SommeArgent somme1, somme2;

	public UniteDistincteException(SommeArgent sa1, SommeArgent sa2) {
		somme1 = sa1;
		somme2 = sa2;
	}

	public String toString() {
		return "unité distincte : " + somme1.getUnite() + " != " + somme2.getUnite();

	}
}