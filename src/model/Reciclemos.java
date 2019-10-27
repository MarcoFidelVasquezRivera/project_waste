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


	public double calculateHarmfulEffect(String nameWaste){
		boolean flag=false;
		int count=0;
		int countTwo=0;
		double harmfulEffect=0.0;

		while(count<product.size() && !flag){
			waste=product.get(count).getWaste();

			while(countTwo<waste.size() && !flag){

				if(waste.get(countTwo).getName().equalsIgnoreCase(nameWaste)){

					harmfulEffect=((double) waste.get(countTwo).getDaysDecompositionTime())*waste.get(countTwo).getHarmfulFactor();
					flag=true;

				}//conditional end

				countTwo++;
			}//loop end

			count++;
		}//loop end

		return harmfulEffect;
	}//method end


	public String calculateUsableWaste(String nameWaste){
		String message="";
		int count=0;
		int countTwo=0;
		boolean flag=false;

		while(count<product.size() && !flag){
			waste=product.get(count).getWaste();

			while(countTwo<waste.size() && !flag){

				if(waste.get(countTwo).getName().equalsIgnoreCase(nameWaste)){

					message=waste.get(countTwo).getUsableWaste();
					flag=true;

				}

				countTwo++;
			}//loop end

			count++;
		}//loop end

		if(flag=false){
			message="this waste does not exist";
		}//conditional end

		return message;
	}//method end


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


	public String productWasteHarmfulList(String productName){
		boolean flag=false;
		int count=0;
		String message="";
		Waste helper;

		while(count<product.size() &&!flag){

			if(product.get(count).getName().equalsIgnoreCase(productName)){
				waste=product.get(count).getWaste();

				for(int i=0;i<waste.size();i++){

					for(int j=0;j<waste.size();i++){

						if(calculateHarmfulEffect(waste.get(j).getName())>calculateHarmfulEffect(waste.get(j+1).getName())){

							helper=waste.get(j+1);
							waste.set((j+1),waste.get(j));
							waste.set(j,helper);

						}//conditional end

					}//loop end

				}//loop end

			}//conditional end

			count++;
		}//loop end
		
		for(int i=0;i<waste.size();i++){
			message=message+"\n"+waste.get(i).toString();
		}//loop end

		return message;
	}//method end


}//CLASS END