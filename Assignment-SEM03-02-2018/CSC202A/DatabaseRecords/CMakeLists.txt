cmake_minimum_required(VERSION 3.12)
project(DatabaseRecords C)

set(CMAKE_C_STANDARD 11)

add_executable(DatabaseRecords main.c input_helper.c input_helper.h debug_helper.h database.c database.h binary_tree.c binary_tree.h city_data.c city_data.h vector.c vector.h)