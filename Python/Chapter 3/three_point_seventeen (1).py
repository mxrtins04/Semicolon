for row in range(1, 11):
    for column in range(row):
        print('*', end='')
    print()

print()


for row in range(10, 0, -1):
    for column in range(row):
        print('*', end='')
    print()

print()


for row in range(10):
    
    for colomn in range(row):
        print(' ', end='')
    
    for colomn2 in range(10 - row):
        print('*', end='')
    print()


for row in range(1, 10 + 1):
    
    for colomn in range(10 - row):
        print(' ', end='')
    
    for colomn2 in range(row):
        print('*', end='')
    print()
