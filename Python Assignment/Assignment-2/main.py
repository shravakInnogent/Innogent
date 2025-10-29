from  service import *
def main():
    choice = 0
    while choice != 8:
        choice = int(input(
            "1.Insert Product\n2.Low Stock Check\n3.List All Products\n4.Delete Product\n5.Update Stock\n6.Total product value\n7.Clearance Stock\n8.Exit\n"))
        if choice == 1:
            add_product()
        elif choice == 2:
            lowStock()
        elif choice == 3:
            show_all()
        elif choice == 4:
            delete_id = int(input("Enter Product ID To Delete That Product: "))
            delete_pro(delete_id)
        elif choice == 5:
            update_id = int(input("Enter Product ID To Update : "))
            new_stock = int(input("Enter Stock Value : "))
            update_stock(update_id, new_stock)
        elif choice == 6:
            print(f"Toatal Product Value: {total_value()}\n")
        elif choice == 7:
            show_clearance_stock()
        elif choice == 8:
            exit()
        else:
            print("Invalid Choice")
if __name__ == "__main__":
    main()