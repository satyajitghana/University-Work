//
// Created by shadowleaf on 25-Sep-18.
//

#ifndef DATABASERECORDS_CITY_DATA_H
#define DATABASERECORDS_CITY_DATA_H

#include <string.h>
#include <stdio.h>
#include "vector.h"

struct CityData {
    char* id;
    char* name;
    int X;
    int Y;
    Vector* address;
    void (*print)(struct CityData*);
};

struct Coordinates {
    int X;
    int Y;
};

typedef struct Coordinates Coordinates;

typedef struct CityData CityData;

/* Constructors */
CityData* newCity(char*, int, int, Vector*);
Coordinates* newCoordinates(int, int);

/* Print Utils */
void printCityDataHeader();
void printCityData(CityData*);
void printCityUtil(void* _mycity);
void printAddressUtil(void* address);

/* Take Input */
CityData* readInputCity();

/* Comparator Methods */
int compare_name(const void* data1, const void* data2);
int compare_data_and_name(const void* data, const void* name);
int compare_data_and_coordinates(const void* data, const void* coordinates);
int compare_id(const void* data1, const void* data2);

#endif //DATABASERECORDS_CITY_DATA_H
