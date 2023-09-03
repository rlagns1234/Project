import pyautogui
import keyboard
import time
import tkinter as tk
from tkinter import *
from tkinter import ttk

class Macro:

    def __init__(self):
        self.lecture_list = []

        self.win = tk.Tk()
        self.win.title('수강신청 반복 매크로')
        self.__buildGUI()
        self.win.mainloop()

    def __buildGUI(self):
        self.__positionFrame().pack()
        self.__lectureListFrame().pack()
        self.__macroFrame().pack()

    def __positionFrame(self):
        pFrame = ttk.Frame(self.win)

        self.entryPositon = tk.StringVar()
        self.clickPositon = tk.StringVar()
        
        self.entryX = tk.IntVar()
        self.entryY = tk.IntVar()
        self.clickX = tk.IntVar()
        self.clickY = tk.IntVar()

        entryText = ttk.Label(pFrame, text='학수번호 입력칸 위치 입력: ')
        clickText = ttk.Label(pFrame, text='메세지 확인버튼 위치 입력: ')
        space = ttk.Label(pFrame, text=' ')
        entryInput = ttk.Label(pFrame, textvariable=self.entryPositon)
        clickInput = ttk.Label(pFrame, textvariable=self.clickPositon)
        entryButton = ttk.Button(pFrame, text= '버튼 누르고 해당 위치에 커서 올린 후 엔터', command=self.__setEntryPosition)
        clickButton = ttk.Button(pFrame, text= '버튼 누르고 해당 위치에 커서 올린 후 엔터', command=self.__setClickPosition)

        entryText.grid(row=0, column=0)
        entryInput.grid(row=0, column=1)
        entryButton.grid(row=0, column=2)
        clickText.grid(row=1, column=0)
        clickInput.grid(row=1, column=1)
        clickButton.grid(row=1, column=2)
        space.grid(row=2, column=0)

        return pFrame

    def __lectureListFrame(self):
        lFrame = ttk.Frame(self.win)

        self.inputLecture = tk.StringVar()

        self.lb = tk.Listbox(lFrame, height=0, selectmode="extended")
        lectureText = ttk.Label(lFrame, text='학수번호-분반 입력 ex)HALF7023-1')
        space = ttk.Label(lFrame, text=' ')
        entry = ttk.Entry(lFrame, textvariable=self.inputLecture, width=27)
        insertButton = ttk.Button(lFrame, text= '추가', command=self.__insert)
        deleteButton = ttk.Button(lFrame, text= '삭제', command=self.__delete)

        lectureText.grid(row=0, column=0, columnspan=2)
        entry.grid(row=1, column=0, columnspan=2)
        insertButton.grid(row=2, column=0)
        deleteButton.grid(row=2, column=1)
        space.grid(row=0, column=3)
        self.lb.grid(row=0, column=4, rowspan=3, sticky='n')

        return lFrame
    
    def __macroFrame(self):
        mFrame = ttk.Frame(self.win)


        startText = ttk.Label(mFrame, text='\n*시작버튼을 누른 후 수강신청 페이지를 선택(클릭)해주세요.\n*시작버튼을 누르면 매크로가 2초 후에 시작됩니다.\n*esc 버튼을 꾹 누르고있으면 매크로가 종료됩니다.')
        startButton = ttk.Button(mFrame, text= '매크로 시작', command=self.__macro)

        startText.pack()
        startButton.pack()

        return mFrame

    def __macro(self):
        time.sleep(2.0)
        while True:
            for i in self.lecture_list:
                pyautogui.click(x=self.entryX.get(), y=self.entryY.get())
                pyautogui.press(i[0])
                pyautogui.hotkey('enter', 'tab')
                pyautogui.press(i[1])
                pyautogui.press('enter')
                time.sleep(0.5)
                pyautogui.click(x=self.clickX.get(),y=self.clickY.get())
            if keyboard.is_pressed('esc'):break

    def __position(self):
        position = (0,0)
        while True:
            position = pyautogui.position()
            if keyboard.is_pressed('enter'):
                break
        return str(position)
            
    def __setEntryPosition(self):
        position = self.__position()

        self.entryPositon.set(position)
        positionList = self.__spiitPosition(position)
        
        self.entryX.set(int(positionList[0]))
        self.entryY.set(int(positionList[1]))

    def __setClickPosition(self):
        position = self.__position()

        self.clickPositon.set(position)
        positionList = self.__spiitPosition(position)
        
        self.clickX.set(int(positionList[0]))
        self.clickY.set(int(positionList[1]))

    def __spiitPosition(self, position):
        strPosition = position.replace('Point(x=', '')
        strPosition = strPosition.replace(')', '')
        positionList = strPosition.split(', y=')
        return positionList

    def __insert(self):
        input = self.inputLecture.get()
        self.lb.insert(END, input)
        listInput = input.split('-')
        listInput[0] = list(listInput[0])
        self.lecture_list.append(listInput)
        self.inputLecture.set('')
    
    def __delete(self):
        del self.lecture_list[self.lb.curselection()[0]]
        self.lb.delete(self.lb.curselection())


def main():
    macro = Macro()

if __name__ == '__main__':
    main()