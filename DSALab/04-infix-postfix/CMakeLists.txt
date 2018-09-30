cmake_minimum_required(VERSION 3.12)
project(04_infix_postfix C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(04_infix_postfix
        debug_helper.h
        exp_eval.c
        exp_eval.h
        input_helper.c
        input_helper.h
        main.c
        stack.c
        stack.h
        vector.c
        vector.h)
