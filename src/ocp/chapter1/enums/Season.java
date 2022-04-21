package ocp.chapter1.enums;

public enum Season {
	WINTER("Low") {
		
		@Override
		public void printHours() {
			System.out.println("9am-3pm");
		}

	@Override
	public void printItalianSeason() {
		System.out.println("INVERNO");
		
	}},
	SPRING("Medium") {
		@Override
		public void printItalianSeason() {
			System.out.println("PRIMAVERA");
		}
	},
	SUMMER("High") {
		@Override
		public void printItalianSeason() {
			System.out.println("ESTATE");
		}
	},
	FALL("Medium") {
		@Override
		public void printItalianSeason() {
			System.out.println("AUTUNNO");
		}
	};
	
	//se ho associato agli enum degli state devo per forza inserire una proprietà ed un costruttore. Il costruttore verrà invocato automaticamente 
	//a run time da java solo la prima volta che utilizzo l enum
	private String state; //la proprietà può avere qualsiasi tipo di access modifiers
	
	Season(String state) { //occhio il costruttore deve essere solo private. Private by default se non metto nulla
		this.state = state;
	}

	//metodo che restituisce lo stato visto che ho messo l access modifier privato
	public void getState() {
		System.out.println(state);
	}

	public void printHours() {
		System.out.println("default hours");
	}
	
	public abstract void printItalianSeason();
}
