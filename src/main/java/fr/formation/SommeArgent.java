package fr.formation;

import fr.formation.exception.UniteDistincteException;

public class SommeArgent {
	private int quantite;

	private String unite;

	public SommeArgent(int amount, String currency) {
		quantite = amount;
		unite = currency;
	}

	public int getQuantite() {
		return quantite;
	}

	public String getUnite() {
		return unite;
	}

	public SommeArgent add(SommeArgent m) throws UniteDistincteException {
		if (!m.getUnite().equals(this.getUnite())) {
			throw new UniteDistincteException(this, m);
		}
		return new SommeArgent(getQuantite() + m.getQuantite(), getUnite());
	}

	public boolean equals(Object anObject) {

		if (anObject == null)
			return false;
		if (anObject instanceof SommeArgent) {

			SommeArgent aMoney = (SommeArgent) anObject;

			return aMoney.getUnite().equals(getUnite()) && getQuantite() == aMoney.getQuantite();
		}
		return false;

	}

	@Override
	public String toString() {
		return "SommeArgent [quantite=" + quantite + ", unite=" + unite + "]";
	}
	
	
	
}
