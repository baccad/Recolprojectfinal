import pymysql

all_items = []

#This function displays everything in the table using the loop.
def countrow():
    
    conn = pymysql.connect(host='localhost',user='root',password='P@$$w0rd',db='test')

    a = conn.cursor()

    sql = 'SELECT * FROM `product`;'

    a.execute(sql)

    countrow = a.execute(sql)
    print("Number of rows:",countrow)
    data = a.fetchall()
    for d in data:
        print(d,'\n','--------------------------------------------------')

def getDVDNameAndPrice():
    conn = pymysql.connect(host='localhost',user='root',password='P@$$w0rd',db='test')

    a = conn.cursor()

    sql = 'SELECT * FROM `product`;'

    a.execute(sql)
    data = a.fetchall()

    c = Cart()   
    


    def displayOptions():
        print ("1. Add an item to the cart")
        print ("2. Cart")
        print ("3. Main Menu")
        print ("4. View List of Items")
        print ("5. Total")
        print ("6. Exit")
        
        choice = int(input("Enter your choice: "))
        if choice==6:
            exit()
        elif choice == 1:
            #Add item to the cart
            purchaseID = int(input("Enter the DVD ID of your product:"))
            for dID in itemList:
                if purchaseID == dID.getID():
                    print ('You selected',dID.getName())
                    print ('The price of this item is $',dID.getPrice())
                    confirmPurchase = (input('Do you want to add this item to the cart? (Y/N):'))
                    if confirmPurchase == 'Y' or 'y':
                        quantity = input('Enter the quantity:')
                        name = dID.getName()
                        price = float(dID.getPrice())
                        q = Quantity(name, quantity,price)
                        c.addItem(q)
                        print("\nName:",dID.getName(),"\nPrice:$", dID.getPrice(),"\nQuantity:",quantity,"\nSuccessfully added to the cart.\n\n")
                        displayOptions()
                        
        elif choice ==2:
            #cart
            c.list_cart_items()
        elif choice == 3:
            #User back to the main menu
            mainMenu()
        elif choice == 4:
            viewList()
        elif choice == 5:
            #print(c.getTotal())
            total = c.getTotal()
            displayTotalwithTax(total)

    itemList = []
    def viewList():
        for dID,n,p,d,r,t in data:
            itemList.append(Item(dID,n,p,d,r,t))
            item1 = Item(dID,n,p,d,r,t)
            print('-------------------------------------------------------')
            print('DVD ID:' , item1.getID())
            print('Name of DVD:',item1.getName())
            print('Prince of DVD:$',item1.getPrice())
            print('\nDescription:',item1.getDescription(),'\n')
            print('IMDB Rating:',item1.getRating())
            print('DVD Type:',item1.getDvdType())
            print('-------------------------------------------------------')

        displayOptions()

    viewList()
    
            
      
#This a function that creates new table in the database 
def createTable():
    conn = pymysql.connect(host='localhost',user='root',password='P@$$w0rd',db='test')
    a = conn.cursor()

    a.execute("""CREATE TABLE produc
        (
        productID int primary key,
        name varchar(20)
        )
        """)
    conn.commit()
    conn.close()

#This function adds new row to the database. The parameters are passed from addNewDVD fuction.
def insertData(productID,name,price,description,rating,dvdtype):
    conn = pymysql.connect(host='localhost',user='root',password='P@$$w0rd',db='test')
    a = conn.cursor()
    
    a.execute("INSERT INTO product(productID,name,price,description,rating,type) VALUES(%s,%s,%s,%s,%s,%s)",
             (productID,name,price,description,rating,dvdtype))
    print("success")

    conn.commit()
    conn.close()

#Asks user to input the data to add new DVD to the database.
def addNewDVD():
    dvdID = input("Enter the DVD id:")
    name = input("Enter DVD name: ")
    price = input("Enter the price of DVD :$")
    description = input("Enter the DVD description:")
    rating = input("Enter IMDB rating out of 10 points:")
    dvdType = input("Enter DVD type (Blu-Ray or DVD):")
    insertData(dvdID,name,price,description,rating,dvdType)

#Delete an entry from the database
def deleteRow():
    conn = pymysql.connect(host='localhost',user='root',password='P@$$w0rd',db='test')
    a = conn.cursor()
    productID = input("Enter the productID that you want to delete:")
    
    a.execute("DELETE FROM product WHERE productID = %s",(productID))
    print("successfully deleted")

    conn.commit()
    conn.close()
    countrow()

def mainMenu():
        c = Cart()
        print ("1. List all items and their prices")
        print ("2. List cart items")
        print ("3. Add an item to the cart")
        print ("4. Remove a item from the cart")
        print ("5. Checkout")
        print ("6. Exit")
        choice = int(input("Enter your choice: "))
        if choice==6:
            exit()
        elif choice == 1:
            #list_all_items()
            #Delete the code above
            getDVDNameAndPrice()
        elif choice == 2:
            c.list_cart_items()
        elif choice == 3:
            getDVDNameAndPrice()
        elif choice == 4:
            name = input("Enter the name of the item to remove from cart: ")
            c.removeItem(name)
        elif choice == 5:
            total = c.getTotal()
            displayTotalwithTax(total)
            
def displayTotalwithTax(total):
    tax = total*0.07
    grand_total = total+tax
    print("Your subtotal: %.2f$" %(total))
    print("Your tax: %.2f$" %(tax))
    print("Your total: %.2f$" %(grand_total))
    choice = input("Proced to main menu?(Y/N)")
    if choice == 'Y' or 'y':
        mainMenu()     

class Cart:
    def __init__(self):
        self._products = []

    def addItem(self,quantity):
        self._products.append(quantity)
        
    def getTotal(self):
        total = 0
        price = 0
        
        
        for it in self._products:
            print("Name:",it.name,"\nQuantity:",it.quantity,"\nPrice:$",it.price,"\n\n")
            
            pric = float(it.price)
            quant = float(it.quantity)
            total = total + (pric * quant)
            

            print("Total from cart:",pric,quant,total)
        return total

    def getNumItems(self):
        count = 0
        for c in self._products:
            count = count + 1
        return count
    def removeItem(self, name):
    #removes the item from the cart's item Products
        for it in self._products:
            if name == it.name:
                self._products.remove(it)
    def list_cart_items(self):
        print("Items available in your shopping cart:")
        for it in self._products:
            print("Name:",it.name,"\nQuantity:",it.quantity,"\nPrice:$",it.price,"\n\n")
            #print("%s %i"%(it.name,it.quantity))

        choice = input("Proced to main menu?(Y/N) Enter 'N' to get total")
        if choice == 'Y' or 'y':
            mainMenu()    
        elif choice == 'N' or 'n':
            for it in self._products:
                print("Name:",it.name,"\nQuantity:",it.quantity,"\nPrice:$",it.price,"\n\n")
                
                pric = float(it.price)
                quant = float(it.quantity)
                total = total + (pric * quant)
                
                print("Total from cart:",pric,quant,total)
                choice = input("Proced to main menu?(Y/N)")
                if choice == 'Y' or 'y':
                    mainMenu() 
        else:
            exit()
                
class Quantity:
        # Initialize the function and its attributes
    def __init__(self, name, quantity,price):
        self.name = name
        self.quantity = quantity
        self.price = price
        
    def getPrice(self):
        return self.quantity
    
    def getName(self):
        return self.name

    def getPrice(self):
        return self.price

# Create a class called Item with two data attributes (name, price)  
class Item:
    
    # Initialize the function and its attributes
    def __init__(self,dvdID, name, price,description,rating,dvdType):
        self._dvdID = dvdID
        self._name = name
        self._price = price
        self._description = description
        self._rating = rating
        self._dvdType = dvdType

    def getID(self):
        return self._dvdID

    def getPrice(self):
        return self._price
        
    def getName(self):
        return self._name

    def getDescription(self):
        return self._description

    def getRating(self):
        return self._rating
    
    def getDvdType(self):
        return self._dvdType
    
    def setID(self,dvdID):
        self.__dvdID = dvdID
        
    def setPrice(self,price):
        self.__price = price

    def setName(self,name):
        self.__name = name

    def setDescription(self,description):
        self.__description = description

    def setRating(self,rating):
        self.__rating = rating

    def setDvdType(self,dvdType):
        self.__dvdType = dvdType
        
def loadDataToItemClass():
    
    
    conn = pymysql.connect(host='localhost',user='root',password='P@$$w0rd',db='test')

    a = conn.cursor()
    
    sql = 'SELECT productID,name,price,description,rating,type FROM `product`;'

    a.execute(sql)
    
    data = a.fetchall()
    
    for dID,n,p,d,r,t in data:
        item1 = Item(dID,n,p,d,r,t)
        item1.setID(dID)
        item1.setName(d)
        item1.setPrice(p)
        item1.setDescription(d)
        item1.setRating(r)
        item1.setDvdType(t)
        all_items.append(item1)
        #print('-------------------------------------------------------')
        #print('DVD ID:' , item1.getID())
        #print('\nName of DVD:',item1.getName())
        #print('Prince of DVD:$',item1.getPrice())

    print("Processing...Success!")
    
def exit():
    print("Thank you for shopping with us today.Have a great day!")
    
def main():

    loadDataToItemClass()
    #createTable()
    #addNewDVD()
    #countrow()
    #deleteRow()
    mainMenu()
    
    
main()