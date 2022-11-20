cmake_minimum_required(VERSION 3.12)
project(leetcode)

set(CMAKE_CXX_STANDARD 98)
set(CMAKE_CXX_STANDARD 11 -std=c++17)
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fsanitize=address,undefined")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS}")
set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS}")
#set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} -fsanitize=address,undefined")
#set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fsanitize=address -g3")


add_executable(OneNine leetcode/OneNine.cpp)
add_executable(ThreeZero leetcode/ThreeZero.cpp)
add_executable(test leetcode/test.cpp)