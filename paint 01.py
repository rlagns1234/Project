# myArtApp.py
from tkinter import *

#### Set variables. 변수를 정합니다.
canvas_height = 400
canvas_width = 600
canvas_colour = "black"
x_coord = canvas_width/2
y_coord = canvas_height
line_colour = "red"
line_width = 5
line_length = 5

#### Functions. 함수
def move(x,y):
    global x_coord
    global y_coord
    global current_line
    new_x_coord = x_coord + x
    new_y_coord = y_coord + y
    canvas.create_line(x_coord,y_coord,new_x_coord,new_y_coord,width=line_width,fill=line_colour)
    x_coord = new_x_coord
    y_coord = new_y_coord

def move_N(event):
    move(0, -line_length)

def move_S(event):
    move(0, line_length)

def move_E(event):
    move(line_length, 0)
    
def move_W(event):
    move(-line_length, 0)
    
def erase_all(event):
    canvas.delete(ALL)
    canvas.create_image(0, 0, image=scene, anchor=NW)

window = Tk()
window.title("MyArtApp")
canvas = Canvas(bg=canvas_colour, height=canvas_height,
                width=canvas_width, highlightthickness=0)
canvas.pack()
# bind movement to keys. 키보드 키를 연결합니다.
window.bind("<Up>", move_N)
window.bind("<Down>", move_S)
window.bind("<Left>", move_W)
window.bind("<Right>", move_E)
window.bind("e", erase_all)

window.mainloop()


