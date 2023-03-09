from tkinter import *
import random
import time
import threading

root = Tk()
root.geometry("960x540+100+100")
root.resizable(False, False)
root.title("Find the same picture")
c = []
card = 0;
tf = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
count = 0
ex = 0

def click0():
    global click, card, tf
    if card < 2 and tf[0] < 1:
        click(0)

def click1():
    global click, card, tf
    if card < 2 and tf[1] < 1:
        click(1)

def click2():
    global click, card, tf
    if card < 2 and tf[2] < 1:
        click(2)

def click3():
    global click, card, tf
    if card < 2 and tf[3] < 1:
        click(3)

def click4():
    global click, card, tf
    if card < 2 and tf[4] < 1:
        click(4)

def click5():
    global click, card, tf
    if card < 2 and tf[5] < 1:
        click(5)

def click6():
    global click, card, tf
    if card < 2 and tf[6] < 1:
        click(6)

def click7():
    global click, card, tf
    if card < 2 and tf[7] < 1:
        click(7)

def click8():
    global click, card, tf
    if card < 2 and tf[8] < 1:
        click(8)

def click9():
    global click, card, tf
    if card < 2 and tf[9] < 1:
        click(9)

def click10():
    global click, card, tf
    if card < 2 and tf[10] < 1:
        click(10)

def click11():
    global click, card, tf
    if card < 2 and tf[11] < 1:
        click(11)

def click12():
    global click, card, tf
    if card < 2 and tf[12] < 1:
        click(12)
def click13():
    global click, card, tf
    if card < 2 and tf[13] < 1:
        click(13)

def click14():
    global click, card, tf
    if card < 2 and tf[14] < 1:
        click(14)

def click15():
    global click, card, tf
    if card < 2 and tf[15] < 1:
        click(15)

def click16():
    global click, card, tf
    if card < 2 and tf[16] < 1:
        click(16)
        
def click17():
    global click, card, tf
    if card < 2 and tf[17] < 1:
        click(17)

def click(a):
    global c, bt, imge, tf, card
    b = bt[a]
    if card < 2:
        b['image'] = imge[a]
        c.append(a)
        card+=1
    t = threading.Thread(target = same)
    t.start()

def same():
    global c, bt, imge, tf, card, count, ex
    count+=1
    to = 0
    if card == 2:
        if imge[c[0]] == imge[c[1]]:
            ex+=1
            tf[c[0]] = 1
            tf[c[1]] = 1
        else:
            time.sleep(1)
            bt[c[0]]['image'] = Taro_back
            bt[c[1]]['image'] = Taro_back
        c = []
        card = 0
        
    if ex == 9:
        root2 = Tk()
        root2.title("message")
        root2.geometry("100x70+100+100")
        root2.resizable(False, False)
        lbl = Label(root2, text="게임 종료")
        lbl2 = Label(root2, text="횟수 : %d" % count)
        btn = Button(root2, text="확인", command = root2.destroy)
        lbl.pack()
        lbl2.pack()
        btn.pack()
 
        root2.mainloop()

background = PhotoImage(file = "capet.gif")
Taro_back = PhotoImage(file = "Taro_back.gif")
Taro0 = PhotoImage(file = "Taro_00.gif")
Taro1 = PhotoImage(file = "Taro_01.gif")
Taro2 = PhotoImage(file = "Taro_02.gif")
Taro3 = PhotoImage(file = "Taro_03.gif")
Taro4 = PhotoImage(file = "Taro_04.gif")
Taro5 = PhotoImage(file = "Taro_05.gif")
Taro6 = PhotoImage(file = "Taro_06.gif")
Taro7 = PhotoImage(file = "Taro_07.gif")
troll = PhotoImage(file = "troll.gif")
Taro_img_list = [Taro0, Taro1, Taro2, Taro3, Taro4, Taro5, Taro6, Taro7, troll, Taro0, Taro1, Taro2, Taro3, Taro4, Taro5, Taro6, Taro7, troll]

label = Label(root, image = background)
label.place (x = -2, y = 0)

frameA = Frame(root)
frameA.pack()
frame1 = Frame(root)
frame1.pack()
frameB = Frame(root)
frameB.pack()
frame2 = Frame(root)
frame2.pack()
frameC = Frame(root)
frameC.pack()
frame3 = Frame(root)
frame3.pack()
imge = []
for k in range(len(Taro_img_list)):
    r = random.randint(0, len(Taro_img_list)-1)
    imge.append(Taro_img_list[r])
    del Taro_img_list[r]
b0 = Button(frame1, image = Taro_back, command = click0)
b1 = Button(frame1, image = Taro_back, command = click1)
b2 = Button(frame1, image = Taro_back, command = click2)
b3 = Button(frame1, image = Taro_back, command = click3)
b4 = Button(frame1, image = Taro_back, command = click4)
b5 = Button(frame1, image = Taro_back, command = click5)
b6 = Button(frame2, image = Taro_back, command = click6)
b7 = Button(frame2, image = Taro_back, command = click7)
b8 = Button(frame2, image = Taro_back, command = click8)
b9 = Button(frame2, image = Taro_back, command = click9)
b10 = Button(frame2, image = Taro_back, command = click10)
b11 = Button(frame2, image = Taro_back, command = click11)
b12 = Button(frame3, image = Taro_back, command = click12)
b13 = Button(frame3, image = Taro_back, command = click13)
b14 = Button(frame3, image = Taro_back, command = click14)
b15 = Button(frame3, image = Taro_back, command = click15)
b16 = Button(frame3, image = Taro_back, command = click16)
b17 = Button(frame3, image = Taro_back, command = click17)
bt = [b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17]
fr = [frameA, frameB, frameC]
fr2 = [frame1, frame2, frame3]

#btlen = len(bt)/3
#num = 0;
#for i in range(len(fr)):
#    Label(fr[i], image = background,height = 20).pack(side=LEFT)
#    for j in range(int(btlen)):
#        bt[0].pack
#        Label(fr2[i], image = background, width = 50, height = 140).pack(side=LEFT)

Label(frameA, image = background,height = 20).pack(side=LEFT)
b0.pack(side = LEFT)
Label(frame1, image = background, width = 50, height = 140).pack(side=LEFT)
b1.pack(side = LEFT)
Label(frame1, image = background, width = 50, height = 140).pack(side=LEFT)
b2.pack(side = LEFT)
Label(frame1, image = background, width = 50, height = 140).pack(side=LEFT)
b3.pack(side = LEFT)
Label(frame1, image = background, width = 50, height = 140).pack(side=LEFT)
b4.pack(side = LEFT)
Label(frame1, image = background, width = 50, height = 140).pack(side=LEFT)
b5.pack(side = LEFT)

Label(frameB, image = background,height = 20).pack(side=LEFT)
b6.pack(side = LEFT)
Label(frame2, image = background, width = 50, height = 140).pack(side=LEFT)
b7.pack(side = LEFT)
Label(frame2, image = background, width = 50, height = 140).pack(side=LEFT)
b8.pack(side = LEFT)
Label(frame2, image = background, width = 50, height = 140).pack(side=LEFT)
b9.pack(side = LEFT)
Label(frame2, image = background, width = 50, height = 140).pack(side=LEFT)
b10.pack(side = LEFT)
Label(frame2, image = background, width = 50, height = 140).pack(side=LEFT)
b11.pack(side = LEFT)

Label(frameC, image = background,height = 20).pack(side=LEFT)
b12.pack(side = LEFT)
Label(frame3, image = background, width = 50, height = 140).pack(side=LEFT)
b13.pack(side = LEFT)
Label(frame3, image = background, width = 50, height = 140).pack(side=LEFT)
b14.pack(side = LEFT)
Label(frame3, image = background, width = 50, height = 140).pack(side=LEFT)
b15.pack(side = LEFT)
Label(frame3, image = background, width = 50, height = 140).pack(side=LEFT)
b16.pack(side = LEFT)
Label(frame3, image = background, width = 50, height = 140).pack(side=LEFT)
b17.pack(side = LEFT)
root.mainloop()
