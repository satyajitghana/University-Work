#include <stdio.h>
#include "database.h"
#include "binary_tree.h"
#include "city_data.h"
#include "vector.h"
#include "debug_helper.h"
#include "input_helper.h"

void menu();
void sort_menu();

int main() {

    /* Initialize the database to work with CityData */
    Database* mydatabase = newDatabase(compare_name, compare_id, printCityUtil);

    /* Initial Data */
    mydatabase -> add(mydatabase,
            newCity("Bangalore", 13, 78,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Koramangala,"),
                            new_string("Kalyan Nagar"))));
    mydatabase -> add(mydatabase,
            newCity("Chennai", 13, 80,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Kovalam,"),
                            new_string("Mahabalipuram"))));
    mydatabase -> add(mydatabase,
            newCity("Delhi", 29, 77,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Rajpath Marg,"),
                            new_string("South Delhi"))));
    mydatabase -> add(mydatabase,
            newCity("Bhubaneshwar", 20, 86,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Khandagiri"))));
    mydatabase -> add(mydatabase,
            newCity("Bhopal", 23, 77,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Van Vihar,"))));
    int choice;
    while(1) {
        menu();
        choice = next_int();
        switch (choice) {
            case 1: {
                printCityDataHeader();
                mydatabase -> seq_data -> print(mydatabase -> seq_data);
            }
                break;
            case 2: {
                sort_menu();
                choice = next_int();
                switch (choice) {
                    case 1: {
                        printf("\nSorting by City Name");
                        mydatabase -> seqComparator = compare_name;
                        mydatabase -> sortSeqData(mydatabase);
                        printf("\nSORTED !\n");
                    }
                        break;
                    case 2: {
                        printf("\nSorting by City ID");
                        mydatabase -> seqComparator = compare_id;
                        mydatabase -> sortSeqData(mydatabase);
                        printf("\nSORTED !\n");
                    }
                        break;
                    default:
                        break;
                }
            }
                break;
            case 3:
                return 0;
            default:
                break;
        }
    }
}

void menu() {
    printf("\n-------------CITY DATABASE-----------------------------\n"
           "1.\tView Database\n"
           "2.\tSort Database\n"
           "3.\tExit\n"
           "Your Choice : ");
}

void sort_menu() {
    printf("\n-------------Sort DATABASE---------------------------\n"
           "1.\tSort by City Name\n"
           "2.\tSort by ID\n"
           "3.\tBack\n"
           "Your Choice : ");
}