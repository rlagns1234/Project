import random
import turtle
t= turtle.Pen()
turtle.bgcolor("black")
colors = ["red","yellow","blue","green","orange","purple","white","gray"]
#angles = [90, 144, 144]

# for n in range(50): //50번 반복 for문
while True:
    t.pencolor(random.choice(colors))
    #a = random.choice(angles)
    size=random.randint(10,40)
    x=random.randrange(-turtle.window_width()//2,
                       turtle.window_width()//2)
    y=random.randrange(-turtle.window_height()//2,
                       turtle.window_height()//2,)

    t.penup()[ytho]
    t.setpos(x,y)
    t.pendown()
    for m in range(5):
        t.forward(50)
        t.left(144)
