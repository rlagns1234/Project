import random
choices = ["바위","보","가위"]
print("바위가 가위를 이깁니다. 가위가 보를 이깁니다. 보가 바위를 이깁니다.")
player = input("가위, 바위, 보 중 하나를 선택해주세요. (또는 quit로 게임을 종료합니다.)\n")
while player != "quit":
    computer = random.choice(choices)
    print("당신이 선택한 것은 "+player+", 컴퓨터가 선택한 것은 "+computer+"입니다.")
    if player == computer:
        print("비겼습니다!")
    elif player == "바위":
        if computer == "가위":
            print("여러분이 이겼습니다!")
        else:
            print("컴퓨터가 이겼습니다!")

    elif player == "보":
        if computer == "바위":
            print("여러분이 이겼습니다!")
        else:
            print("컴퓨터가 이겼습니다!")

    elif player == "가위":
        if computer == "보":
            print("여러분이 이겼습니다!")
        else:
            print("컴퓨터가 이겼습니다!")

    else:
        print("에러가 발생했습니다...")

    print()                             #한줄 비우기
    player=input("가위, 바위, 보 중 하나를 선택해주세요. (또는 quit로 게임을 종료합니다)\n")
