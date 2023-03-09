import random
suits = ["클로버","다이아몬드","하트","스페이드"]
faces = ["2","3","4","5","6","7","8","9","10","J","Q","K","A"]
my_face = random.choice(faces)
my_suit = random.choice(suits)
print("내가 가진 카드는 ",my_face,"",my_suit,"입니다.")
