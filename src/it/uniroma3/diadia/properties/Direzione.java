package it.uniroma3.diadia.properties;

public enum Direzione {
	VUOTA(){
		@Override
		public String getString() {return "vuota";}
		@Override
		public Direzione opposta() {return VUOTA;}
	},
	NORD(){
		@Override
		public String getString() {return "nord";}
		@Override
		public Direzione opposta() {return SUD;}
	},
	EST(){
		@Override
		public String getString() {return "est";}
		@Override
		public Direzione opposta() {return OVEST;}
	},
	SUD(){
		@Override
		public String getString() {return "sud";}
		@Override
		public Direzione opposta() {return NORD;}
	},
	OVEST(){
		@Override
		public String getString() {return "ovest";}
		@Override
		public Direzione opposta() {return EST;}
	};

	
	public abstract String getString();
	public abstract Direzione opposta();
	
	public Direzione getDirezioneDaStringa(String dir) {
		if(dir.equals("nord")) {return Direzione.NORD;}
		else if(dir.equals("est")) {return Direzione.EST;}
		else if(dir.equals("sud")) {return Direzione.SUD;}
		else {return Direzione.OVEST;}
	}
}
	
	
