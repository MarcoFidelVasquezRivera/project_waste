package model;

public class Recyclable extends Waste{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static final String PAPER="papel";
	public static final String PAPERBOARD="carton";
	public static final String GLASS="vidrio";
	public static final String METAL="metal";
	private String type;
	private String descriptionHome;
	private String descriptionIndustry;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						 METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Recyclable(String identifier, String name, String origin, String color, int daysDescompositionTime, Product productProduces, String type, String descriptionHome, String descriptionIndustry){
		
		super(identifier,name,origin,color,daysDescompositionTime,productProduces);
		this.type=type;
		this.descriptionHome=descriptionHome;
		this.descriptionIndustry=descriptionIndustry;

	}//method end


	public String getType(){
		return type;
	}//method end


	public String getDescriptionHome(){
		return descriptionHome;
	}//method end



	public String getDescriptionIndustry(){
		return descriptionIndustry;
	}//method end

}//CLASS END