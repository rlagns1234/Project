from PIL import Image
 
im = Image.open('troll.jpg')
print(im.size)
# Thumbnail 이미지 생성
size = (90, 160)
im.thumbnail(size)

im.save('troll.gif')
