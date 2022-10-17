package ocp.chapter3.generic.genericClass;

/* La limitazione dei generics è che io posso utilizzare soltanto metodo di object. Ma se io scrivo <T extends Animal> 
 * gli sto dicendo voglio un generic che sia o Animal o una sua sottoclasse non qualsiasi cosa. Cosi facendo io posso utilizzare
 * tutti i metodi di Animal
 * 
 */
public class Cassa2 <T extends Animal> { 
		private T contenuto;

		public T getContenuto() {
			return contenuto;
		}

		public void setContenuto(T contenuto) {
			this.contenuto = contenuto;
		}
		
		public void testMetodiADisposizione() {
			this.contenuto.getName(); //ho a disposizione getName di Animal interface!
			//this.contenuto.getVersoGatto(); //ma non ho a dispozione getVersoGatto che è specifico di gatto!
		}

}
