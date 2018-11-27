import java.util.Scanner;
import java.text.DecimalFormat;
//Cheap Mart 
//Java 3148 Final Project
public class MainDriver {
	
	// setting up a global variable for cart array
       
        
	public static void main(String[] args) {
		//Generic greetings and then directs the user to the main menu/DIRectory
		System.out.println("Hello and welcome to Cheap Mart!");
                dir();
		
	}
	//method of menu/DIRectory 
	//directs all of the users decisions
	public static void dir() {
			Scanner scan = new Scanner(System.in);
			
			//stores the users choice for category
			int choice = 1;

                        //error checking variable for switch input
			boolean correctChoice = false;
			
			//Displays all of the categories that can be explored
			System.out.println("Here are the categories avaliable: ");
			System.out.println("1.) Electronics");
			System.out.println("2.) Clothing");
			System.out.println("3.) Exercise");
			System.out.println("4.) Outdoor");
			System.out.println("5.) Kitchen \n");
                        
                        			
			//Instructions for user on how to navigate program
			System.out.println("Enter the number of the corresponding category you would like to explore: ");
			System.out.println("(or enter 0 to exit)");
			
			choice = scan.nextInt();	
			
			
			//Looks to go infinite when user tries to exit after a purchase or chooses option 0
			//While loop for error handling
			while(correctChoice == false) {
				
				//Switch statement that will show the user products based on category
				switch (choice) {
				
				case 0: Goodbye();
		    correctChoice = true;	
					break;
					
				case 1: System.out.println("Electronics");
                    correctChoice = true;
					Electronics();
					break;
					
				case 2: System.out.println("Clothing");
					//main example for how
					//this will work
                    correctChoice = true;
					Clothing();
					break;
					
				case 3: System.out.println("Exercise");
                    correctChoice = true;
					Exercise();
					break;
					
				case 4: System.out.println("Outdoor");
                    correctChoice = true;
					Outdoor();
					break;
					
				case 5: System.out.println("Kitchen");
                    correctChoice = true;
					Kitchen();
					
					break;
                                
                                        
                default: System.err.println("Invalid choice please try again");
                    correctChoice = false;
					dir();
					//added above function call to make sure that it loops back to start of function
				}
			}
	}
	//exit screen
	public static void Goodbye(){
		System.out.println("Thank you for shopping with us!\nGoodbye!");
		return;
	}
	//Display objects and thier names
	//Instantiates all of the Clothing-Product objects
	public static void Clothing() {
		
		//Instantiate each new product so it is available to be called
		Product p1 = new Product("Men's Lightweight Cotton Logo Pajama Pants",
			"A modern take on loungewear,these jogger pants from Polo Ralph Lauren combine comfortable cotton \n" +
			"jersey with a relaxed fit and an allover signature pony print.\n ", "Large", 24.99, 3," Ralph Lauren","Clothing");
		Product p2 = new Product("Men's Cool Ultra-Soft Light Weight Crew-Neck T-Shirt",
			"Keep cool and dry with our crew neck tee shirt, can be worn alone or as a layering piece" +
			" adding depth to your wardrobe.\n Reach for this crew-neck T-shirt from 32 Degrees for an easygoing off-duty look. \n", "Medium", 
			10.99, 3,"32 degrees","Clothing");
		Product p3 = new Product("Comfort Stretch Pajama Pants" , "Comfort is key at bedtime. Reach for these pants from " +
			"32 Degrees when you're ready to wind down. \n", "Small", 17.99, 3,"32 degrees","Clothing");
		Product p4 = new Product("Men's pajama shorts" , " A comfortable way to end the day, these pajama shorts from Bar III are" +
			"a stylish casual look. A drawstring waist lets you adjust the fit.\n", "Small/Medium/Large", 17.99, 3,
			"Bar III  ","Clothing");
		Product p5 = new Product("Men's Colorblocked Henley Pajama Shirt, Created for Macy's" , 
			"Colorblocking updates the classic Henley in this Bar III pajama top, a stylish go-to for your laid-back look.\n", "Small/Medium/Large",
			11.99, 3," Bar III  ","Clothing");
		
		//Calls OptionMenu and passes each newly instantiated object so that users can see more details
		OptionsMenu(p1, p2, p3, p4, p5);
		
		
	}
	
	
	//Function that will display a menu of items from the chosen department
	//Takes 5 product objects as constructors 
	public static void OptionsMenu(Product p1, Product p2, Product p3, Product p4, Product p5){
		Scanner scan = new Scanner(System.in);
		int choice;
		//Displays each product's name to the user
		System.out.println("Here are the names of the available products in this department: \n");
		System.out.println("1.)\t"+p1.getName()+"\n");
		System.out.println("2.)\t"+p2.getName()+"\n");
		System.out.println("3.)\t"+p3.getName()+"\n");
		System.out.println("4.)\t"+p4.getName()+"\n");
		System.out.println("5.)\t"+p5.getName()+"\n");
		//Instructs the user on how to view the details of a particular product
		System.out.println("Enter the number of the corresponding product you would like to see: ");
		System.out.println("(or enter 0 to go back to the main menu)");
		
		choice = scan.nextInt();
			
			//Switch statement that will show the user the details of a chosen product and purchase 
			switch (choice) {
				
				case 0: dir();
					break;
				case 1: 
					Purchase(p1);
					break;
				case 2: 
					Purchase(p2);
					break;
				case 3: 
					Purchase(p3);
					break;
				case 4: 
					Purchase(p4);
					break;
				case 5: 
					Purchase(p5);
					break;
								
			}
		
	}
	//Method for purchasing, converts p1 to a generic object name and then handles it individually
	public static void Purchase(Product p1) {
		p1 = p1;
		int quantity;
		Scanner scan = new Scanner(System.in);
                
                boolean correctAnswer = false; //while loop control variable
                
                int buyProduct;
                
		//Displays the finer details of the product
		System.out.println("Product Name : " + p1.getName() + "\n");
                System.out.println("Desciption : " + p1.getDescription() + "\n");
                System.out.println("Size : " + p1.getSize() + "\n");
                System.out.println("Price : $" + p1.getPrice() + "\n");
                System.out.println("Quantity : " + p1.getQuantity() + "\n");
                System.out.println("Seller : " + p1.getSellerName());
                System.out.println("Category : " + p1.getCategory());
                
                while(correctAnswer != true){
                    System.out.print("Do you want to buy this product? (Enter 1 to continue or enter 2 to go back to main menu) : ");
                    buyProduct = scan.nextInt();
                    
                    if(buyProduct == 1){
                         System.out.print("Enter the number of quantity you need : " );
        
                         quantity = scan.nextInt();
        
                          p1.setQuantity(quantity);
        
                           System.out.println("\n\nName of product  : " + p1.getName());
                           // System.out.println("Shipping Address : " + c1.getShippingAdress());
                            System.out.println("=============================================");
                            System.out.println("Quantity : " + p1.getQuantity());
                            System.out.println("Price : " + p1.getPrice());
                            System.out.println("Shipping Cost : $3");
                            System.out.println("Tax : 10%");
                            System.err.println("---------------------------------------------");

                            
                          double creditcard;
                          System.out.println("Enter your Debit card number : ");
                          
                          creditcard = scan.nextDouble();
                          
                          int ccExpiration; //Credit card expiration
                          System.out.println("Enter the expiration (MMYY) : ");
                          
                          ccExpiration = scan.nextInt();
                          
                          System.out.println("Enter CVV code on the back of the card : ");
                          int cvv = scan.nextInt(); 
                          
                          String shippingAddress;
                          
                          System.out.println("Enter your delivery Address");
                          scan.nextLine();
                          shippingAddress = scan.nextLine();
                          
                          Cart c1 = new Cart(p1.getName(),shippingAddress, p1.getQuantity(), p1.getPrice(), creditcard , ccExpiration, cvv);
                          
                            // Round the output to two decimal places
                          DecimalFormat fmt = new DecimalFormat("0.##");
                            System.out.println("---------------------------------------------");
                            System.out.println("Final amount due : $" + fmt.format(c1.finalPrice()));
                            System.out.println("Credit Card number : " + c1.getCreditCard());
                            System.out.println("Expiration MMYY : " + c1.getExpiration());
                            System.out.println("CVV : " + c1.getCVV());
                            System.out.println("Delivery Address : " + shippingAddress);
                            System.out.println("---------------------------------------------");
                          
                            //Calls continue method to ask the user if they would like to continue shopping after a purchase
                                    Continue();
                          
                          correctAnswer = true;
                    } 
                    else if(buyProduct == 2){
                        //Return to main menu
                        dir();
                        correctAnswer = true;
                    }
                    else{
                        System.out.println("Something went wrong please try again.\n");
                        correctAnswer = false;
                    }
                }
               
	}
	
	//Method for asking the user if they would like to continue shopping after a purchase
	public static void Continue() {
		Scanner scan = new Scanner(System.in);
		int choice;
		
		System.out.println("Would you like to continue shopping?\n(Enter 1 to continue or enter 2 to exit)");
		
		choice = scan.nextInt();
		//basic error handling method for integers
		if(choice == 1) {
			
			dir();
		} else if(choice == 2) {
			
			Goodbye();
		} else {
			System.out.println("I didn't quite get that");
			Continue();
			}
		}		

        //Display objects and thier names
	//Instantiates all of the Clothing-Product objects
	public static void Electronics() {
		
		//Instantiate each new product so it is available to be called
		Product p1 = new Product("LG 55UK6300PUE 65-Inch 4K Ultra HD Smart LED TV (2018 Model)",
			"Dimensions (Wx H x D): TV without stand 49.1\" x 28.7\" x 3.5\", TV with stand: 49.1\" x 30.9\" x 9.1\" \n" +
			"Inputs: 3 HDMI, 2 USB, 1 RF, 1 Composite in shared with component, 1 Ethernet, 1 Optical and Audio Return Channel Support via HDMI.\n ", "65 Inches", 846.99, 1,"LG ","Electronics");
		Product p2 = new Product("Samsung Galaxy S9+ Unlocked",
			"Super Speed Dual Pixel Camera with Rear Dual Camera\n" +
                        "Infinity Display: edge-to-edge immersive screen, enhancing your entertainment experience" +
			" Internal Memory 64 GB. Expandable Storage up to 400GB \n", "Midnight Black", 
			819.12, 1,"Samsung","Electronics");
		Product p3 = new Product("Acer Predator Helios 300 Gaming Laptop" , "15.6\" Full HD IPS, Intel i7-7700HQ CPU, 16GB DDR4 RAM, 256GB SSD, GeForce GTX 1060-6GB, VR Ready, Red Backlit KB, Metal Chassis, Windows 10 64-bit, G3-571-77QK" +
			"Up to 7-hours of battery life \n", "15.6", 1049.00, 1,"Acer","Electronics");
		Product p4 = new Product("Canon EOS Rebel T6 Digital SLR Camera with 18-55mm EF-S f/3.5-5.6 IS II Lens" , " 58mm Wide Angle Lens + 2x Telephoto Lens + Flash + 48GB SD Memory Card + UV Filter Kit + Tripod + Full Accessory Bundle" +
			"Transcend 32GB SDHC Class 10 Flash Memory Card\n", "16/32/48GB", 298.99, 1,
			"Canon","Electronic");
		Product p5 = new Product("HP LaserJet Pro M402n Monochrome Printer, Amazon Dash Replenishment ready (C5F93A)" , 
			"This printer is Ethernet (wired networking) or USB only.\n", "Regular",
			209.9 , 1," HP  ","Electronic");
		
		//Calls OptionMenu and passes each newly instantiated object so that users can see more details
		OptionsMenu(p1, p2, p3, p4, p5);
		
		
	}
        
        public static void Exercise(){
            //Instantiate each new product so it is available to be called
		Product p1 = new Product("BalanceFrom GoYoga All Purpose High Density Non-Slip Exercise Yoga Mat with Carrying Strap",
			"With double sided non-slip surfaces, BalanceFrom All-Purpose Premium\n" +
                        "exercise yoga mat comes with an excellent slip resistant advantage to prevent injuries. Exceptional resilience allow you to keep your balance during any exercise style. moisture\n" +
"resistant technology makes the mat to be easily washed with soap and water. Easy strapping and light weight feature are added to this mat for easy transport and storage", "Regular", 14.97, 1,"Balance from","Exercise");
		Product p2 = new Product("NFL Supergrip wilson football",
			"Football is a game of will. Take hold of the game with the NFL Supergrip.\n"
                                +" Made with a high-performance composite material, this football offers the ideal blend of durability,\n"+
                                " grip and performance worthy of the official NFL logo and the game's best players; whatever league they play in.\n","Regular",  19.99, 1,"NFL","Exercise");
		Product p3 = new Product("Nike Gyakusou" , "The Nike Gyakusou Men's Shorts features a 2-in-1 design with a woven outer short and a compression layer underneath for supportive comfort.","Regular", 110, 3,"Nike","Exercise");
		Product p4 = new Product("Fitness Tracker HR" , "  Fashion design and comfortable material, all these assure that you can wear it comfortably at any time and any where. No matter you are walking, running or climbing.Its really the best partner for sports enthusiast.\n","With Belt" ,19.99, 1, " Diggro ","Exercise");
		Product p5 = new Product("Saucony Grid Cohesion 10 Road Running Shoe (Men's)" , 
			" This flexible, athletic shoe for men offers stable cushioning with its Heel Grid system. An injection-molded EVA midsole delivers underfoot cushioning, and a mesh upper provides breathability.", "Running",
			40.95, 3," Saucony","Exercise");
		
		//Calls OptionMenu and passes each newly instantiated object so that users can see more details
		OptionsMenu(p1, p2, p3, p4, p5);
		
        }
        public static void Outdoor(){
                       //Instantiate each new product so it is available to be called
            Product p1 = new Product("TIKI 4-Pack 57-in Bamboo Garden Torch","Natural flame outdoor torches help set the mood and add fun, decor and ambiance to your backyard or patio. Easy-to-use bamboo torches bring a touch of relaxed style and flare to any outdoor patio space.", "Regular",12.99 , 1,"TIKI","Outdoor");
            Product p2 = new Product("Colorescience Sunforgettable Total Protection Brush-On Shield SPF 50 - Tan","Protect your skin from sun and pollution with Colorescience Sunforgettable Total Protection Brush-On Shield SPF 50", "100% mineral sunscreen brush",60.00 , 1,"ColorScience","Outdoor");
            Product p3 = new Product("Trademark Tools 7-in-1 Plant Care Garden Tool Set","Make your green thumb grow with this 7-in-1 plant care", "garden tool set",12.99 , 1,"TM","Outdoor");
            Product p4 = new Product("Master craft boat cover","Cover your MasterCraft X-15 or MariStar 215 with Zero Flex Flyer Wakeboard Tower with this premium factory\n" +
            "cover with this MasterCraft boat cover. This MasterCraft boat cover uses a ratchet strap system to gently hug just below the rubrail of your boat ensuring a perfect fit that is safe for storage on or off the trailer ", "Off trailer",1294.99 , 1,"Mastercraft","Outdoor");
            Product p5 = new Product("Expert Grill Heavy Duty 24-Inch Charcoal Grill","The Expert Grill Heavy Duty 24-Inch Charcoal Grill was designed for those passionate about grilling. With a 372 square inch cooking surface, it has enough space to grill 20 burgers at the same time. This heavy-duty charcoal grill is also jam packed with extra features like the adjustable charcoal pan, plus a foldable side shelf for handling plates, dishes and condiments.", "372 sq inches",80.99 , 1,"The Expert Grill","Outdoor");
            //Calls OptionMenu and passes each newly instantiated object so that users can see more details
		OptionsMenu(p1, p2, p3, p4, p5);
		
        }
        public static void Kitchen(){
                       //Instantiate each new product so it is available to be called
            Product p1 = new Product("Cuisinart 635-24 Chef's Classic Nonstick Hard-Anodized 3-Quart Chef's Pan with Cover",
                    "Hard Anodized Exterior-Dense and Highly Wear Resistant\n" +
                    "Quantanium Nonstick Cooking Surface for Professional Results\n" +
                    "Riveted Stainless handles\n" +
                    "Tempered Class Lids", "Cookware set",22.99 , 1,"Cuisinart","Kitchen ");
            Product p2 = new Product("AmazonBasics 6-Piece Nonstick Bakeware Set",
                    "6-piece bakeware set includes a 9x5-inch loaf pan, 2 round 9-inch cake pans, a 12-cup muffin pan, a 13x9-inch roast pan, and a 13x9-inch baking sheet\n" +
                    "Made of heavy-weight carbon steel for thorough, even heating\n" +
                    "Nonstick coating for effortless food release and easy cleaning\n" +
                    "Oven-safe to 500 degrees F\n" +
                    "Hand-wash only recommended", "Bakeware set",15.99 , 1,"AmazonBasics","Kitchen ");
            Product p3 = new Product("Aroma Housewares 8-Cup (Cooked) (4-Cup UNCOOKED) Digital Rice Cooker and Food Steamer (ARC-914D)",
                    "Perfectly prepares 2 to 8 cups of any variety of cooked rice\n" +
                    "Steams meat and vegetables while rice cooks below\n" +
                    "Easy-to-use, programmable digital controls with automatic Keep-Warm and White Rice and Brown Rice functions", "white",25.99 , 1,"Aroma Housewares","Kitchen ");
            Product p4 = new Product("LG LMV2031ST Stainless Steel Over-the-Range Microwave",
                    "1,000 Cooking Watts\n" +
                    "400 CFM Venting System\n" +
                    "Sensor Cooking\n" +
                    "EasyClean\n" +
                    "Energy Savings Key", "2.0 Cu. Ft.",259.99 , 1,"LG","Kitchen ");
            Product p5 = new Product("Hamilton Beach Classic Chrome 4 Slice Toaster (24790)",
                    "Lifts slices higher with toast boost\n" +
                    "Cool touch exterior\n" +
                    "Auto shutoff\n" +
                    "Extra-wide slots\n" +
                    "Toast boost", "4 Slice",33.99 , 1,"Hamilton Beach","Kitchen ");
            
            //Calls OptionMenu and passes each newly instantiated object so that users can see more details
		OptionsMenu(p1, p2, p3, p4, p5);
	
        }
        