package fr.formation;

import java.util.HashMap;
import java.util.Set;

public class PorteMonnaie {
	private HashMap<String, Integer> contenu;

	public HashMap<String, Integer> getContenu() {
		return contenu;
	}

	public PorteMonnaie() {
		contenu = new HashMap<String, Integer>();
	}

	public void ajouteSomme(SommeArgent sa) {
		String laMonnaieDeSa = sa.getUnite();
		Integer quantiteDansLaMonnaie = contenu.get(laMonnaieDeSa);
		if (quantiteDansLaMonnaie == null) {
			contenu.put(laMonnaieDeSa, sa.getQuantite());
		} else {
			Integer somme = quantiteDansLaMonnaie + sa.getQuantite();
			contenu.put(laMonnaieDeSa, somme);
		}
	}

	public String toString() {

		Set<String> lesCles = contenu.keySet();
		StringBuffer aAfficher = new StringBuffer("Contenu du porte monnaie :\n");

		for (String uneCle : lesCles) {
			aAfficher.append(contenu.get(uneCle) + " " + uneCle);
		}
		return aAfficher.toString();

	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PorteMonnaie other = (PorteMonnaie) obj;
		if (contenu == null) {
			if (other.contenu != null)
				return false;
		} else if (!contenu.equals(other.contenu))
			return false;
		return true;
	}
	
	
/*
	public boolean equals(Object anObject) {
		if (!(anObject instanceof PorteMonnaie))
			return false;
		else {
			Set<String> lesCles = contenu.keySet();
			Set<String> lesClesDeAnObject = ((PorteMonnaie) anObject).getContenu().keySet();
			if (!lesCles.equals(lesClesDeAnObject))
				return false;
			PorteMonnaie pm = (PorteMonnaie) anObject;
			for (String uneCle : lesCles) {
				if (contenu.get(uneCle).intValue() != pm.getContenu().get(uneCle).intValue())
					return false;
			}
		}
		return true;

	}
*/
}
