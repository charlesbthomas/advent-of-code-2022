

scoreTable = {
    "X": 1,
    "Y": 2,
    "Z": 3
}

winCondition = {
    "A": "Y",
    "B": "Z",
    "C": "X"
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
        if winCondition.get(opp) == me:
            score += 6
        elif tieCondition.get(opp) == me:
            score += 3

        score += scoreTable.get(me)
        scores.append(score)

print(sum(scores))
