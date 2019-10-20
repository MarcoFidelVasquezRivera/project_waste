package model;

public class Inert extends Waste{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private String tips;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						 METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public Inert(String identifier, String name, String origin, String color, int daysDescompositionTime, Product productProduces, String tips){
		
		super(identifier,name,origin,color,daysDescompositionTime,productProduces);
		this.tips=tips;

	}//method end

	public String getTips(){
		return tips;
	}//method end

}//CLASS END