#include <stdio.h>
#include "database.h"
#include "binary_tree.h"
#include "city_data.h"
#include "vector.h"
#include "debug_helper.h"
#include "input_helper.h"

void menu();
void search_menu();
void delete_menu();

int main() {

    /* Initialize the database to work with CityData */
    Database* mydatabase = newDatabase(compare_name, compare_id, printCityUtil);

    /* Initial Data */
    mydatabase -> add(mydatabase,
            newCity("Bangalore", 13, 78,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Koramangala,"),
                            new_string("Kalyan Nagar,"),
                            new_string("Peenya Industrial Layout"),
                            new_string("Sanjay Nagar"),
                            new_string("Yeshwanthpur"))));
    mydatabase -> add(mydatabase,
            newCity("Chennai", 13, 80,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Kovalam,"),
                            new_string("Mahabalipuram,"),
                            new_string("Mylapore"))));
    mydatabase -> add(mydatabase,
            newCity("Delhi", 29, 77,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Rajpath Marg,"),
                            new_string("South Delhi,"),
                            new_string("Netaji Subhash Marg,"),
                            new_string("Shambhu Dayal Bagh"))));
    mydatabase -> add(mydatabase,
            newCity("Bhubaneshwar", 20, 86,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Khandagiri,"),
                            new_string("Anand Bazar,"),
                            new_string("Madhusudan Nagar"))));
    mydatabase -> add(mydatabase,
            newCity("Bhopal", 23, 77,
                    newMinimalVectorWithArgs(string_compare, printAddressUtil,
                            new_string("Van Vihar,"),
                            new_string("Lower Lake,"),
                            new_string("Peer Gate"))));
    int choice;
    while(1) {
        menu();
        choice = next_int();
        switch (choice) {
            case 1: {
                printCityDataHeader();
                mydatabase->print(mydatabase);
            }
                break;
            case 2: {
                mydatabase->add(mydatabase, readInputCity());
            }
                break;
            case 3: {
                search_menu();
                char* input;
                choice = next_int();
                switch (choice) {
                    case 1: {
                        printf("\nEnter City Name : ");
                        get_word(&input);
                        printCityDataHeader();
                        mydatabase -> search(mydatabase, input, compare_data_and_name);
                        free(input);
                    }
                        break;
                    case 2: {
                        int X, Y;
                        printf("\nEnter Coordinates : ");
                        X = next_int(); Y = next_int();
                        Coordinates* coordinates = newCoordinates(X, Y);
                        linear_search_database(mydatabase, coordinates, compare_data_and_coordinates);
                    }
                        break;
                    default:
                        break;
                }
            }
                break;
            case 4: {
                delete_menu();
                char* input;
                choice = next_int();
                switch (choice) {
                    case 1: {
                        printf("\nEnter City Name : ");
                        get_word(&input);
                        int index = linear_search_database(mydatabase, input, compare_data_and_name);
                        /* delete from the tree and then from the seq_data */
                        CityData* toDelete = mydatabase -> seq_data -> data[index];
                        /* Since the BST was made with name, use name as param to delete from tree */
                        mydatabase -> data_root = delete_from_tree(mydatabase -> data_root, toDelete -> name, compare_data_and_name);
                        mydatabase -> seq_data -> remove(mydatabase -> seq_data, index);
                        free(input);
                    }
                        break;
                    case 2: {
                        int X, Y;
                        printf("\nEnter Coordinates : ");
                        X = next_int(); Y = next_int();
                        Coordinates* coordinates = newCoordinates(X, Y);
                        int index = linear_search_database(mydatabase, coordinates, compare_data_and_coordinates);
                        /* delete from the tree and then from the seq_data */
                        CityData* toDelete = mydatabase -> seq_data -> data[index];
                        mydatabase -> data_root = delete_from_tree(mydatabase -> data_root, toDelete -> name, compare_data_and_name);
                        mydatabase -> seq_data -> remove(mydatabase -> seq_data, index);
                    }
                        break;
                    default:
                        break;
                }
            }
                break;
            case 5: {
                printCityDataHeader();
                mydatabase -> seq_data -> print(mydatabase -> seq_data);
            }
                break;
            case 6:
                return 0;
            default:
                break;
        }
    }
}

void menu() {
    printf("\n-------------CITY DATABASE-----------------------------\n"
           "1.\tView Database\n"
           "2.\tAdd City to Database\n"
           "3.\tSearch in Database\n"
           "4.\tDelete Records\n"
           "5.\tView Sequential Data\n"
           "6.\tExit\n"
           "Your Choice : ");
}

void search_menu() {
    printf("\n-------------SEARCH DATABASE---------------------------\n"
           "1.\tSearch by City Name\n"
           "2.\tSearch by Coordinates\n"
           "3.\tBack\n"
           "Your Choice : ");
}

void delete_menu() {
    printf("\n-------------DELETE RECORD-----------------------------\n"
           "1.\tDelete by City Name\n"
           "2.\tDelete by Coordinates\n"
           "3.\tBack\n"
           "Your Choice : ");
}