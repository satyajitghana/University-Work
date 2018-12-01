cmake_minimum_required(VERSION 3.12)
project(07_binary_tree C)

set(CMAKE_C_STANDARD 99)

add_executable(07_binary_tree main.c
        binary_tree.c
        binary_tree.h
        debug_helper.h
        input_helper.c
        input_helper.h
        vector.c
        vector.h)