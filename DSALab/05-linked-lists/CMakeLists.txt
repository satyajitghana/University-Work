cmake_minimum_required(VERSION 3.12)
project(05_linked_lists C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(05_linked_lists
        debug_helper.h
        input_helper.c
        input_helper.h
        linked_list.c
        linked_list.h
        main.c
        vector.h
        vector.c)
