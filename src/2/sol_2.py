

scoreTable = {
    "A": 1,
    "B": 2,
    "C": 3
}

winCondition = {
    "A": "B",
    "B": "C",
    "C": "A"
}

loseCondition = {
    "A": "C",
    "B": "A",
    "C": "B"
}

tieCondition = {
    "A": "X",
    "B": "Y",
    "C": "Z"
}

scores = []

with open('input.txt') as file:
    for line in file:
        opp, me = line.strip().split(" ")

        score = 0
        if me == 'X':
            choice = loseCondition.get(opp)
        elif me == 'Y':
            choice = opp
            score += 3
        else:
            choice = winCondition.get(opp)
            score += 6

        score += scoreTable.get(choice)
        scores.append(score)

print(sum(scores))
