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

	public Recyclable(String identifier, String name, String origin, String color, int daysDecompositionTime, String type, String descriptionHome, String descriptionIndustry){
		
		super(identifier,name,origin,color,daysDecompositionTime);
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


	public double getHarmfulFactor(){
		double harmfulFactor=0;

		if(getOrigin().equalsIgnoreCase("industrial")){
			
			harmfulFactor=0.1;
		}
		else if(getOrigin().equalsIgnoreCase("dimiciliario")){
			
			harmfulFactor=0.05;
		}
		else if(getOrigin().equalsIgnoreCase("municipal")){
			
			harmfulFactor=0.12;
		}
		else if(getOrigin().equalsIgnoreCase("construccion")){
			
			harmfulFactor=0.08;
		}
		else if(getOrigin().equalsIgnoreCase("hospitalario")){

			harmfulFactor=0.15;
		}//condiotional end

		harmfulFactor=harmfulFactor-0.02;

		return harmfulFactor;
	}//method end


	public String getUsableWaste(){
		String message="";

		if(descriptionIndustry!=null && descriptionHome!=null){

			message="this waste is usable";
		}
		else{
			message="this waste is not usable";
		}

		return message;
	}//method end


	@Override
	public String toString(){
		return super.toString()+"\nType: "+type+"\nDescription home: "+descriptionHome+"\nDescription industry: "+descriptionIndustry;
	}//method end

}//CLASS END