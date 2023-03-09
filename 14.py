save_money=5000
def calc_money():
    rate=0.03
    return save_money*rate

print("당신의 예금액 %d" % (save_money))
result=calc_money()
print("이자 = %d" % (result))
