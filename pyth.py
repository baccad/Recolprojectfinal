class productList:

      def __init__ (self, productName = "none", description = "none", price = 0, quantity = 0):
            self.__productName = productName
            self.__description = description
            self.__price = price            
            self.__quantity = quantity

      #Creating mutator (setter) methodes
      #Set the item's name
      def set_productName(self, productName):
            self.__productName = productName
      #Set the item's description
      def set_description(self, description):
            self.__description = description
      #Set the item's price
      def set_price(self, price):
            self.__price = price
      #Set the item's quantity
      def set_quantity(self, quantity):
            self.__quantity = quantity


      #Creating accessor (getter) methodes
      #Get the item's name
      def get_productName(self):
            return self.__productName
      #Get the item's description
      def get_description(self):
            return self.__description
      #Get the item's price
      def get_price(self):
            return self.__price
      #Get the item's quantity
      def get_quantity(self):
            return self.__quantity
 
      def itemPrice(self):
            string = "{} : {}".format(self.__productName, self.__quantity, self.__price, (self.__quantity * self.__price))

            item_price = self.__quantity * self.__price
            return string, item_price

      def itemDescription(self):
            string = "{} : {}".format(self.__productName, self.__description)
            print(string, end = "\n")
            return string

class shoppingCart:
      def __init__(self, itemsInCart = []):

            self.__itemsInCart = itemsInCart

      def addProduct(self, string):
            print ("\nADD ITEM TO CART", end= "\n")
            productName = str(input("\nEnter the item name: "))
            description = str(input("\nEnter the item description: "))
            price = float(input("\nEnter the item price: "))
            quantity = int(input("\nEnter the item quantity: "))

            self.itemsInCart.append(productList(productName,
                                                description, quantity, price))

      def removeProduct(self):
            print("\nRemove product from cart", end = "\n")
            string = str(input("Enter the name of the product to remove: "))
            p = 0

            for product in self.itemsInCart[p]:
                  if (product.productName == string):
                        del self.itemsInCart[p]
                        p = p + 1

                        indication = True
                        break

                  else:
                        indication = False

            if(indication == False):
                  print("This product is not available in your cart")

      def changeProductQuantity(self):
            print("\nChange product quantity from cart", end = "\n")

            Name = str(input("Enter the name of the product to change the quantity"))

            for product in self.itemsInCart:
                  if (product.productName == Name):
                        productQuantity = int(input("Enter the new quantity: "))
                        product.quantity = productQuantity

                        indication = True
                        break
                  else:
                        indication = False
            if (indication == False):
                  print("This product is not available in your cart. Nothing changed")

      def numOfProdInCart(self):
            numProd = 0
            for product in self.itemsInCart:
                  numProd = numProd + product.quantity
            return numProd

      def totalCostOfCart(self):
            totalCost = 0
            cost = 0
            for product in self.itemsInCart:
                  cost = (product.quantity * product.price)
                  totalCost = totalCost + cost
            return totalCost

      def printTotal(self):
            totalCost = totalCostOfCart()
            if (totalCost == 0):
                  print("Your shopping cart is empty")
            else:
                  outputCart()
      def printDescription(self):
            print("\nOutput products\" Descriptions")
            print("\nProduct Descriptions", end = "\n")
            for product in self.itemsInCart:
                  print("{} : {}".format(product.productName, product.description), end = "\n")

      def outputCart(self):
            new = shoppingCart()
            print("\nOutput the Shopping Cart", end = "\n")
            print("Number of products: ", new.numOfProdInCart(), end = "\n\n")

            oc = 0
            for product in self.itemsInCart:
                  print("{} {} @ ${} = ${}".format(product.productName, product.quantity,
                                                   product.price, (product.quantity * product.price)), end = "n")

                  oc = oc + (product.quantity * product.price)
            print("\nTotal: ${}".format(oc), end = "\n")


def initialMenu(shoppingCart):
      cutomerCart = newCart
      string = ""

      menu = ("\nMENU\n"
              "A - Add product into your Shopping Cart\n"
              "R - Remove product from your Shopping Cart\n"
              "M - Change the product quantity from your Shopping Cart\n"
              "P - Output products\" Descriptions\n"
              "O - Output the Shopping Cart\n"
              "Q - Quit\n")

      command = ""

      while (command != "Q"):
            string = ""
            print(menu, end = "\n")

            command = input("Choose an option from the list: ")

            while (command != "A" and command != "R" and command != "M"
                   and command != "P" and command != "O" and command != "Q"):
                  command = input("Choose an option from the list: ")

                  if (command == "A"):
                        customerCart.addProduct(string)

                  if (command == "R"):
                        customerCart.removeProduct()

                  if (command == "M"):
                        customerCart.changeProductQuantity()

                  if (command == "O"):
                        customerCart.outputCart()

                  if (command == "P"):
                        customerCart.printDescription()

newCart = shoppingCart

initialMenu(newCart)

        