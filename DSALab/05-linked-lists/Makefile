CC=gcc
CFLAGS=-I.
OUTPUT=llist

build: main.o input_helper.o linked_list.o
	$(CC) main.o input_helper.o linked_list.o -o $(OUTPUT)

main.o: main.c
	$(CC) -c main.c

input_helper.o: input_helper.c input_helper.h
	$(CC) -c input_helper.c

linked_list.o: linked_list.c linked_list.h
	$(CC) -c linked_list.c

clean:
	rm *.o $(OUTPUT)
