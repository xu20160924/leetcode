cmake_minimum_required(VERSION 3.12)
project(leetcode)

set(CMAKE_CXX_STANDARD 11 -std=c++11)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fsanitize=address,undefined")
set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} -fsanitize=address,undefined")
#set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -fsanitize=address -g3")
#
#if(MSVC)
#    set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} /STACK:16777216")
#else()
#    set(CMAKE_EXE_LINKER_FLAGS "${CMAKE_EXE_LINKER_FLAGS} -Wl,--stack,16777216")
#endif()

add_executable(ThreeZero leetcode/ThreeZero.cpp)
add_executable(FourTwo leetcode/FourTwo.cpp
        leetcode/SixFiveEight.cpp
        leetcode/NineZeroNine.cpp
        leetcode/FourThreeThree.cpp
        leetcode/SixSeven.cpp
        leetcode/FiveEight.cpp
        leetcode/OneOneSeven.cpp
        leetcode/Node.cpp
        leetcode/Node.h
        leetcode/OneTwoOne.cpp
        leetcode/Four.cpp
        leetcode/OneThreeFour.cpp
        leetcode/OneNineZeroSix.cpp
        leetcode/Test.cpp
)
add_executable(SixFiveEight leetcode/SixFiveEight.cpp)
add_executable(OneEightNine leetcode/OneEightNine.cpp)
add_executable(ThreeNineFive leetcode/ThreeNineFive.cpp)
add_executable(ThreeEightSeven leetcode/ThreeEightSeven.cpp)
add_executable(ThreeEightZero leetcode/ThreeEightZero.cpp)
add_executable(ThreeFourSeven leetcode/ThreeFourSeven.cpp)
add_executable(ThreeFourFour leetcode/ThreeFourFour.cpp)
add_executable(ThreeFourOne leetcode/ThreeFourOne.cpp)
add_executable(ThreeThreeNine leetcode/ThreeThreeNine.cpp)
add_executable(TwoTwoThreeNine leetcode/TwoTwoThreeNine.cpp)
add_executable(OneThreeFour leetcode/OneThreeFour.cpp)
add_executable(OneNineZeroSix leetcode/OneNineZeroSix.cpp)
add_executable(NineOneTow leetcode/NineOneTwo.cpp)
add_executable(Test leetcode/Test.cpp)
add_executable(OneSixNine leetcode/OneSixNine.cpp)
add_executable(ThreeTwo leetcode/ThreeTwo.cpp)
add_executable(OneThreeFive leetcode/OneThreeFive.cpp)
