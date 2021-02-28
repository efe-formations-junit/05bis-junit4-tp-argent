package fr.formation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.formation.exception.UniteDistincteException;

public class SommeArgentTest {

	private SommeArgent m12CHF;
	private SommeArgent m14CHF;

	private static int nbPasseDansInit = 0;
	private static int nbPasseDansAfter = 0;

	@Before
	public void mesInitialisations() {
		m12CHF = new SommeArgent(12, "CHF");
		m14CHF = new SommeArgent(14, "CHF");
		System.out.println(++nbPasseDansInit + "ime passage avant exécution d'une méthode de test");
	}

	@After
	public void apresExecMethTest() {
		System.out.println(++nbPasseDansAfter + "ime passage APRES exécution d'une méthode de test");
	}

	@Test
	public void testAdd() throws UniteDistincteException {
		SommeArgent expected = new SommeArgent(26, "CHF");
		Assert.assertTrue(expected.equals(m12CHF.add(m14CHF)));
	}

	@Test
	public void testEquals() {
		SommeArgent m14USD = new SommeArgent(14, "USD");

		Assert.assertTrue(!m12CHF.equals(null));

		Assert.assertEquals(m12CHF, m12CHF);
		Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF"));
		Assert.assertTrue(!m12CHF.equals(m14CHF));
		Assert.assertTrue(!m14USD.equals(m14CHF));
	}

	@Test(expected = UniteDistincteException.class)
	public void leveExceptionPourAddition() throws UniteDistincteException {
		SommeArgent autreSomme = new SommeArgent(12, "USD");
		m12CHF.add(autreSomme);

	}
}
