"""
- Collect the users age and store in the variable age
- Create a new variable mhr and let its value be 220 - age
- Create a new variable minimum_target_heartrate and let its value be 50% of mhr
- Create a new variable maximum_target_heartrate and let its value be 85% of mhr
- Display the maximum_target_heartrange and minimum_target_heartrate as the users maximum heart rate range
"""

age = int(input("Input your age: "))
#mhr stands for maximum heart rate
mhr = 220 - age
minimum_target_heartrate = (50/100) * mhr
maximum_target_heartrate = (85/100) * mhr

print("Your maximum heart range is: ", mhr, "\nYour target heart rate is in the range of", maximum_target_heartrate, "and", minimum_target_heartrate)
