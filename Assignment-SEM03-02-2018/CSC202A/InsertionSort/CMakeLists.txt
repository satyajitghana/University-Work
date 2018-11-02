cmake_minimum_required(VERSION 3.12)
project(InsertionSort C)

set(CMAKE_C_STANDARD 99)

add_executable(InsertionSort main.c
        input_helper.h
        input_helper.c
        vector.h
        vector.c
        database.c
        database.h
        city_data.c
        city_data.h
        binary_tree.h
        binary_tree.c)