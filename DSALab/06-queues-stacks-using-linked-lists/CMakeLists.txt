cmake_minimum_required(VERSION 3.12)
project(06_queues_stacks_using_linked_lists C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(06_queues_stacks_using_linked_lists
        debug_helper.h
        input_helper.c
        input_helper.h
        linked_list.c
        linked_list.h
        main.c
        vector.c
        vector.h)
