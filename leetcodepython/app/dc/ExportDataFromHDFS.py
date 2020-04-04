file = open('/Users/johnMacBookPro/Desktop/000000_0', 'r')
# print(file.readline())
for byte in file.readline():
    a = str(byte).split('<0x01>')
    # if ord(byte) & 0x01:
    #     print('a:' + byte)
    # else:
    #     print('b:' + byte)
