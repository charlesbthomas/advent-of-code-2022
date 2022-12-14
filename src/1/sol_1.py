current_elf = 0
max_elf = 0

with open('input.txt') as file:
    for line in file:
        # print(current_elf)
        if "\n" == line:
            if current_elf > max_elf:
                max_elf = current_elf
            current_elf = 0
        else:
            current_elf += int(line)


print(max_elf)
