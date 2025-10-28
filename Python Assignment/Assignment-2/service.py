
from food_product import *
from product import *

p1 = Product(1, "iPhone", 5, 27000, "Shelf1", "Clearance")
productList = [p1]

def add_product():
    print("Choose Product Type\n")
    print("1.Regular Product\n2.Food Product With Expiry\n")
    choice = int(input("Enter Choice (1/2): "))
    print("Enter Product Details: Product Name, Stock, Price, Location, Tag")
    pro_id = 1
    pro_name = input()
    pro_stock = int(input())
    pro_price = int(input())
    pro_location = input()
    pro_tags = input()
    if choice == 2:
        expiry_date = input("Enter expiry date (YYYY-MM-DD): ")
        product = FoodProduct(pro_id+1, pro_name, pro_stock, pro_price, pro_location, pro_tags, expiry_date)
    else:
        product = Product(pro_id+1, pro_name, pro_stock, pro_price, pro_location, pro_tags)
    productList.append(product)

def show_details(pro_id):
    for product in productList:
        if product.id == pro_id :
            print(f"Product Id ", product.id)
            print(f"Title : ", product.proName)
            print(f"Stock : ", product.stock)
            if product.tags == "Clearance":
                print(f"Price : ", product.price / 2, "(50 % Discount)")
            else:
                print(f"Price : ", product.price)
            print(f"Location : ", product.location)
            print(f"Tags : ", product.tags, "\n")
            return

def show_all():
    if not productList:
        print("No Products Found\n")
        return
    print("All Products:")
    for product in productList:
        print(product)



def delete_pro(delete_id):
    for product in productList:
        if product.id == delete_id:
            productList.remove(product)
            print("Product ",product.id, "deleted")
            return
    print("No product found with product id ", delete_id)


def update_stock(update_id, new_stock):
    for product in productList:
        if product.id == update_id:
            product.stock = new_stock
            print("Product ",product.id, "updated")
            return
    print("No product found with product id ",update_id)

def total_value():
    total = 0
    for product in productList:
        if product.tags == "Clearance":
            total = total + product.price/2 * product.stock
        else:
            total += product.price * product.stock
    return total

def show_clearance_stock():
    flag = 0
    print("Clearance Stock:")
    for product in productList:
        if product.tags == "Clearance":
            flag = 1
            show_details(product.id)
    if not flag  :
        print("No Product In Clearance Stock")
    return