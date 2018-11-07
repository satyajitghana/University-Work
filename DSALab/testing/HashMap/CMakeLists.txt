cmake_minimum_required(VERSION 3.5.1)
project(HashMap C)

set(CMAKE_C_STANDARD 99)

add_executable(HashMap main.c HashMap.c HashMap.h vector.c vector.h debug_helper.h LinkedList.c LinkedList.h)