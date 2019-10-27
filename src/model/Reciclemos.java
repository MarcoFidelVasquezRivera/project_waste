package model;
import java.util.ArrayList;

public class Reciclemos{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private ArrayList<Product> product;
	private ArrayList<Waste> waste;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						  METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public Reciclemos(){
		product = new ArrayList<Product>(); 
		waste = new ArrayList<Waste>();
	}//method end

/**
*<b>Name:</b> lookWasteName.<br>
*This method looks for a waste by name.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  wasteName the name of the waste. <br>
*@return message return a message with the information of the waste or with a message saying that the wast does not exist<br>
*/
	public String lookWasteName(String wasteName){
		boolean flag=false;
		int count=0;
		int countTwo=0;
		String message="";

		while(count<product.size() && !flag){
			waste=product.get(count).getWaste();

			while(countTwo<waste.size() && !flag){

				if(waste.get(countTwo).getName().equalsIgnoreCase(wasteName)){

					message= informationWaste(countTwo);
					flag=true;

				}//conditional end

				countTwo++;
			}//loop end
			if(flag==false){
				message="Waste does not exist";
			}//conditional end

			count++;
		}//loop end

		return message;
	}//method end

/**
*<b>Name:</b> informationWaste.<br>
*this method looks the waste in the array of waste and return his information .<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  number the number of the space in the array where is the waste. <br>
*@return message information of the waste<br>
*/
	public String informationWaste(int number){
		String message="";

		if(waste.get(number) instanceof Biodegradable){
			Biodegradable wasteType = (Biodegradable)waste.get(number);
			message= wasteType.toString();

		}
		else if(waste.get(number) instanceof Recyclable){
			Recyclable wasteType = (Recyclable)waste.get(number);
			message= wasteType.toString();

		}
		else if(waste.get(number) instanceof Inert){
			Inert wasteType = (Inert)waste.get(number);
			message= wasteType.toString();

		}//conditional end

		return message;
	}//method end
	
/**
*<b>Name:</b> lookWasteProduct.<br>
*this method looks the information of waste by the identifier of the product that producc them.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  productIdentifier the name of the product<br>
*@return message information of the waste<br>
*/
	public String lookWasteProduct(String productIdentifier){
		boolean flag=false;
		int count=0;
		int countTwo=0;
		String message="";

		while(count<product.size() && !flag){
			if(product.get(count).getIdentifier().equalsIgnoreCase(productIdentifier)){

				waste= product.get(count).getWaste();
				while(countTwo<waste.size()){

					message = message+"\n"+"\n"+informationWaste(countTwo);

					countTwo++;
				}//loop end

				flag=true;
			}//conditional end

			count++;
		}//loop end

		if(flag==false){
			message="product does not exist";
		}//method end

		return message;
	}//method end

/**
*<b>Name:</b> productList.<br>
*this method shows a list of the products entered.<br>
*<b>pre:</b> arraylist product must be initialized.<br>
*@return message message with the information of the products<br>
*/
	public String productList(){
		int count=0;
		String message="";

		System.out.println(String.valueOf(product.size()));

		while(count<product.size()){

			message=message+"\n"+"\n"+product.get(count).toString();

			count++;
		}//loop end

		return message;
	}//method end

/**
*<b>Name:</b> lookWasteProduct.<br>
*this method calculates the harmful effect of the waste by name.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  nameWaste the name of the waste.<br>
*@return message information of the waste.<br>
*/
	public double calculateHarmfulEffect(String nameWaste){
		boolean flag=false;
		double harmfulEffect=0.0;
		

		for(int i=0;i<product.size() && !flag;i++){
			waste=product.get(i).getWaste();

			for(int j=0;j<waste.size() && !flag;j++){

				if(waste.get(j).getName().equalsIgnoreCase(nameWaste)){

					harmfulEffect=((double) waste.get(j).getDaysDecompositionTime())*waste.get(j).getHarmfulFactor();
					flag=true;

				}//conditional end

			}//loop end

		}//loop end


		return harmfulEffect;
	}//method end

/**
*<b>Name:</b> calculateUsableWaste.<br>
*this method calculates if the waste is usable.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  nameWaste the name of the waste.<br>
*@return message message saying if the waste is usable or is not usable.<br>
*/
	public String calculateUsableWaste(String nameWaste){
		String message="";
		boolean flag=false;

		for(int i=0;i<product.size() && !flag;i++){
			waste=product.get(i).getWaste();

			for(int j=0;j<waste.size() && !flag;j++){

				if(waste.get(j).getName().equalsIgnoreCase(nameWaste)){

					message=waste.get(j).getUsableWaste();
					flag=true;

				}//conditional end

			}//loop end

		}//loop end

		if(flag=false){
			message="this waste does not exist";
		}//conditional end

		return message;
	}//method end

/**
*<b>Name:</b> wasteEnteredReport.<br>
*this method shows a report of the waste entered in the program.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@return message message whit the repot of the products.<br>
*/
	public String wasteEnteredReport(){
		String message="";
		

		message=message+"BIODEGRADABLE";

		for(int i=0;i<product.size();i++){
			waste=product.get(i).getWaste();

			for(int j=0;j<waste.size();j++){

				if(waste.get(j) instanceof Biodegradable){					
					message=message+"\n"+waste.get(j).getReport()+product.get(i).getReport();
				}//conditional end

			}//loop end

		}//loop end

		message=message+"\n"+"\nRECYCLABLE";

		for(int i=0;i<product.size();i++){
			waste=product.get(i).getWaste();

			for(int j=0;j<waste.size();j++){

				if(waste.get(j) instanceof Recyclable){					
					message=message+"\n"+waste.get(j).getReport()+product.get(i).getReport();
				}//conditional end

			}//loop end

		}//loop end

		message=message+"\n"+"\nINERT";

		for(int i=0;i<product.size();i++){
			waste=product.get(i).getWaste();

			for(int j=0;j<waste.size();j++){

				if(waste.get(j) instanceof Inert){					
					message=message+"\n"+waste.get(j).getReport()+product.get(i).getReport();
				}//conditional end

			}//loop end

		}//loop end

		return message;
	}//method end

/**
*<b>Name:</b> addWaste.<br>
*this method adds a new waste.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  identifier the name of the waste.<br>
*@param  name the name of the waste.<br>
*@param  origin the origin of the waste.<br>
*@param  color the color of the waste.<br>
*@param  daysDecompositionTime the days of descomposition of the waste.<br>
*@param  suitableComposting boolean if compostable or no.<br>
*@param  productName the name of the product that producess the waste.<br>
*<b>pos: </b>new wast has been created<br> 
*@return message message saying if the product was saved or an error happened.<br>
*/
	public String addWaste(String identifier, String name, String origin, String color, int daysDecompositionTime, boolean suitableComposting, String productName){
		boolean flag=false;
		int count=0;
		int countTwo=0;
		String message="";

		while(count<product.size() && !flag){
			waste=product.get(count).getWaste();

			while(countTwo<waste.size() && !flag){

				if(waste.get(countTwo).getName().equalsIgnoreCase(name)){
					message="waste already exist";
					flag=true;

				}//conditinal end
				countTwo++;
			}//loop end
			count++;
		}//loop end


		count=0;

		while(count<product.size() && flag==false){

			if(product.get(count).getName().equalsIgnoreCase(productName)){
				Waste newWaste = new Biodegradable(identifier,name,origin,color,daysDecompositionTime,suitableComposting);
				product.get(count).addWaste(newWaste);
				message="waste has been saved correctly";
				flag=true;
			}//conditional end
			count++;
		}//loop end
		if(flag==false){
			message="the product where the waste will be saved does not exist";
		}//conditional end

		return message;
	}//method end

/**
*<b>Name:</b> addWaste.<br>
*this method adds a new waste.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  identifier the name of the waste.<br>
*@param  name the name of the waste.<br>
*@param  origin the origin of the waste.<br>
*@param  color the color of the waste.<br>
*@param  daysDecompositionTime the days of descomposition of the waste.<br>
*@param  type the type of recyclable waste.<br>
*@param  descriptionHome description of how to use this in home.<br>
*@param  descriptionIndustry description of how to use this in industry.<br>
*@param  productName the name of the product that producess the waste.<br>
*<b>pos: </b>new wast has been created<br> 
*@return message message saying if the product was saved or an error happened.<br>
*/
	public String addWaste(String identifier, String name, String origin, String color, int daysDecompositionTime, String type, String descriptionHome, String descriptionIndustry, String productName){
		boolean flag=false;
		int count=0;
		int countTwo=0;
		String message="";

		while(count<product.size() && !flag){
			waste=product.get(count).getWaste();

			while(countTwo<waste.size() && !flag){

				if(waste.get(countTwo).getName().equalsIgnoreCase(name)){
					message="waste already exist";
					flag=true;

				}//conditinal end
				countTwo++;
			}//loop end
			count++;
		}//loop end


		count=0;

		while(count<product.size() && flag==false){

			if(product.get(count).getName().equalsIgnoreCase(productName)){
				Waste newWaste = new Recyclable(identifier,name,origin,color,daysDecompositionTime,type,descriptionHome,descriptionIndustry);
				product.get(count).addWaste(newWaste);
				message="waste has been saved correctly";
				flag=true;
			}//conditional end
			count++;
		}//loop end
		if(flag==false){
			message="the product where the waste will be saved does not exist";
		}//conditional end

		return message;

	}//method end

/**
*<b>Name:</b> addWaste.<br>
*this method adds a new waste.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  identifier the name of the waste.<br>
*@param  name the name of the waste.<br>
*@param  origin the origin of the waste.<br>
*@param  color the color of the waste.<br>
*@param  daysDecompositionTime the days of descomposition of the waste.<br>
*@param  tips tips of how to use this.<br>
*@param  productName the name of the product that producess the waste.<br>
*<b>pos: </b>new wast has been created<br> 
*@return message message saying if the product was saved or an error happened.<br>
*/
	public String addWaste(String identifier, String name, String origin, String color, int daysDecompositionTime, String tips, String productName){
		boolean flag=false;
		int count=0;
		int countTwo=0;
		String message="";

		while(count<product.size() && !flag){
			waste=product.get(count).getWaste();

			while(countTwo<waste.size() && !flag){

				if(waste.get(countTwo).getName().equalsIgnoreCase(name)){
					message="waste already exist";
					flag=true;

				}//conditinal end
				countTwo++;
			}//loop end
			count++;
		}//loop end
		if(flag==false){
			message="the product where the waste will be saved does not exist";
		}//conditional end


		count=0;

		while(count<product.size() && flag==false){

			if(product.get(count).getName().equalsIgnoreCase(productName)){
				Waste newWaste = new Inert(identifier,name,origin,color,daysDecompositionTime,tips);
				product.get(count).addWaste(newWaste);
				message="waste has been saved correctly";
				flag=true;
			}//conditional end
			count++;
		}//loop end

		return message;

	}//method end

/**
*<b>Name:</b> addProduct.<br>
*this method adds a new product.<br>
*<b>pre:</b> arraylist product must be initialized.<br>
*@param  identifier the name of the product.<br>
*@param  name the name of the product.<br>
*@param description description of the product<br>
*<b>pos: </b>new product has been created<br> 
*@return message message saying if the product was saved or an error happened.<br>
*/
	public String addProduct(String identifier, String name, String description){
		boolean flag=false;
		int count=0;
		String message="";

		while(count<product.size() && flag==false){

			if(product.get(count).getName().equalsIgnoreCase(name)){
				message="product already exist";
				flag=true;
				
			}//conditional end
			count++;
		}//loop end

		if(flag==false){

			Product newProduct=new Product(identifier,name,description);
			product.add(newProduct);
			message="product has been saved correctly";

		}//conditional end 
		return message;
	}//method end

/**
*<b>Name:</b> productWasteHarmfulList.<br>
*this method organize the wastes from most harmful to less harmful.<br>
*<b>pre:</b> arraylist product and arraylist waste must be initialized.<br>
*@param  productName the name of the product.<br>
*<b>pos: </b>arraylist has been organize<br> 
*@return message message whith the information of the product in order.<br>
*/
	public String productWasteHarmfulList(String productName){
		boolean flag=false;
		String message="";
		Waste helper;


		for(int count=0;count<product.size() && !flag;count++){
			
			if(product.get(count).getName().equalsIgnoreCase(productName)){
				waste=product.get(count).getWaste();				

				for(int i=0;i<waste.size();i++){
					
					for(int j=(waste.size()-1);j>0;j--){
						

						if(calculateHarmfulEffect(waste.get(j).getName())>calculateHarmfulEffect(waste.get(j-1).getName())){
							
							helper=waste.get(j-1);
							waste.set((j-1),waste.get(j));
							waste.set((j),helper);

						}//conditional end

					}//loop end

				}//loop end
				flag=true;
			}//conditional end

		}//loop end
		
		for(int i=0;i<waste.size();i++){
			message=message+"\n"+"\n"+waste.get(i).toString()+"\n"+"its harmful effect is: "+calculateHarmfulEffect(waste.get(i).getName());
		}//loop end

		return message;
	}//method end


}//CLASS END