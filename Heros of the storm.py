Python 3.6.8 (tags/v3.6.8:3c6b436a57, Dec 24 2018, 00:16:47) [MSC v.1916 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> import turtle as t
>>> t.shape("turtle")
>>> for i in range(100):
	t.left(20)
	t.forward(100-i)
	t.left(90)
	t.forward(100-i)
	t.left(90)
	t.forward(100-(i+1))
	t.left(90)
	t.forward(100-(i+1))

	
>>> clear
Traceback (most recent call last):
  File "<pyshell#11>", line 1, in <module>
    clear
NameError: name 'clear' is not defined
>>> clear()
Traceback (most recent call last):
  File "<pyshell#12>", line 1, in <module>
    clear()
NameError: name 'clear' is not defined
>>> t.clear()
>>> t.restart()
Traceback (most recent call last):
  File "<pyshell#14>", line 1, in <module>
    t.restart()
AttributeError: module 'turtle' has no attribute 'restart'
>>> t.reset()
>>> for i in range(100):
	t.left(110)
	t.forward(100-i)
	t.left(90)
	t.forward(100-i)
	t.left(90)
	t.forward(100-(i+1))
	t.left(90)
	t.forward(100-(i+1))

	
>>> t.reset()
>>> for i in range(100):
	t.left(20)
	t.forward(100-i)
	t.left(90)
	t.forward(100-i)
	t.left(90)
	t.forward(100-(i+1))
	t.left(90)
	t.forward(100-(i+1))

	
>>> 
