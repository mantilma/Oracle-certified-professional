package ocp.chapter1.enums;

public enum Season {
	WINTER("Low") {public void printHours() {
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
	
	private String state;
	
	Season(String state) {
		this.state = state;
	}

	public void getState() {
		System.out.println(state);
	}

	public void printHours() {
		System.out.println("default hours");
	}
	
	public abstract void printItalianSeason();
}
