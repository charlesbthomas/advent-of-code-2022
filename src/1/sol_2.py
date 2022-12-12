



current_elf = 0


elves = []

with open('input.txt') as file:
  for line in file:
    # print(current_elf)
    if "\n" == line:
      elves.append(current_elf)
      current_elf = 0
    else:
      current_elf += int(line)


elves.sort(reverse=True)

print(f"1st: {elves[0]}")
print(f"2nd: {elves[1]}")
print(f"3rd: {elves[2]}")
print(f"Combined: {elves[0] + elves[1] + elves[2]}")