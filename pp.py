all_items = []
# Create a class called Quantity with two data attributes (name, quantity)
class Quantity:
        # Initialize the function and its attributes
    def __init__(self, name, quantity):
        self.name = name
        self.quantity = quantity
        
    def getPrice(self):
        return self.quantity
    
    def getName(self):
        return self.name
    
# Create a class called Item with two data attributes (name, price)  
class Item:
        # Initialize the function and its attributes
    def __init__(self, name, price):
        self.name = name
        self.price = price

    def getPrice(self):
        return self.price
        
    def getName(self):
        return self.name
    
# Create a class called Cart
class Cart:
    def __init__(self):
        self.products = []

    def addItem(self, quant):
        self.products.append(quant)

    def getTotal(self):
        total = 0
        price = 0
        for item in self.products:
            name = item.name
            for it in all_items:
                if name == it.name:
                    price = it.price
            quantity = item.quantity
            total = total + (price * quantity)
        return total

    def getNumItems(self):
        count = 0
        for c in self.products:
            count = count + 1
        return count
    def removeItem(self, name):
    #removes the item from the cart's item Products
        for it in self.products:
            if name == it.name:
                self.products.remove(it)
    def list_cart_items(self):
        print("Items available in your shopping cart:")
        for it in self.products:
            print("%s %i"%(it.name,it.quantity))
def list_all_items():
        print("Items available for shopping along with their prices:")
        for it in all_items:
                print("%s  %.2f$"%(it.name,it.price))

# Create the main function
def main():
    c = Cart()
    productsFile = open("products.csv", "r")
    for line in productsFile:
                line = productsFile.readline()
                while line != "":
                        print(line)
                        line = productsFile.readline()
                productsFile.close()
                item = line.split(',')
                it = Item(name, float(price.strip()))
                all_items.append(it)
                
    print(all_items)
    choice = 1
    while choice!=6:
        print ("1. List all items and their prices")
        print ("2. List cart items")
        print ("3. Add an item to the cart")
        print ("4. Remove a item from the cart")
        print ("5. Checkout")
        print ("6. Exit")
        choice = int(input("Enter your choice: "))
        if choice==6:
            return
        elif choice == 1:
            list_all_items()
        elif choice == 2:
            c.list_cart_items()
        elif choice == 3:
            name = input("Enter the item name: ")
            quantity = int(input("Enter the quantity: "))
            q = Quantity(name, quantity)
            c.addItem(q)
        elif choice == 4:
            name = input("Enter the name of the item to remove from cart: ")
            c.removeItem(name)
        elif choice == 5:
            total = c.getTotal()
            tax = total*0.07
            grand_total = total+tax
            print("Your subtotal: %.2f$" %(total))
            print("Your tax: %.2f$" %(tax))
            print("Your total: %.2f$" %(grand_total))

# Call the main function
main()