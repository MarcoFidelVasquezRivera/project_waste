package model;

public abstract class Waste{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static final String INDUSTRIAL="industrial"
	public static final String DOMICILIARIO="domiciliario"
	public static final String MUNICIPAL="municipal"
	public static final String CONSTRUCCION="construccion"
	public static final String HOSPITALARIO="hospitalario"
	private String identifier;
	private String name;
	private String origin;
	private String color;
	private int daysDescompositionTime;
	private Product productProduces;


	public Waste(String identifier, String name, String origin, String color, int daysDescompositionTime, Product productProduces){

		this.identifier=identifier;
		this.name=name;
		this.origin=origin;
		this.color=color;
		this.daysDescompositionTime=daysDescompositionTime;
		this.productProduces=productProduces;

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


	public int getDaysDescompositionTime(){
		return daysDescompositionTime;
	}//method end


	public Product getProductProduces(){
		return productProduces;
	}//method end


	public void setProductProces(Product productProduces){
		this.productProduces=productProduces;
	}//method end

}//CLASS END