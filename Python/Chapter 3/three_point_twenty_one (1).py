price = float(input("Enter purchase price: ))

change = round(1.00 - price, 2)  
change_cents = int(round(change * 100))  


quarters = change_cents // 25
change_cents %= 25

dimes = change_cents // 10
change_cents %= 10

nickels = change_cents // 5
change_cents %= 5

pennies = change_cents

print("Your change is:")
if quarters > 0:
    print(f"{quarters} quarters")
if dimes > 0:
    print(f"{dimes} dimes")
if nickels > 0:
    print(f"{nickels} nickels")
if pennies > 0:
    print(f"{pennies} pennies")