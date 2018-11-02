//
// Created by shadowleaf on 25-Sep-18.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <memory.h>
#include <limits.h>
#include "city_data.h"
#include "input_helper.h"

/* Constructors */
CityData* newCity(char* name, int X, int Y, Vector* address) {
    CityData* mycity = malloc(sizeof *mycity);
    mycity -> name = name;
    mycity -> X = X;
    mycity -> Y = Y;
    mycity -> print = printCityData;
    mycity -> address = address;

    /* Generate a random UID */
    srand((unsigned) time(NULL));
    mycity -> id = malloc(32 * sizeof *mycity -> id);
    sprintf(mycity -> id, "%lu", random());

    return mycity;
}

Coordinates* newCoordinates(int X, int Y) {
    Coordinates* mycoordinates = malloc(sizeof *mycoordinates);
    mycoordinates -> X = X;
    mycoordinates -> Y = Y;

    return mycoordinates;
}

/* Print Utils */

void printCityDataHeader(){
    printf("%12s %20s %13s\t%s\n",
            "ID", "CITY NAME", "COORDINATES", "ADDRESSES");
    printf("%12s %20s %6s %6s\n",
            "","","X","Y");
    for (int i = 0 ; i < 80 ; i++)
        printf("-");
    printf("\n");
}

void printCityUtil(void* _mycity) {
    CityData* mycity = (CityData*) _mycity;
    printCityData(mycity);
}

void printAddressUtil(void* address) {
    char* _address = (char*) address;
    printf(" %s ", _address);
}

void printCityData(CityData* mycity) {
    printf("%12s %20s %6d %6d\t",
           mycity -> id, mycity -> name, mycity -> X, mycity -> Y);
    mycity -> address -> print(mycity -> address);
    printf("\n");
}

CityData* readInputCity() {
    char* buffer;
    char* name;
    int X, Y;
    Vector* addressVector;
    printf("\nEnter Name of the City : ");
    get_word(&name);
    printf("Enter Coordinate X and Y : ");
    X = next_int();
    Y = next_int();

    addressVector = newMinimalVector(string_compare, printAddressUtil);
    char* address;
    printf("Enter the Addresses : \n");
    while (get_line(&address) > 1) {
        addressVector -> add(addressVector, new_string(address));
    }

    return newCity(name, X, Y, addressVector);
}

/* Comparator Methods */
int compare_name(const void* data1, const void* data2) {
    return strcmp(((CityData*)data1) -> name, ((CityData*)data2) -> name);
}

int compare_id(const void* data1, const void* data2) {
    return atoi(((CityData*)data1) -> id) - atoi(((CityData*)data2) -> id);
}

int compare_data_and_name(const void* data, const void* name) {
    return strcmp(((CityData*)data) -> name, (char*)name);
}

int compare_data_and_coordinates(const void* data, const void* coordinates) {
    if (((CityData*)data) -> X == ((Coordinates*)coordinates) -> X
        && ((CityData*)data) -> Y == ((Coordinates*)coordinates) -> Y)
        return 0;

    return -1;
}
