from  service import *
def main():
    choice = 0
    while choice != 7:
        choice = int(input(
            "1.Insert Product\n2.List All Products\n3.Delete Product\n4.Update Stock\n5.Total product value\n6.Clearance Stock\n7.Exit\n"))
        if choice == 1:
            add_product()
        elif choice == 2:
            show_all()
        elif choice == 3:
            delete_id = int(input("Enter Product ID To Delete That Product: "))
            delete_pro(delete_id)
        elif choice == 4:
            update_id = int(input("Enter Product ID To Update : "))
            new_stock = int(input("Enter Stock Value : "))
            update_stock(update_id, new_stock)
        elif choice == 5:
            print(f"Toatal Product Value: {total_value()}\n")
        elif choice == 6:
            show_clearance_stock()
        elif choice == 7:
            exit()
        else:
            print("Invalid Choice")
if __name__ == "__main__":
    main()