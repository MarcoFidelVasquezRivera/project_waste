package model;

public class Biodegradable extends Waste{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private boolean suitableComposting;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						 METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Biodegradable(String identifier, String name, String origin, String color, int daysDescompositionTime, Product productProduces, boolean suitableComposting){
		
		super(identifier,name,origin,color,daysDescompositionTime,productProduces);
		this.suitableComposting=suitableComposting;

	}//method end


	public getSuitableComposting(){
		return suitableComposting;
	}//method end

}//CLASS END