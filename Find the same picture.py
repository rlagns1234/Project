import pygame
import random
import logging
import tkinter

# 게임에 사용되는 전역 변수 정의
WHITE = (255, 255, 255)
pad_width = 850
pad_height = 650
background_x = 0

#배경 함수
def back(x,y):
    global gamepad, background
    gamepad.blit(background,(x,y))

# 게임 실행 메인 함수
def runGame():
   global gamepad, background

   doneFlag = False
   while not doneFlag:
      for event in pygame.event.get():
         if event.type == pygame.QUIT:
            doneFlag = True

      # 게임 화면을 검정색으로 채우고 화면을 업데이트 함
      gamepad.fill(WHITE)
      back(background_x,0)
      pygame.display.update()

   pygame.quit()

# 게임 초기화 함수
def initGame():
   global gamepad, background

   pygame.init()
   gamepad = pygame.display.set_mode((pad_width, pad_height))
   pygame.display.set_caption('Find the same picture')
   background = pygame.image.load('capet.png')
initGame()
runGame()
