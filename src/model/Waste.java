package model;

public abstract class Waste{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static final String INDUSTRIAL="industrial";
	public static final String DOMICILIARIO="domiciliario";
	public static final String MUNICIPAL="municipal";
	public static final String CONSTRUCCION="construccion";
	public static final String HOSPITALARIO="hospitalario";
	private String identifier;
	private String name;
	private String origin;
	private String color;
	private int daysDecompositionTime;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						  METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Waste(String identifier, String name, String origin, String color, int daysDecompositionTime){

		this.identifier=identifier;
		this.name=name;
		this.origin=origin;
		this.color=color;
		this.daysDecompositionTime=daysDecompositionTime;

	}//method end


	public String getIdentifier(){
		return identifier;
	}//method end


	public String getName(){
		return name;
	}//method end


	public String getOrigin(){
		return origin;
	}//method end


	public String getColor(){
		return color;
	}//method end


	public int getDaysDecompositionTime(){
		return daysDecompositionTime;
	}//method end


	public String getReport(){
		return "#"+getName()+" - "+getOrigin()+" - "+getColor()+" - "+String.valueOf(getDaysDecompositionTime())+" days to decomposition -";
	}


	public abstract double getHarmfulFactor();

	public abstract String getUsableWaste();

	@Override
	public String toString(){
		return "Name: "+name+"\nIdentifier: "+identifier+"\nOrigin: "+origin+"\nColor: "+color+"\nDays to decomposition"+String.valueOf(daysDecompositionTime);
	}//method end

}//CLASS END