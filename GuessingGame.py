import random
the_number = random.randint(1,100)
guess=int(input("1부터 100사이의 숫자를 맞춰보세요: "))
while guess != the_number:
    if guess > the_number:
        print(guess, "너무 높습니다 다시 시도해주세요.")
    if guess < the_number:
        print(guess, "너무 낮습니다 다시 시도해주세요.")
    guess=int(input("다시 맞춰보세요: "))
print(guess, "정답")
