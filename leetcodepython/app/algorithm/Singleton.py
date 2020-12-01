"""
singleton by __new__ method
"""


class Singleton(object):
    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            orig = super(Singleton, cls)
            cls._instance = orig.__new__(cls, *args, **kwargs)
        return cls._instance


class MyClass(Singleton):
    a = 1


"""
share attribute
创建实例时把所有实例的__dict__指向同一个字典,这样它们具有相同的属性和方法.
"""


class Borg(object):
    _state = {}

    def __new__(cls, *args, **kwargs):
        ob = super(Borg, cls).__new__(cls, *args, **kwargs)
        ob.__dict__ = cls._state
        return ob


class MyClass2(Borg):
    a = 1


"""
装饰器版本
"""


def singleton(cls):
    instances = {}

    def getinstance(*args, **kwargs):
        if cls not in instances:
            instances[cls] = cls(*args, **kwargs)
        return instances[cls]

    return getinstance


@singleton
class MyClass3:
    pass

"""
mysingleton.py
作为python的模块是天然的单例模式
"""
class My_Singleton(object):
    def foo(self):
        pass


my_singleton = My_Singleton()

# # to use
# from mysingleton import my_singleton
#
# my_singleton.foo()
